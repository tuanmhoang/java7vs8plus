package com.tuanmhoang.java7vs8plus.service.impl;

import com.tuanmhoang.java7vs8plus.service.ListService;

import java.util.*;

public class ListServiceJava7 implements ListService {
    @Override
    public int sum(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }
    @Override
    public Map<String, Integer> getMostFrequentWords(List<String> words) {
        // built Map of keywords and their frequent times
        Map<String, Integer> wordsFrequencyMap = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!wordsFrequencyMap.containsKey(word)) {
                wordsFrequencyMap.put(word, 1);
            } else {
                wordsFrequencyMap.put(word, wordsFrequencyMap.get(word) + 1);
            }
        }

        // parse into list
        List<Map.Entry<String, Integer>> listEntries = new ArrayList<>(wordsFrequencyMap.entrySet());
        // sort
        Collections.sort(listEntries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1,
                               Map.Entry<String, Integer> e2) {
                int comparedResult = e2.getValue().compareTo(e1.getValue());
                if (comparedResult == 0) {
                    comparedResult = e1.getKey().compareTo(e2.getKey());
                }
                return comparedResult;
            }
        });

        // convert List entries to LinkedHashMap
        LinkedHashMap<String, Integer> finalResult = new LinkedHashMap<>();
        for (int i = 0; i < listEntries.size(); i++) {
            finalResult.put(listEntries.get(i).getKey(), listEntries.get(i).getValue());
        }

        return finalResult;
    }

    @Override
    public List<String> getDuplicates(List<String> words) {

        // #1 approach
        // built Map of keywords and their frequent times
//        Map<String, Integer> wordsFrequencyMap = new HashMap<>();
//        for (int i = 0; i < words.size(); i++) {
//            String word = words.get(i).toLowerCase();
//            if (!wordsFrequencyMap.containsKey(word)) {
//                wordsFrequencyMap.put(word, 1);
//            } else {
//                wordsFrequencyMap.put(word, wordsFrequencyMap.get(word) + 1);
//            }
//        }
//
//        // built list result
//        List<String> result = new ArrayList<>();
//        for (Map.Entry entry : wordsFrequencyMap.entrySet()) {
//            if ((int) entry.getValue() > 1) {
//                result.add((String) entry.getKey());
//            }
//        }
        //return result;

        // #2 approach

        final Set<String> setToReturn = new LinkedHashSet<>();
        final Set<String> tempSet = new HashSet<>();

        for (String word : words) {
            if (!tempSet.add(word.toLowerCase())) {
                setToReturn.add(word.toLowerCase());
            }
        }
        return new ArrayList<>(setToReturn);
    }
}
