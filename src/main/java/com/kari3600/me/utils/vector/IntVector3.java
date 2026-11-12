package com.kari3600.me.utils.vector;

import java.util.Objects;

public class IntVector3 implements Vector3<Integer> {
    private final int x;
    private final int y;
    private final int z;
    public IntVector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
    public Integer getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector3<?> other)) return false;
        return Objects.equals(x, other.getX())
                && Objects.equals(y, other.getY())
                && Objects.equals(z, other.getZ());
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "IntVector3[" + x + ", " + y + ", " + z + "]";
    }
}
