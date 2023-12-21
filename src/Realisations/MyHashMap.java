package Realisations;

import Interfaces.MyMap;


public class MyHashMap implements MyMap {
    private static final int START_CAPACITY = 16;
    private static final double THRESHOLD = 0.75;
    private Node[] table;
    private int size;

    private static class Node{
        private final String key;
        private Integer value;
        Node next;
        public Node(String key, Integer value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    public MyHashMap(){
        this.table = new Node[START_CAPACITY];
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
    public void put(String key, Integer value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new Node(key, value);
            size++;
            return;
        }
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        size++;

        if ((double) size / table.length > THRESHOLD) {
            resizeTable();
        }
    }

    @Override
    public boolean remove(String key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;
        while(current != null){
            if(current.key.equals(key)){
                if(prev == null){
                    table[index] = current.next;
                }
                else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0, len = table.length; i < len; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public Integer get(String key) {
        int index = hash(key);
        Node current = table[index];
        while(current != null){
            if(current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    @Override
    public String[] keyArray() {
        String[] keys = new String[size];
        int i = 0;
        for (Node current : table) {
            while (current != null) {
                keys[i++] = current.key;
                current = current.next;
            }
        }
        return keys;
    }

    @Override
    public Integer[] valueArray() {
        Integer[] values = new Integer[size];
        int i = 0;
        for (Node current : table) {
            while (current != null) {
                values[i++] = current.value;
                current = current.next;
            }
        }
        return values;
    }
    private int hash(String key){
        int hash = key.hashCode();
        return (hash < 0 ? -hash : hash) % table.length;
    }
    private void resizeTable(){
        int newCapacity = table.length * 2;
        Node[] newTable = new Node[newCapacity];

        for (Node node : table) {
            while (node != null) {
                int index = hash(node.key) % newCapacity;

                Node temp = node.next;
                node.next = newTable[index];
                newTable[index] = node;

                node = temp;
            }
        }
        table = newTable;
        }

        public void printMap(){
            for (String key : keyArray()) {
                System.out.println("Key: " + key + ", Value: " + get(key));
            }
        }

    }


