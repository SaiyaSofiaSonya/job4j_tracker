package ru.job4j.tracker;

import org.junit.Test;
import java.util.Scanner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest{

    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitProgramAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new ConsoleOutput();
        Input in = new StubInput(new String[] {
                "0", "Item name", "1", "1",
                "Edited name", "2"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out), new EditAction(out),
                new ExitProgramAction(out)
        };
       new StartUI(out).init(in, tracker, actions);
       assertThat(tracker.findAll()[0].getName(), is("Edited name"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Input in = new StubInput(new String[]
                {"0", "Item name", "1", "1", "2"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out), new DeleteAction(out),
                new ExitProgramAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(1));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
                );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgramAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator()
        ));
    }
}