package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        List<String> list = List.of("one", "1");
        Input in = new StubInput(list);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        List<String> list = List.of("1");
        Input in = new StubInput(list);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidMultiInput() {
        Output out = new StubOutput();
        List<String> list = List.of("0", "1");
        Input in = new StubInput(list);
        ValidateInput input = new ValidateInput(out, in);
        int [] selected = {input.askInt("Enter menu:"), input.askInt("Enter menu:")};
        assertArrayEquals(selected, new int [] {0, 1});

    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        List<String> list = List.of("-1", "1");
        Input in = new StubInput(list);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}