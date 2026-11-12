package com.kari3600.me.utils.collections;

public class PairImpl<A,B> implements Pair<A,B> {
    private A left;
    private B right;

    public PairImpl() {

    }

    public PairImpl(A left, B right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void setLeft(A left) {
        this.left = left;
    }

    @Override
    public void setRight(B right) {
        this.right = right;
    }

    @Override
    public A getLeft() {
        return left;
    }

    @Override
    public B getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "(" + getLeft() + ", " + getRight() + ")";
    }
}
