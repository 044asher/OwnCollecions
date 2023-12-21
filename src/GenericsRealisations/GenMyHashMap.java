package GenericsRealisations;

import GenericsInterfaces.GenMyMap;

public class GenMyHashMap<K, V> implements GenMyMap<K, V> {
    private static final int START_CAPACITY = 16;
    private static final double THRESHOLD = 0.75;
    private Node<K, V>[] table;
    private int size;

    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public GenMyHashMap() {
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
    public void put(K key, V value) {
        int index = hash(key);

        if (table[index] == null) { // Если ячейка по данному индексу пуста, добавляем ключ-значение и выходим из метода
            table[index] = new Node<>(key, value);
            size++;
            return;
        }

        int step = 1;//Теперь для решения коллизий будем использовать линейный метод вместо метода цепочек.
        int i = index; //Для начала присвоим переменной і наш индекс
        while (table[i] != null) { //Входим в цикл который проверяет пуста ли ячейка
            i = (i + step) % table.length; //Если ячейка не пуста, то цикл увеличивает і на step, но при этом чтобы не выйти за пределы таблицы применяем % на размер таблицы
            step++; //ну и в конце каждой итерации увеличиваем step на единичку для нашего следующего шага.
        }
        table[i] = new Node<>(key, value); //когда такими проходочками нашли свободную ячейку, кладем в неё наше ключ-значение.
        size++;

        if ((double) size / table.length > THRESHOLD) {
            resizeTable();
        }
    }
    @Override
    public boolean remove(K key) {
        int index = hash(key);
        Node<K, V> current = table[index];
        Node<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
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
    public V get(K key) {
        int index = hash(key);
        int step = 1;
        int i = index;
        while (table[i] != null) {
            if (table[i].key.equals(key)) {
                return table[i].value;
            }
            i = (i + step) % table.length;
            step++;
        }
        return null;
    }

    @Override
    public K[] keyArray() {
        K[] keys = (K[]) new Object[size];
        int i = 0;
        for (Node<K, V> current : table) {
            while (current != null) {
                keys[i++] = current.key;
                current = current.next;
            }
        }
        return keys;
    }

    @Override
    public V[] valueArray() {
        V[] values = (V[]) new Object[size];
        int i = 0;
        for (Node<K, V> current : table) {
            while (current != null) {
                values[i++] = current.value;
                current = current.next;
            }
        }
        return values;
    }

    private int hash (K key) {
        if(key == null){
            return 0;
        }
        int hash = key.hashCode();
        return (hash < 0 ? -hash : hash) % table.length;
    }

    private void resizeTable() {
        int newCapacity = table.length * 2;
        Node<K, V>[] newTable = new Node[newCapacity];

        for (Node<K, V> node : table) {
            while (node != null) {
                int index = hash(node.key) % newCapacity;

                Node<K, V> temp = node.next;
                node.next = newTable[index];
                newTable[index] = node;

                node = temp;
            }
        }
        table = newTable;
    }

    public void printMap() {
        for (K key : keyArray()) {
            System.out.println("Key: " + key + ", Value: " + get(key));
        }
    }
}
