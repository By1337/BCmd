package dev.by1337.cmd;

import org.jetbrains.annotations.Contract;

public class CommandReader {
    private final String src;
    private final int size;
    private int ridx;

    private CommandReader(String src, int size) {
        this.src = src;
        this.size = size;
    }

    public CommandReader(String src) {
        this.src = src;
        this.size = src.length();
    }

    public String src() {
        return src;
    }

    public void skip() {
        ridx++;
    }

    public char next() {
        if (ridx < size) {
            return src.charAt(ridx++);
        }
        ridx++;
        return '\0';
    }

    @Contract(pure = true)
    public char peek() {
        if (ridx < size) {
            return src.charAt(ridx);
        }
        return '\0';
    }

    public boolean hasNext() {
        return ridx < size;
    }

    public void back() {
        ridx--;
    }

    public int ridx() {
        return ridx;
    }

    public void ridx(int ridx) {
        this.ridx = ridx;
    }

    public int length() {
        return src.length();
    }

    public String readString() {
        char c = next();
        if (c == '\0') return "";
        if (c == '"' || c == '\'') {
            return readEscaped(c);
        }
        int start = ridx() - 1;
        int end = ridx();
        while (hasNext()) {
            c = next();
            if (c == ' ') {
                back();
                return src.substring(start, Math.min(end, size));
            }
            end = ridx;
        }
        return src.substring(start, Math.min(end, size));
    }

    private String readEscaped(char quoteChar) {
        StringBuilder sb = new StringBuilder();

        char last = '\0';
        while (hasNext()) {
            char c = next();
            if (c == quoteChar) {
                if (last == '\\') {
                    sb.setLength(sb.length() - 1);
                } else {
                    char next = peek();
                    if (next == ' ' || next == '\0') {
                        return sb.toString();
                    }
                }
            }
            sb.append(c);
            last = c;
        }
        return sb.toString();
    }

    public String report() {
        return "\n" + src + "\n" +
                " ".repeat(Math.max(0, ridx)) +
                "^ ridx=" + ridx + ", length=" + src.length();
    }
}

