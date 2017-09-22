import com.thoughtworks.firstProject.Calculator;
import com.thoughtworks.firstProject.sorter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FutureStarTest {

    @Test
    public void should_return_all_even_number_sum() throws Exception {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        assertThat(Calculator.sumEvens(number), is(30));
    }

    @Test
    public void should_return_sorted_map() throws Exception {
        List<String> letters = Arrays.asList("ynpan", "yzqi", "ybowang", "qiqzhao", "yibtan", "abc", "sjyuan");

        assertThat(sorter.sortLetters(letters).values(), contains(3, 7, 6, 7, 6, 5, 4));
        assertThat(sorter.sortLetters(letters).keySet(), contains("abc", "qiqzhao", "sjyuan", "ybowang", "yibtan", "ynpan", "yzqi"));
    }

    @Test
    public void should_return_char_number_string() throws Exception {
        String letters = "aababbbcabcdabcde";

        assertThat(sorter.countWordLengthAsc(letters), is("5(a) < 6(b) < 3(c) < 2(d) < 1(e)"));
    }
}
