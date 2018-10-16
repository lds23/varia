import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import pl.meetme.FilteredIterator;

public class FilteredIteratorTest {

    @Test
    public void filterSequence1to4IntsTest() {

        // given
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4);

        //when
        Iterator<Integer> result = new FilteredIterator<>(input.iterator(), i -> i % 2 == 0);

        //then
        assertThat(result).contains(2, 4);
    }

    @Test
    public void filterSequence1to4DoublesTest() {
        // given
        Collection<Double> input = Arrays.asList(1.0, 2.0, 3.0, 4.0);

        //when
        Iterator<Double> result = new FilteredIterator<>(input.iterator(), i -> i % 2 == 0);

        //then
        assertThat(result).contains(2.0, 4.0);
    }

    @Test
    public void filterEmpty() {
        // given
        Collection<String> input = new LinkedList();

        //when
        Iterator<String> result = new FilteredIterator<>(input.iterator(), i -> i.length() > 5);

        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void filterNull() {
        // given

        //when
        Iterator<String> result = new FilteredIterator<>(null, i -> i.length() > 5);

        //then
        assertThat(result).isEmpty();
    }
}
