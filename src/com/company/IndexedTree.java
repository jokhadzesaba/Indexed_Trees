package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexedTree<T> implements Iterable<T> {
    private Node<T> tree;

//    public IndexedTree(Node<T> tree) {
//        this.tree = tree;
//    }

    public int size() {
        return tree.size();
    }

    public T get(int i) {
        return tree.get(i);
    }

    public void update(int i, T x) {
        tree.update(i, x);
    }

    public void insert(int i, T x) {
        tree = tree.insert(i, x);
    }

    public void remove(int i) {
        tree = tree.remove(i);
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(index++);
            }
        };
    }
}




