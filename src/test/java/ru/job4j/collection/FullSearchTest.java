package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest {

    @Test
    public void testExtractNumber() {
        List<Task> in = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );
        HashSet<String> expected = new HashSet<>(Arrays.asList(
                "1", "2"));
        assertThat(FullSearch.extractNumber(in), is(expected));
    }
}