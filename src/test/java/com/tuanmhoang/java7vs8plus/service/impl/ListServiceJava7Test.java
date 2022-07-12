package com.tuanmhoang.java7vs8plus.service.impl;

import com.tuanmhoang.java7vs8plus.service.ListService;
import com.tuanmhoang.java7vs8plus.service.data.DataHelper;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListServiceJava7Test {

    private final ListService listService = new ListServiceJava7();

    @Test
    public void givenListData_whenCallSum_thenShouldCalculateCorrectly() {
        // given
        List<Integer> data = DataHelper.createMockDataForSum();
        int expected = 614;

        // when
        int result = listService.sum(data);

        // then
        assertEquals(expected, result);
    }

    @Test
    void givenListData_whenCallGetMostFrequentWords_shouldCorrect() {
        // given
        List<String> data = DataHelper.createMockDataForFrequent();
        Map<String, Integer> expected = DataHelper.createExpectedFrequencyResult();


        // when
        Map<String, Integer> result = listService.getMostFrequentWords(data);

        // then
        assertEquals(expected, result);
    }

    @Test
    void givenListData_whenCallGetDuplicatedWords_shouldCorrect() {
        // given
        List<String> data = DataHelper.createMockDataForDuplicated();
        List<String> expected = DataHelper.createExpectedDuplicatedResult();

        // when
        List<String> result = listService.getDuplicates(data);

        // then
        assertEquals(expected, result);
    }
}
