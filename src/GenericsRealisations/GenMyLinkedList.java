package GenericsRealisations;

import GenericsInterfaces.GenMyList;
import GenericsInterfaces.GenMyQueue;

public class GenMyLinkedList<T> implements GenMyList<T>, GenMyQueue<T> {
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

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
        Node<T> obj = head;
        while (obj != null) {
            if (obj.data.equals(object)) {
                return true;
            }
            obj = obj.next;
        }
        return false;
    }

    @Override
    public void add(T object) {
        Node<T> newNode = new Node<>(object);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T object) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of Bounds.");
        }
        Node<T> newNode = new Node<>(object);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<T> obj = getNode(index);
            newNode.prev = obj.prev;
            newNode.next = obj;
            obj.prev.next = newNode;
            obj.prev = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(T object) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(object)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public int indexOf(T object) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T object) {
        Node<T> current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public void printArray() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public boolean offer(T object) {
        add(object);
        return true;
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : head.data;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of Bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
