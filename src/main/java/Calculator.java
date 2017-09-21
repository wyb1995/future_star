import org.omg.CORBA.INTERNAL;

import java.util.*;
import java.util.stream.Collectors;

class Calculator {
    int sum(List<Integer> integers) {
        return integers.stream().filter(item -> item % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    Map<String, Integer> sort(List<String> strings) {
        Collections.sort(strings);
        Map<String, Integer> map = new LinkedHashMap<>();
        strings.forEach(item -> map.put(item, item.length()));
        return map;
    }

    String getCharNumberString(String input) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(input.split(""))
                .forEach(item->{
                    if(map.containsKey(item)){
                        map.replace(item, map.get(item) + 1);
                    }else{
                        map.put(item, 1);
                    }
                });
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(item -> item.getValue() + "(" + item.getKey() + ")")
                .collect(Collectors.joining(" < "));
    }
}
