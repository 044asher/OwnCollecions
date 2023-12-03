package Realisations;

import Interfaces.MyList;

import java.util.Arrays;

public class MyArrayList implements MyList {
    private static final int START_CAPACITY = 10;
    private Integer[] array;
    private int size;
    public MyArrayList(){
        this.array = new Integer[START_CAPACITY];
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
    public boolean contains(Integer object) {
        return indexOf(object) >= 0;
    }

    @Override
    public void add(Integer object) {
        if(size == array.length) {
            ensureCapacity();
        }
        array[size++] = object;
    }

    @Override
    public void add(int index, Integer object) {
        if (index < 0){
            throw new IndexOutOfBoundsException("Index cannot be less than zero!");
        }
        else if (index > size){
            index = size;
        }
        else if(size == array.length){
            ensureCapacity();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = object;
        size++;
    }

    @Override
    public boolean remove(Integer object) {
        int i = indexOf(object);
        if(i == -1){
            return false;
        }
        System.arraycopy(array, i + 1, array, i, size - i - 1); //i+1 т.к копируемая часть начинается с элемента, следующего за тем, который нужно удалить. size - index - 1: количество элементов, которые нужно скопировать.
        array[size - 1] = null;
        size--;
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
    public Integer get(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    @Override
    public int indexOf(Integer object) {
        for (int i = 0; i < size; i++) {
            if(object.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer object) {
        for (int i = size - 1; i >= 0; i--) {
            if(object.equals(array[i])){
                return i;
            }
        }
        return -1;
    }
    private void ensureCapacity(){
        array = Arrays.copyOf(array, array.length * 2);
    }
    @Override
    public void printArray(){
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
}
