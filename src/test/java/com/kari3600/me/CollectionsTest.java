package com.kari3600.me;

import com.kari3600.me.utils.collections.KeyedMap;
import com.kari3600.me.utils.collections.WrappedKeyedMap;
import com.kari3600.me.utils.object.key.Key;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {
    public record SimpleKey<T>(String key, Class<T> type) implements Key<T, SimpleKey<T>> {
        @Override
        public SimpleKey<T> self() {
            return this;
        }
    }

    @Test
    public void keyedMapTest() {
        SimpleKey<String> usernameKey = new SimpleKey<>("username", String.class);
        SimpleKey<Integer> scoreKey = new SimpleKey<>("score", Integer.class);

        KeyedMap<SimpleKey<?>> userData = new WrappedKeyedMap<>(new HashMap<>());

        userData.put(usernameKey, "test_name");
        userData.put(scoreKey, 1000);

        assertEquals("test_name", userData.get(usernameKey));
        assertEquals(1000, userData.get(scoreKey));
    }
}
