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
    public void whenReplaceTestItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(new String[] {
                "0", String.valueOf(one.getId()),
                replaceName, "1"});

        UserAction[] actions = {
                new EditAction(out),
                new ExitProgramAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is(replaceName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new String[]
                {"0","1", "1"});
        UserAction[] actions = {
                new DeleteAction(out),
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

    @Test
    public void whenReplaceTestOutput() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(new String[] {
                "0", String.valueOf(one.getId()),
                replaceName, "1"});

        UserAction[] actions = {
                new EditAction(out),
                new ExitProgramAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ====" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                )
        );
    }
}