package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ItemDescByNameTest {

    @Test
    public void testCompareDesc() {
        List<Item> in = Arrays.asList(
                new Item(1,"vasya"),
                new Item(4, "anya"),
                new Item(2, "kolya")
        );
        Collections.sort(in, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(1,"vasya"),
                new Item(2, "kolya"),
                new Item(4, "anya")
        );
        assertThat(in, is(expected));
    }
}