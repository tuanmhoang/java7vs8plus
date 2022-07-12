package com.tuanmhoang.java7vs8plus.service.impl;

import com.tuanmhoang.java7vs8plus.service.ListService;

import java.util.*;
import java.util.stream.Collectors;

public class ListServiceJava8Parallel implements ListService {
    @Override
    public int sum(List<Integer> numbers) {
        return numbers.stream().parallel().reduce(0, (a, b) -> a + b);
    }

    @Override
    public Map<String, Integer> getMostFrequentWords(List<String> words) {
        return words
                .stream()
                .parallel()
                .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum))
                .entrySet()
                .stream()
                .parallel()
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
                .parallel()
                .map(String::toLowerCase)
                .filter(e -> !uniques.add(e))
                .collect(Collectors.toSet());
        return new ArrayList<>(duplicatedSet);
    }
}
