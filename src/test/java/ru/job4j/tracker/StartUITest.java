package ru.job4j.tracker;

import org.junit.Test;
import java.util.Scanner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest{

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitProgramAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Input in = new StubInput(new String[] {
                "0", "Item name", "1", "1",
                "Edited name", "2"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(), new EditAction(),
                new ExitProgramAction()
        };
       new StartUI().init(in, tracker, actions);
       assertThat(tracker.findAll()[0].getName(), is("Edited name"));
    }

    @Test
    public void whenDeleteItem() {
        Input in = new StubInput(new String[]
                {"0", "Item name", "1", "1", "2"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(), new DeleteAction(),
                new ExitProgramAction()
        };
        new StartUI().init(in, tracker, actions);
        assertNull(tracker.findById(1));
    }
}