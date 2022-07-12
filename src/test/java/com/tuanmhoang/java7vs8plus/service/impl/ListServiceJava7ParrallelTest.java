package com.tuanmhoang.java7vs8plus.service.impl;

import com.tuanmhoang.java7vs8plus.service.ListService;
import com.tuanmhoang.java7vs8plus.service.data.DataHelper;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListServiceJava7ParrallelTest {

    private final ListService listServiceParrallel = new ListServiceJava7Parrallel();

    private final ListService listServiceSingle = new ListServiceJava7();

    private ListServiceJava7 service = new ListServiceJava7();

    @Test
    public void givenListData_whenCallSum_thenShouldCalculateCorrectly() {
        // given
        List<Integer> data = DataHelper.createMockDataWithLargeElements();
        long startTime = System.currentTimeMillis();
        int expected = listServiceSingle.sum(data);
        System.out.println("[listServiceSingle.sum] Execution time: " + (System.currentTimeMillis() - startTime));
        System.out.println("[listServiceSingle.sum] Result: " + expected);

        // when
        int result = listServiceParrallel.sum(data);

        // then
        assertEquals(expected, result);
    }

    @Test
    void givenListData_whenCallGetMostFrequentWords_shouldCorrect() {
        // given
        List<String> data = DataHelper.createMockDataForFrequent();
        Map<String, Integer> expected = DataHelper.createExpectedFrequencyResult();


        // when
        Map<String, Integer> result = listServiceParrallel.getMostFrequentWords(data);

        // then
        assertEquals(expected, result);
    }

    @Test
    void givenListData_whenCallGetDuplicatedWords_shouldCorrect() {
        // given
        List<String> data = DataHelper.createMockDataForDuplicated();
        List<String> expected = DataHelper.createExpectedDuplicatedResult();

        // when
        List<String> result = listServiceParrallel.getDuplicates(data);

        // then
        assertEquals(expected, result);
    }
}
