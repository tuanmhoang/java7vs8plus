package com.tuanmhoang.java7vs8plus.service.impl;

import com.tuanmhoang.java7vs8plus.service.ListService;
import com.tuanmhoang.java7vs8plus.service.SumThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ListServiceJava7Parrallel implements ListService {
    @Override
    public int sum(List<Integer> numbers) {

        // get the processors to create threads
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int numbersSize = numbers.size();
        int threadSize = (int) Math.ceil(numbersSize * 1.0 / availableProcessors);

        Integer[] limits = new Integer[availableProcessors];
        for (int i = 0; i < availableProcessors; i++) {
            limits[i] = (i + 1) * threadSize;
        }

        List<List<Integer>> chunks = new ArrayList<>();

        List<Integer> chunk = new ArrayList<>();
        int limitsIndex = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numbersSize; i++) {
            chunk.add(numbers.get(i));
            if (limits[limitsIndex] <= i + 1) {
                chunks.add(chunk);
                if (i + 1 != numbersSize) {
                    limitsIndex++;
                    chunk = new ArrayList<>();
                }
            }
        }
        System.out.println("[build chunks] Execution time: " + (System.currentTimeMillis() - startTime));

        List<SumThread> sumThreads = new ArrayList<>();
        for (int i = 0; i < chunks.size(); i++) {
            SumThread sumThread = new SumThread(chunks.get(i));
            sumThreads.add(sumThread);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);
        int result = 0;
        startTime = System.currentTimeMillis();
        try {
            List<Future<Integer>> futures = executorService.invokeAll(sumThreads);
            for (Future<Integer> future : futures) {
                result += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        System.out.println("[multi thread] Execution time: " + (System.currentTimeMillis() - startTime));
        return result;

    }

    @Override
    public Map<String, Integer> getMostFrequentWords(List<String> words) {
        return null;
    }

    @Override
    public List<String> getDuplicates(List<String> words) {
        return null;
    }
}
