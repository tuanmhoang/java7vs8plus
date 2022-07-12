package com.tuanmhoang.java7vs8plus.service.impl;

import com.tuanmhoang.java7vs8plus.service.ListService;
import com.tuanmhoang.java7vs8plus.service.data.DataHelper;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListServiceJava8ParallelTest {
    private ListService listServiceSingle = new ListServiceJava8();
    private ListService listServiceParrallel = new ListServiceJava8Parallel();

    @Test
    public void givenList_whenCallSum_thenShouldCalculateCorrectly() {
        // given
        List<Integer> data = DataHelper.createMockDataWithLargeElements();
        long startTime = System.currentTimeMillis();
        int expected = listServiceSingle.sum(data);
        System.out.println("[listServiceSingle.sum] Execution time: " + (System.currentTimeMillis() - startTime));
        System.out.println("[listServiceSingle.sum] Result: " + expected);

        // when
        startTime = System.currentTimeMillis();
        int result = listServiceParrallel.sum(data);
        System.out.println("[listServiceParrallel.sum] Execution time: " + (System.currentTimeMillis() - startTime));
        System.out.println("[listServiceParrallel.sum] Result: " + result);

        // then
        assertEquals(expected, result);
    }

    @Test
    void givenListData_whenCallGetMostFrequentWords_shouldCorrect() {
        // given
        List<String> data = DataHelper.createMockDataForFrequentLargeElements(100000);
        long startTime = System.currentTimeMillis();
        Map<String, Integer> expected = listServiceSingle.getMostFrequentWords(data);
        System.out.println("[listServiceSingle.getMostFrequentWords] Execution time: " + (System.currentTimeMillis() - startTime));

        // when
        startTime = System.currentTimeMillis();
        Map<String, Integer> result = listServiceParrallel.getMostFrequentWords(data);
        System.out.println("[listServiceParrallel.getMostFrequentWords] Execution time: " + (System.currentTimeMillis() - startTime));

        // then
        assertEquals(expected, result);
        System.out.println(result);
    }

    @Test
    void givenListData_whenCallGetDuplicatedWords_shouldCorrect() {
        // given
        List<String> data = DataHelper.createMockDataForFrequentLargeElements(100000);
        long startTime = System.currentTimeMillis();
        List<String> expected = listServiceSingle.getDuplicates(data);
        System.out.println("[listServiceSingle.getMostFrequentWords] Execution time: " + (System.currentTimeMillis() - startTime));

        // when
        startTime = System.currentTimeMillis();
        List<String> result = listServiceParrallel.getDuplicates(data);
        System.out.println("[listServiceSingle.getMostFrequentWords] Execution time: " + (System.currentTimeMillis() - startTime));
        
        // then
        assertEquals(expected, result);
    }
}
