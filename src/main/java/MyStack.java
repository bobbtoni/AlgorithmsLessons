import java.util.EmptyStackException;

public class MyStack<T> extends MyOneLinkedList<T> {


    public void push(T value){
        super.insertFirst(value);
    }

    public T pop(){
        if (size() == 0) {
            throw new EmptyStackException();
        }
        return  super.removeFirst();
    }

    @Override
    public void insertFirst(T value) {
        throw new UnsupportedOperationException("insertFirst");
    }

    @Override
    public T removeFirst() {
        throw new UnsupportedOperationException("removeFirst");
    }

    @Override
    public void insert(int index, T value) {
        throw new UnsupportedOperationException("insert");
    }

    @Override
    public boolean remove(T value) {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    public int indexOf(T value) {
        throw new UnsupportedOperationException("indexOf");
    }

    @Override
    public boolean contains(T value) {
        throw new UnsupportedOperationException("contains");
    }

    @Override
    public T getFirst() {
        throw new UnsupportedOperationException("getFirst");
    }

}
