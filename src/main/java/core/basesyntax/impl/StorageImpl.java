package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final K[] keysArray = (K[]) new Object[10];
    private final V[] valuesArray = (V[]) new Object[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (size == 10) {
            System.out.println("The storage is full!");
            return;
        }

        int possibleIndex = -1;

        for (int i = 0; i < size; i++) {
            if (possibleIndex == -1) {
                possibleIndex = Objects.equals(keysArray[i], key) ? i : -1;
            }
        }

        if (possibleIndex == -1) {
            keysArray[size] = key;
            valuesArray[size] = value;

            size++;
        } else {
            valuesArray[possibleIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        int possibleIndex = -1;

        for (int i = 0; i < size; i++) {
            if (possibleIndex == -1) {
                possibleIndex = Objects.equals(keysArray[i], key) ? i : -1;
            }
        }

        if (possibleIndex == -1) {
            return null;
        } else {
            return valuesArray[possibleIndex];
        }
    }

    @Override
    public int size() {
        return size;
    }
}
