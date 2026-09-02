package com.kari3600.me.utils.reactive.variable;

public abstract class BindingBase<T> extends ObservableValueBase<T> implements Binding<T> {
    private boolean valid = false;

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public void invalidate() {
        valid = false;
        fireInvalidation();
    }

    protected abstract T findValue();

    @Override
    public T getValue() {
        if (!valid) {
            _setValue(findValue());
            valid = true;
        }
        return super.getValue();
    }
}
