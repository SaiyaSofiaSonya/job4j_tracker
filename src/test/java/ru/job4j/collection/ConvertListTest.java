package ru.job4j.collection;

import org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertListTest{

    @Test
    public void whenTwoLists() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1,2});
        in.add(new int[] {3});
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertThat(ConvertList.convert(in), is(expected));
    }
}