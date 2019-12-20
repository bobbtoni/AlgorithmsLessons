import java.sql.Time;
import java.util.Arrays;
import java.util.Random;

public class Main {
    final static int SIZE = 1000000;
    static Random random = new Random();
    public static void main(String[] args) {
        MyBigArray<Integer> myBigArray = new MyBigArray<Integer>(SIZE);

        long time1, time2;

        randomValues(myBigArray);
        time1 = System.currentTimeMillis();
        myBigArray.bubbleSort();
        time2 = System.currentTimeMillis();
        System.out.println("Время выполнения пузырьковой сортировки: " + (time2 - time1) + " ms");

        randomValues(myBigArray);
        time1 = System.currentTimeMillis();
        myBigArray.insertionSort();
        time2 = System.currentTimeMillis();
        System.out.println("Время выполнения сортировки слиянием: " + (time2 - time1) + " ms");

        randomValues(myBigArray);
        time1 = System.currentTimeMillis();
        myBigArray.bubbleSort();
        time2 = System.currentTimeMillis();
        System.out.println("Время выполнения сортировки вставками: " + (time2 - time1) + " ms");
    }

    public static void randomValues(MyBigArray myBigArray){
        for (int i = 0; i < SIZE; i++) {
            myBigArray.add(random.nextInt(100));
        }
    }
}
