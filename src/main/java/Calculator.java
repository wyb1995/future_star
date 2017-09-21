import java.util.*;
import java.util.stream.Collectors;

class Calculator {
    static int sum(List<Integer> numbers) {
        return numbers.stream().filter(item -> item % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    static Map<String, Integer> sort(List<String> emailNames) {
        Collections.sort(emailNames);

        Map<String, Integer> output = new LinkedHashMap<>();

        emailNames.forEach(item -> output.put(item, item.length()));
        return output;
    }

    static String getCharNumberString(String emailNames) {
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
