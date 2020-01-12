import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T>{
    private Node first;
    private Node last;
    private int size = 0;

    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements ListIterator<T>{
        Node current = new Node(null,first);


        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            current = current.next;
            return (T)current.value;

        }

        @Override
        public boolean hasPrevious() {
            return current.prev != null;
        }

        @Override
        public T previous() {
            current = current.prev;
            return (T)current.value;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("nextIndex");
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("previousIndex");
        }

        @Override
        public void remove() {
            if (current == null) throw new NullPointerException();

            if (current == first) first = current.next;
            if (current == last) last = current.prev;
            if (current.prev != null) current.prev.next = current.next;
            if (current.next != null) current.next.prev = current.prev;
            current = current.next;
            size--;
        }

        @Override
        public void set(T t) {
            current.value = t;
        }

        @Override
        public void add(T t) {
            // вставка следующего элемента за текущим
            Node<T> newNode = new Node<T>(current, t, current.next);
            if (first == current.next) first = newNode;
            if (current.next!=null) current.next.prev = newNode;
            else last = newNode;
            current.next = newNode;
            size++;
        }
    }


    private class Node<T> {
        T value;
        Node next;
        Node prev;

        public Node(Node prev, T value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = null;
        }

        public Node(T value) {
            this.value = value;
        }
    }


    public void insertFirst(T value) {
        Node newNode = new Node(value, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public void insertLast(T value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node oldFirst = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return (T) oldFirst.value;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node oldLast = last;
        if (last.prev != null) {
            last.prev.next = null;
        } else {
            first = null;
        }
        last = last.prev;
        size--;
        return (T) oldLast.value;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }

        Node current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    public boolean remove(T value) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(value)) {
            removeFirst();
            return true;
        }
        Node current = first;
        while (current != null && !current.value.equals(value)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if(current == last){
            removeLast();
            return true;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return true;
    }

    public int indexOf(T value) {
        return index(value);
    }

    private int index(T value) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(T value) {
        return index(value) > -1;
    }

    public T getFirst() {
        return (T) first.value;
    }

    public T getLast() {
        return (T) last.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        }
        Node current = first;
        StringBuilder sb = new StringBuilder("[ ");

        while (current != null) {
            sb.append(current.value.toString() + ", ");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" ]");
        return sb.toString();
    }
}
