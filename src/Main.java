import Interfaces.MyList;
import Realisations.MyArrayList;


public class Main {
    public static void main(String[] args) {
        MyList myList = new MyArrayList();
        System.out.println(myList.isEmpty());
        myList.add(42);
        System.out.println(myList.isEmpty());
        myList.add(25);
        myList.add(14);
        myList.add(125);
        myList.printArray();

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




    }
}