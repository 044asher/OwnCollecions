package Realisations;

import Interfaces.MyList;
import Interfaces.MyQueue;

public class MyLinkedList implements MyList, MyQueue {
    private class Node{
        Integer data;
        Node prev;
        Node next;
        public Node(Integer data){
            this.data = data;
        }
    }
    private Node head;
    private Node tail;
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
    public boolean contains(Integer object) {
        Node obj = head;
        while (obj != null){
            if(obj.data.equals(object)){
                return true;
            }
            obj = obj.next;
        }
        return false;
    }

    @Override
    public void add(Integer object) {
        Node newNode = new Node(object);
        if(head == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, Integer object) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of Bounds.");
        }

        Node newNode = new Node(object);
        if(index == 0){
            newNode.next = head;
            if(head != null){
                head.prev = newNode;
            }
            head = newNode;
        }
        else if(index == size){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        else {
            Node obj = getNode(index);
            newNode.prev = obj.prev;
            newNode.next = obj;
            obj.prev.next = newNode;
            obj.prev = newNode;
        }
    }

    @Override
    public boolean remove(Integer object) {
        Node current = head;
        while(current != null) {
            if(current.data.equals(object)){
                if(current.prev != null){
                    current.prev.next = current.next;
                }
                else {
                    head = current.next;
                }

                if(current.next != null){
                    current.next.prev = current.prev;
                }
                else {
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
    public Integer get(int index) {
        return getNode(index).data;
    }

    @Override
    public int indexOf(Integer object) {
        Node current = head;
        int index = 0;
        while (current != null){
            if(current.data.equals(object)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer object) {
        Node current = tail;
        int index = size - 1;
        while (current != null){
            if(current.data.equals(object)){
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public void printArray() {
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public boolean offer(Integer object) { //!Modified
        add(object);
        return true;
    }

    @Override
    public Integer poll() {
        if(isEmpty()){
            return null;
        }
        Integer data = head.data;
        head = head.next;
        if(head != null) {
            head.prev = null;
        }
        else {
            tail = null;
        }
        size--;
        return data;
    }

    @Override
    public Integer peek() {
        return isEmpty() ? null : head.data;
    }
    private Node getNode(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of Bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
