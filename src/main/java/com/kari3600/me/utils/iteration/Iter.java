package com.kari3600.me.utils.iteration;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Reimplementation of {@link Iterator}, allowing retrieving current element
 * multiple times without having to store it in a variable.
 *
 * <p>It is possible to convert between Iter and Iterator
 * using {@link Iter#asIterator()} and {@link Iter#ofIterator(Iterator)}
 */
public interface Iter<T> {
    /**
     * Jumps to the next value and checks whether it exist
     *
     * @return whether the next value exist or not
     */
    boolean next();

    /**
     * Retrieves the current value
     *
     * @return the current value
     */
    T get();

    /**
     * Wraps {@link Iterator} as {@link Iter}
     *
     * @param iterator iterator to wrap
     * @return wrapping implementation of {@link Iter}
     */
    static <T> Iter<T> ofIterator(Iterator<T> iterator) {
        return new WrappedIter<>(iterator);
    }

    /**
     * Wraps this {@link Iter} as {@link Iterator}
     *
     * @return wrapping implementation of {@link Iterator}
     */
    default Iterator<T> asIterator() {
        return new UnwrappedIter<>(this);
    }

    /**
     * Creates a stream of the iteration
     *
     * @return created stream
     */
    default Stream<T> asStream() {
        // TODO create own implementation
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(asIterator(), 0),
                false
        );
    }
}
