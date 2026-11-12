package com.kari3600.me;

import com.kari3600.me.utils.collections.CollectionUtil;
import com.kari3600.me.utils.iteration.Iter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class CombinationsIterTest {
    @Test
    public void test1() {
        List<List<Integer>> vals = List.of(
                List.of(1,2),
                List.of(3,4,5),
                List.of(6,7)
        );
        List<List<Integer>> expected = List.of(
                List.of(1,3,6),
                List.of(1,3,7),
                List.of(1,4,6),
                List.of(1,4,7),
                List.of(1,5,6),
                List.of(1,5,7),
                List.of(2,3,6),
                List.of(2,3,7),
                List.of(2,4,6),
                List.of(2,4,7),
                List.of(2,5,6),
                List.of(2,5,7)
        );
        Iter<List<Integer>> iter = CollectionUtil.combinations(vals);
        List<List<Integer>> actual = new ArrayList<>();
        while (iter.next()) {
            actual.add(iter.get());
        }
        assertIterableEquals(expected, actual);
    }
}
