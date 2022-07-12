package com.tuanmhoang.java7vs8plus.service.impl;

import com.tuanmhoang.java7vs8plus.service.ListService;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListServiceJava8 implements ListService {
    @Override
    public int sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, (a, b) -> a + b);
    }

    @Override
    public Map<String, Integer> getMostFrequentWords(List<String> words) {
        return words
                .stream()
                .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> y, LinkedHashMap::new
                ));
    }

    @Override
    public List<String> getDuplicates(List<String> words) {
        Set<String> uniques = new HashSet<>();
        var duplicatedSet = words.stream()
                .map(String::toLowerCase)
                .filter(e -> !uniques.add(e))
                .collect(Collectors.toSet());
        return new ArrayList<>(duplicatedSet);
    }
}
