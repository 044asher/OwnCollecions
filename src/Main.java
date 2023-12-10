import GenericsInterfaces.GenMyList;
import GenericsRealisations.GenMyArrayList;
import GenericsRealisations.GenMyHashMap;
import Interfaces.MyList;
import Interfaces.MyMap;
import Realisations.MyArrayList;
import Realisations.MyHashMap;
import Realisations.MyLinkedList;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        System.out.println("My List:");
        MyList myList = new MyArrayList();
        System.out.println("is empty: " + myList.isEmpty());
        myList.add(42);
        System.out.println("is empty: " + myList.isEmpty());
        myList.add(25);
        myList.add(14);
        myList.add(125);
        myList.printArray();
        System.out.println("size: " + myList.size());

        System.out.println("\nДобавляем теперь по индексу, проверяя смещение элементов");
        myList.add(1, 1);
        myList.printArray();
        //myList.add(-1, 2); //IndexOutOfBoundsException: Index cannot be less than zero!

        System.out.println("\nПроверяем удаление элемента");
        myList.remove(42);
        myList.printArray();

        System.out.println("\nПроверяем получение элементов");
        System.out.println(myList.indexOf(125));
        System.out.println(myList.lastIndexOf(14));
        System.out.println(myList.get(0));
        /* System.out.println(myList.get(-1)); //IndexOutOfBoundsException: Index out of bounds
        System.out.println(myList.get(10)); */
        System.out.println(myList.contains(25));

        System.out.println("\nОчищаем коллекцию.");
        myList.clear();
        myList.printArray();





        System.out.println("My LinkedList: ");
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(15);
        myLinkedList.add(3);
        myLinkedList.add(542);
        System.out.println("is empty: " + myLinkedList.isEmpty());
        myLinkedList.printArray();

        System.out.println(myLinkedList.size());
        System.out.println("\nДобавляем по индексу");
        myLinkedList.add(0, 8);
        myLinkedList.printArray();
        System.out.println(myLinkedList.size());

        System.out.println("\nПроверяем удаление элемента");
        myLinkedList.remove(2);
        myLinkedList.printArray();

        System.out.println("\nПроверяем получение элементов");
        System.out.println(myLinkedList.contains(15));
        System.out.println(myLinkedList.indexOf(3));
        System.out.println(myLinkedList.lastIndexOf(2));
        System.out.println(myLinkedList.get(3));

        System.out.println("\nМетоды интерфейса MyQueue");
        myLinkedList.printArray();

        myLinkedList.offer(5);
        myLinkedList.printArray();

        System.out.println(myLinkedList.poll());
        myLinkedList.printArray();

        System.out.println(myLinkedList.peek());


        System.out.println("\n\nMy Hash Map");

        MyHashMap myMap = new MyHashMap();
        myMap.put("Zero", 0);
        System.out.println(myMap.get("Zero"));
        myMap.put("One", 1);
        System.out.println(Arrays.toString(myMap.keyArray()));
        System.out.println(Arrays.toString(myMap.valueArray()));
        myMap.put("One", 11);
        System.out.println(Arrays.toString(myMap.keyArray()));
        System.out.println(Arrays.toString(myMap.valueArray()));
        System.out.println(myMap.isEmpty());
        myMap.remove("Zero");
        myMap.printMap();
        System.out.println(myMap.size());
        myMap.clear();
        System.out.println(myMap.size());


        System.out.println("\n\nGeneric List");
        GenMyList<String> genericList = new GenMyArrayList<String>();
        genericList.add("Zero");
        genericList.add("One");
        System.out.println("Is Empty: " + genericList.isEmpty());
        genericList.printArray();
        genericList.add(0, "MinusOne");
        genericList.printArray();

        genericList.remove("MinusOne");
        genericList.printArray();
        System.out.println(genericList.indexOf("One"));
        System.out.println(genericList.get(0));
        genericList.clear();
        genericList.printArray();


        System.out.println("\n\nGeneric Map");
        GenMyHashMap<String, String> carMap = new GenMyHashMap<>();


        carMap.put("ВМ1234ВМ", "Toyota");
        carMap.put("ВМ5678ВМ", "Honda");
        carMap.put("ВМ9999ВМ", "Ford");

        System.out.println("Размер: " + carMap.size());

        System.out.println("ВМ5678ВМ: " + carMap.get("ВМ5678ВМ"));

        carMap.printMap();


        carMap.remove("ВМ5678ВМ");


        System.out.println("Размер после удаления: " + carMap.size());
        carMap.printMap();
    }
}
