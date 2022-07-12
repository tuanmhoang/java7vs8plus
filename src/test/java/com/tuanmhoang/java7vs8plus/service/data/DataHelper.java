package com.tuanmhoang.java7vs8plus.service.data;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class DataHelper {

    private static final int DEFAULT_NUMBER_OF_ELEMENTS_TO_GENERATE = 100000000;

    public static List<Integer> createMockDataForSum() {
        return Arrays.asList(1, 5, 3, 5, 2, 5, 123, 334, 13, 123);
    }

    public static List<Integer> createMockDataWithLargeElements() {
        return createDataWithNumberOfElements(DEFAULT_NUMBER_OF_ELEMENTS_TO_GENERATE);
    }


    public static List<Integer> createMockDataWithLargeElementsDynamics(int numberOfElements) {
        return createDataWithNumberOfElements(numberOfElements);
    }

    private static List<Integer> createDataWithNumberOfElements(int numberOfElements) {
        List<Integer> data = new ArrayList<>();
        Random rand = new Random();
        int[] arr = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            data.add(rand.nextInt(101) + 1); // 1..100
        }
        return data;
    }

    public static List<String> createMockDataForFrequent() {
        return Arrays.asList("aa", "bb", "bb", "Aa", "aa", "cc", "dd", "aa", "eee", "aaa", "zz", "yy", "yy", "zz", "ff");
    }

    public static List<String> createMockDataForFrequentLargeElements() {
        return createMockDataForFrequentLargeElementsWithNumberOfElements(DEFAULT_NUMBER_OF_ELEMENTS_TO_GENERATE);
    }

    public static List<String> createMockDataForFrequentLargeElements(int numberOfElements) {
        return createMockDataForFrequentLargeElementsWithNumberOfElements(numberOfElements);
    }

    private static List<String> createMockDataForFrequentLargeElementsWithNumberOfElements(int numberOfElementsToGenerate) {
        String[] data = new String[numberOfElementsToGenerate];
        for (int i = 0; i < numberOfElementsToGenerate; i++) {
            data[i] = RandomStringUtils.randomAlphabetic(2);
        }
        System.out.println("Done generating mock data with random string. Number of generated elements: " + numberOfElementsToGenerate);
        return Arrays.asList(data);
    }

    public static List<String> createMockDataForDuplicated() {
        return Arrays.asList("hello", "good Morning", "GOOD MORNING", "Hello", "not duplicated", "nOt dUPlicated", "not duplicatED", "duplicated :D");
    }

    public static Map<String, Integer> createExpectedFrequencyResult() {
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("aa", 3);
        expected.put("bb", 2);
        expected.put("yy", 2);
        expected.put("zz", 2);
        expected.put("Aa", 1);
        expected.put("aaa", 1);
        expected.put("cc", 1);
        expected.put("dd", 1);
        expected.put("eee", 1);
        expected.put("ff", 1);
        return expected;
    }

    public static List<String> createExpectedDuplicatedResult() {
        return Arrays.asList("good morning", "hello", "not duplicated");
    }
}
