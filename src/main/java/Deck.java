import java.util.EmptyStackException;

public class Deck<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;

    public Deck(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public Deck() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertBack(T value) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        list[end] = value;
        size++;
        end = nextIndex(end);
    }

    public void insertFront(T value){
        if (isFull()) {
            throw new StackOverflowError();
        }
        System.arraycopy(list, begin, list, begin + 1, size);
        list[begin] = value;
        size++;
        end = nextIndex(end);
    }

    public T removeFront() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeBack(){
        T temp = peekBack();
        size--;
        list[prevIndex(end)] = null;
        end = prevIndex(end);
        return temp;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[begin];
    }

    public T peekBack() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[prevIndex(end)];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int prevIndex(int index) {
        return (index - 1) % list.length;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
