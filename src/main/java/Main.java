public class Main {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<String>();
        myStack.push("Anya");
        myStack.push("Kolya");
        myStack.push("Vasya");

        while(!myStack.isEmpty()){
            System.out.print(myStack.pop() + " ");
        }
    }

}
