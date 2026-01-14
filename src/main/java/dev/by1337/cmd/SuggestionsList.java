package dev.by1337.cmd;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class SuggestionsList {
    private final String[] suggestions;
    private final String source;
    private String remaining;
    private int start;
    private int count;

    public SuggestionsList(int limit, String source, int start) {
        suggestions = new String[limit];
        this.source = source;
        this.start = start;
        remaining = source.substring(start);
    }

    public SuggestionsList suggest(String text) {
        if (!text.equals(remaining) && count < suggestions.length) {
            suggestions[count++] = text;
        }
        return this;
    }

    public void setStart(int start) {
        this.start = start;
        remaining = source.substring(start);
        count = 0;
    }

    public void forEach(Consumer<String> consumer) {
        for (int i = 0; i < count; i++) {
            consumer.accept(suggestions[i]);
        }
    }

    public boolean hasFree(){
        return count < suggestions.length;
    }

    public int start() {
        return start;
    }

    public int count() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public List<String> toList() {
        if (count == 0) return List.of();
        return List.of(Arrays.copyOfRange(suggestions, 0, count));
    }

    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    public String getRemaining() {
        return remaining;
    }

    public String getSource() {
        return source;
    }
}
