public class MyBigArray<T extends Comparable> {

    T[] array;
    int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    int capacity = DEFAULT_CAPACITY;

    public MyBigArray() {
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public MyBigArray(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity: " + capacity);
        this.capacity = capacity;
        array = (T[]) new Comparable[capacity];
    }

    public MyBigArray add(T item){
        if (size >= capacity) {
            capacity *= 2;
            T[] newArray = (T[]) new Comparable[capacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = item;
        size ++;
        return this;
    }

    public MyBigArray add(Integer index, T item){
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        // вставка в конец
        add(item);
        T tmp;
        // сдвиг на свое место
        for (int i = size - 1; i > index; i++) {
            tmp = array[i];
            array[i] = array[i-1];
            array[i-1] = tmp;
        }
        return this;
    }

    // поиск
    public final int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = null;
    }

    public boolean remove(T item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    // сортировки

    private void swap(int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int imin = i;
            for (int j = i + 1; j < size; j++) {
                if( array[j].compareTo(array[imin])<0){
                    imin = j;
                }
            }
            swap(i, imin);
        }
    }

    public void insertionSort(){
        T key;
        for (int i = 1; i <size ; i++) {
            int j = i;
            key  = array[i];
            while(j>0 && key.compareTo(array[j-1])<0){
                array[j] = array[j-1];
                j--;
            }
            array[j] = key;
        }
    }

        public void bubbleSort(){
        boolean isSwap;
        for (int i = size-1; i > 0 ; i--) {
            isSwap = false;
            for (int j = 0; j < i ; j++) {
                if( array[j+1].compareTo(array[j])<0 ){
                    swap(j+1, j);
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            stringBuilder.append(array[i] + ", ");
        }
        stringBuilder.append(array[size - 1] + "}");
        return stringBuilder.toString();
    }
}
