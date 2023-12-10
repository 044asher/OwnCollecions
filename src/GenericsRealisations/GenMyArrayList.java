package GenericsRealisations;

import GenericsInterfaces.GenMyList;

import java.util.Arrays;

public class GenMyArrayList<T> implements GenMyList<T> {
    private static final int START_CAPACITY = 10;
    private Object[] array;
    private int size;

    public GenMyArrayList() {
        this.array = new Object[START_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T object) {
        return indexOf(object) >= 0;
    }

    @Override
    public void add(T object) {
        if (size == array.length) {
            resize();
        }
        array[size++] = object;
    }

    @Override
    public void add(int index, T object) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be less than zero!");
        } else if (index > size) {
            index = size;
        } else if (size == array.length) {
            resize();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = object;
        size++;
    }

    @Override
    public boolean remove(T object) {
        int i = indexOf(object);
        if (i == -1) {
            return false;
        }
        System.arraycopy(array, i + 1, array, i, size - i - 1);
        array[--size] = null;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) array[index];
    }

    @Override
    public int indexOf(T object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T object) {
        for (int i = size - 1; i >= 0; i--) {
            if (object.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    private void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    @Override
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

