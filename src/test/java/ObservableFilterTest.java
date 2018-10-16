import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;

import io.reactivex.Observable;

public class ObservableFilterTest {

    @Test
    public void filterSequence1to4IntsTest() {
        // given
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4);

        // when
        Observable<Integer> filteredObservable = Observable.fromIterable(input).filter(i -> i % 2 == 0);

        // then
        filteredObservable.test().assertValues(2, 4).assertComplete();
    }

    @Test
    public void filterSequence1to4DoublesTest() {

        // given
        Collection<Double> input = Arrays.asList(1.0, 2.0, 3.0, 4.0);

        // when
        Observable<Double> filteredObservable = Observable.fromIterable(input).filter(i -> i % 2 == 0);

        // then
        filteredObservable.test().assertValues(2.0, 4.0).assertComplete();
    }

    @Test
    public void filterSequenceStringsKeepLowercaseTest() {

        // given
        Collection<String> input = Arrays.asList("alpha", "beta", "Gamma", "Delta");

        // when
        Observable<String> filteredObservable = Observable.fromIterable(input).filter(s -> s.toLowerCase().equals(s));

        // then
        filteredObservable.test().assertValues("alpha", "beta").assertComplete();
    }

    @Test
    public void filterEmpty() {
        // given
        Collection<String> input = new LinkedList();

        // when
        Observable<String> filteredObservable = Observable.fromIterable(input).filter(s -> true);

        // then
        filteredObservable.test().assertComplete();
    }
}
