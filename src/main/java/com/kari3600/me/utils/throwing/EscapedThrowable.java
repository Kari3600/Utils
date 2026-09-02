package com.kari3600.me.utils.throwing;

public class EscapedThrowable extends RuntimeException {
    private final Throwable throwable;
    public EscapedThrowable(Throwable throwable) {
        super(throwable);
        this.throwable = throwable;
    }

    public <E extends Throwable> E getWrappedThrowable() {
        return (E) throwable;
    };
}
