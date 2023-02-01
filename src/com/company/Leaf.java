package com.company;

public class Leaf<T> implements Node<T> {
    private T value;

    public Leaf(T value) {
        this.value = value;
    }

    public int size() {
        return 1;
    }

    public T get(int i) {
        if (i == 0) {
            return value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void update(int i, T x) {
        if (i == 0) {
            value = x;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Node<T> insert(int i, T x) {
        if (i == 0) {
            return new Inner<T>(new Leaf<T>(x), this);
        } else {
            return new Inner<T>(this, new Leaf<T>(x));
        }
    }

    public Node<T> remove(int i) {
        if(i==0)
            throw new IndexOutOfBoundsException();
        return null;

    }
}

