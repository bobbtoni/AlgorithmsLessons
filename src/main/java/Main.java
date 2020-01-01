public class Main {
    public static void main(String[] args) {
        Deck<Integer> deck = new Deck<Integer>();

        deck.insertFront(1);
        deck.insertFront(2);
        deck.insertFront(3);

        while (!deck.isEmpty()){
            System.out.println(deck.removeFront());
        }

    }
}
