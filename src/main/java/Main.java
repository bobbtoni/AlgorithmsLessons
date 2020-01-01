import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Deck<Integer> deck = new Deck<Integer>();

        deck.insertFront(1);
        deck.insertFront(2);
        deck.insertFront(3);

        while (!deck.isEmpty()){
            System.out.println(deck.removeFront());
        }

        String string = "123";
        System.out.println(reverse(string));

    }

    public static String reverse(String string){
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
