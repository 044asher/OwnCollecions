import Interfaces.MyList;
import Realisations.MyArrayList;
import Realisations.MyLinkedList;


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


        System.out.println("\nДобавляем теперь по индексу, проверяя смещение элементов");
        myLinkedList.add(0, 8);
        myLinkedList.printArray();

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
    }
}