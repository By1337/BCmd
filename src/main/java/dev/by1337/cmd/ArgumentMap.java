package dev.by1337.cmd;

import java.util.Arrays;
import java.util.Objects;

public class ArgumentMap {
    private String[] keys;
    private Object[] values;
    private int size;

    public ArgumentMap(int capacity) {
        keys = new String[capacity];
        values = new Object[capacity];
    }

    public Object put(String key, Object value) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                Object old = values[i];
                values[i] = value;
                return old;
            }
        }
        if (size == keys.length) grow();
        keys[size] = key;
        values[size] = value;
        size++;
        return null;
    }

    public Object get(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public Object getOrDefault(String key, Object def) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return def;
    }

    public Object getOrThrow(String key, String error) throws CommandMsgError {
        Object o = get(key);
        if (o != null) return o;
        throw new CommandMsgError(error);
    }

    public Object getByIndex(int index) {
        if (index < 0 || index >= size) return null;
        return values[index];
    }

    public boolean containsKey(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) return true;
        }
        return false;
    }

    private void grow() {
        int newCap = keys.length * 2;
        keys = java.util.Arrays.copyOf(keys, newCap);
        values = java.util.Arrays.copyOf(values, newCap);
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }

    public String toPrettyString() {
        if (size == 0) return "empty";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(keys[i]);
            sb.append("=");
            sb.append(values[i]);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public String toString() {
        if (size == 0) return "empty";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(keys[i]);
            sb.append("=");
            sb.append(values[i]);
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ArgumentMap that = (ArgumentMap) o;
        return size == that.size && Objects.deepEquals(keys, that.keys) && Objects.deepEquals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(keys), Arrays.hashCode(values), size);
    }
}
