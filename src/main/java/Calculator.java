import java.util.*;

class Calculator {
    static int sumEvens(List<Integer> numbers) {
        return numbers.stream().filter(item -> item % 2 == 0).mapToInt(Integer::intValue).sum();
    }
}
