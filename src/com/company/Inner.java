package com.company;

public class Inner<T> implements Node<T> {
    private Node<T> left;
    private Node<T> right;
    private int lsize;
    private int rsize;

    public Inner(Node<T> left, Node<T> right) {
        this.left = left;
        this.right = right;
        this.lsize = left.size();
        this.rsize = right.size();
    }

    @Override
    public int size() {
        return lsize + rsize;
    }

    @Override
    public T get(int i) {
        if (i < lsize) {
            return left.get(i);
        } else if (i < size()) {
            return right.get(i - lsize);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void update(int i, T x) {
        if (i < lsize) {
            left.update(i, x);
        } else if (i < size()) {
            right.update(i - lsize, x);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Node<T> insert(int i, T x) {
        if (i < lsize) {
            return new Inner<T>(left.insert(i, x), right);
        } else if (i < size()) {
            return new Inner<T>(left, right.insert(i - lsize, x));
        } else {
            return new Inner<T>(left, new Leaf<T>(x));
        }
    }

    @Override
    public Node<T> remove(int i) {
        if (i < lsize) {
            return new Inner<T>(left.remove(i), right);
        } else if (i < size()) {
            return new Inner<T>(left, right.remove(i - lsize));
        } else
            throw new IndexOutOfBoundsException();
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public int getLsize() {
        return lsize;
    }

    public int getRsize() {
        return rsize;
    }
}
