import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        /*MyStack<String> myStack = new MyStack<String>();
        myStack.push("Anya");
        myStack.push("Kolya");
        myStack.push("Vasya");

        while(!myStack.isEmpty()){
            System.out.print(myStack.pop() + " ");
        }*/

        MyLinkedList<String> strings = new MyLinkedList<String>();

        strings.insertLast("Anya");
        strings.insertLast("Kolya");
        strings.insertLast("Vasya");

        for(String string : strings){
            System.out.print(string + " ");
        }

        System.out.println();

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            iterator.next();
            ((ListIterator<String>) iterator).set("1111");
        }

        System.out.println();

        for(String string : strings){
            System.out.print(string + " ");
        }
    }

}
