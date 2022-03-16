package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest{

    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("Item name");
        list.add("1");
        Input in = new StubInput(list);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitProgramAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceTestItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add(String.valueOf(one.getId()));
        list.add(replaceName);
        list.add("1");
        Input in = new StubInput(list);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitProgramAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is(replaceName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add(String.valueOf(one.getId()));
        list.add("1");
        Input in = new StubInput(list);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitProgramAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(1));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        List<String> list = new ArrayList<>();
        list.add("0");
        Input in = new StubInput(list);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgramAction(out));
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
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add(String.valueOf(one.getId()));
        list.add(replaceName);
        list.add("1");
        Input in = new StubInput(list);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitProgramAction(out));
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

    @Test
    public void whenFindAllOutput() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        Input in = new StubInput(list);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllAction(out));
        actions.add(new ExitProgramAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                  "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ====" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                )
        );
    }

    @Test
    public void whenFindByNameOutput() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add(one.getName());
        list.add("1");
        Input in = new StubInput(list);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByNameAction(out));
        actions.add(new ExitProgramAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ====" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                )
        );
    }

    @Test
    public void whenFindByIdOutput() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add(String.valueOf(one.getId()));
        list.add("1");
        Input in = new StubInput(list);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByIdAction(out));
        actions.add(new ExitProgramAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ====" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                )
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        List<String> list = new ArrayList<>();
        list.add("84");
        list.add("0");
        Input in = new StubInput(list);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgramAction(out));
        new  StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 ...0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
        )
        );
    }
}