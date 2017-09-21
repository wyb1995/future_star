import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FutureStarTest {


    @Test
    public void should_return_all_even_number_sum() throws Exception {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        assertThat(Calculator.sum(integers), is(30));
    }

    @Test
    public void should_return_sorted_map() throws Exception {
        List<String> strings = Arrays.asList("ynpan", "yzqi", "ybowang", "qiqzhao", "yibtan", "abc", "sjyuan");

        assertThat(Calculator.sort(strings).values(), contains(3, 7, 6, 7, 6, 5, 4));
    }

    @Test
    public void should_return_char_number_string() throws Exception {
        String input = "aababbbcabcdabcde";

        assertThat(Calculator.getCharNumberString(input), is("5(a) < 6(b) < 3(c) < 2(d) < 1(e)"));
    }
}
