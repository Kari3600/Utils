package com.kari3600.me.utils.translator.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AbstractTypeAdapterFactory implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!rawType.isAnnotationPresent(JsonAbstractType.class)) return null;
        return new AbstractTypeAdapter<>(gson,rawType.getAnnotation(JsonAbstractType.class));
    }

    private static class AbstractTypeAdapter<T> extends TypeAdapter<T> {
        private final Gson gson;
        private final Map<String,Class<? extends T>> subtypes = new HashMap<>();

        public AbstractTypeAdapter(Gson gson, JsonAbstractType annotation) {
            this.gson = gson;
            for (JsonAbstractSubtype subtype : annotation.subtypes()) {
                subtypes.put(subtype.name(), (Class<? extends T>) subtype.subtype());
            }
        }

        @Override
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            for (Map.Entry<String,Class<? extends T>> entry : subtypes.entrySet()) {
                Class<? extends T> clazz = entry.getValue();
                if (!clazz.isAssignableFrom(t.getClass())) continue;
                jsonWriter.beginArray();
                jsonWriter.value(entry.getKey());
                gson.toJson(t, clazz, jsonWriter);
                jsonWriter.endArray();
                return;
            }
        }

        @Override
        public T read(JsonReader jsonReader) throws IOException {
            jsonReader.beginArray();
            String type = jsonReader.nextString();
            Class<? extends T> clazz = subtypes.get(type);
            if (clazz == null) throw new IllegalStateException("No such type: " + type);
            T t = gson.fromJson(jsonReader, clazz);
            jsonReader.endArray();
            return t;
        }
    }
}
