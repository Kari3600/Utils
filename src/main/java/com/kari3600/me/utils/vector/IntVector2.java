package com.kari3600.me.utils.vector;

import java.util.Objects;

public class IntVector2 implements Vector2<Integer> {
    private final int x;
    private final int y;

    public IntVector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public Integer getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector3<?> other)) return false;
        return Objects.equals(x, other.getX())
                && Objects.equals(y, other.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "IntVector2[" + x + ", " + y + "]";
    }
}
