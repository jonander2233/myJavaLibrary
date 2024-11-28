package org.jonander2233.lib_personal;

import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Leer<T> {
    private final InputStream inputStream;
    private final Function<String, T> parserFunction; // Función para parsear cada elemento JSON a T
    private final List<T> items;

    private Leer(InputStream inputStream, Function<String, T> parserFunction) {
        this.inputStream = inputStream;
        this.parserFunction = parserFunction;
        this.items = new ArrayList<>();
    }

    public static <T> Leer<T> of(InputStream inputStream, Function<String, T> parserFunction) {
        return new Leer<>(inputStream, parserFunction);
    }

    public boolean parse() {
        boolean parsed = false;
        try {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);

            for (int i = 0; i < jsonArray.length(); i++) {
                String jsonObject = jsonArray.getJSONObject(i).toString();
                T item = parserFunction.apply(jsonObject); // Convierte JSON a T
                items.add(item);
            }

            parsed = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parsed;
    }

    public List<T> getItems() {
        return items;
    }
}
