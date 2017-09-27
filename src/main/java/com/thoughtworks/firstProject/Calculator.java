package com.thoughtworks.firstProject;

import java.util.List;

public class Calculator {
    public static int sumEvens(List<Integer> numbers) {
        return numbers.stream().filter(item -> item % 2 == 0).mapToInt(Integer::intValue).sum();
    }
}
