package com.thoughtworks.firstProject;

import java.util.*;
import java.util.stream.Collectors;

public class sorter {
    public static Map<String, Integer> sortLetters(List<String> emailNames) {
        Collections.sort(emailNames);

        Map<String, Integer> output = new LinkedHashMap<>();

        emailNames.forEach(item -> output.put(item, item.length()));
        return output;
    }

    public static String countWordLengthAsc(String emailNames) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(emailNames.split(""))
                .forEach(item -> {
                    if (map.containsKey(item)) {
                        map.put(item, map.get(item) + 1);
                    } else {
                        map.put(item, 1);
                    }
                });

        return formatAsString(map);
    }

    private static String formatAsString(Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(item -> item.getValue() + "(" + item.getKey() + ")")
                .collect(Collectors.joining(" < "));
    }
}
