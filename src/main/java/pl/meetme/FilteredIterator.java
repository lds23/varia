package pl.meetme;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilteredIterator<T> implements Iterator<T> {

    private T nextResult;
    private final Iterator<T> input;
    private final Predicate<T> predicate;

    public FilteredIterator(final Iterator<T> input, Predicate<T> predicate) {
        this.input = input;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        if (nextResult != null) {
            return true;
        }

        if (input == null || !input.hasNext()) {
            return false;
        }

        T temp = input.next();
        while (!predicate.test(temp)) {
            temp = input.next();
        }
        nextResult = temp;

        return nextResult != null;
    }

    @Override
    public T next() {
        T result = nextResult;
        nextResult = null;
        return result;
    }

    @Override
    public void remove() {
        throw new RuntimeException("Unsupported operation");
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        while (hasNext()) {
            action.accept(next());
        }
    }
}
