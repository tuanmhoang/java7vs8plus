package com.tuanmhoang.java7vs8plus.service;

import java.util.List;
import java.util.Map;

public interface ListService {

    /**
     * Use this method to find a sum of integers.
     *
     * @param numbers list of integers to sum up
     * @return sum
     */
    int sum(List<Integer> numbers);

    /**
     * Use this method to find words frequency. Use Case Sensitive.
     *
     * @param words list of words
     * @return words along with their frequencies
     * (the output is sorted by frequency in descending order,
     * if frequencies are equal then sorted by words in alphabetical order)
     */
    Map<String, Integer> getMostFrequentWords(List<String> words);

    /**
     * Looks for duplicates (case insensitive, e.g. 'java' equals 'JaVA')
     *
     * @param words list of words
     * @return list with the words that have duplicates in the upper case sorted by length in ascending order,
     * if length is the same, sorted alphabetically
     */
    List<String> getDuplicates(List<String> words);
}
