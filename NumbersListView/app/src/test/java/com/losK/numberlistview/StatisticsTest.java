package com.losK.numberlistview;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class StatisticsTest {

    List<Integer> testList = Arrays.asList(2, 32, 3, 1, 12);

    @Test
    public void meanTestList() throws Exception {
        double result = Statistics.mean(testList);
        assert 10.0 == result;
    }

    @Test
    public void meanEmptyList() throws Exception {
        assert Statistics.mean(Collections.EMPTY_LIST) == 0;
    }

    @Test
    public void maxTestList() throws Exception {

        int result = Statistics.max(testList);
        assert 32 == result;
    }

    @Test(expected = IllegalArgumentException.class)
    public void maxEmptyList() throws Exception {
        Statistics.max(Collections.EMPTY_LIST);
    }

    @Test
    public void minTestList() throws Exception {

        int result = Statistics.min(testList);
        assert 1 == result;
    }

    @Test(expected = IllegalArgumentException.class)
    public void minEmptyList() throws Exception {
        Statistics.min(Collections.EMPTY_LIST);
    }
}