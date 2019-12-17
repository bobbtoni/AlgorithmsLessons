import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        L0766();
    }

    public static void L108() throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        printWriter.println(scanner.nextInt());
        printWriter.flush();
    }

    public static void L0766() {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        Integer N = scanner.nextInt();
        Integer M = scanner.nextInt();
        Integer K = scanner.nextInt();

        printWriter.println(N * M < K ? "NO" : "YES");
        printWriter.flush();
    }

    public static void L0892(){
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        Integer numM = scanner.nextInt();

        switch (numM){
            case 12 :
            case 1 :
            case 2 : printWriter.println("Winter"); break;
            case 3 :
            case 4 :
            case 5 : printWriter.println("Spring"); break;
            case 6 :
            case 7 :
            case 8 : printWriter.println("Summer"); break;
            case 9 :
            case 10 :
            case 11 : printWriter.println("Autumn"); break;
            default: printWriter.println("Error"); break;
        }

        printWriter.flush();
    }

    public static void L0948(){
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        Integer K = scanner.nextInt();
        Integer N = scanner.nextInt();

        Integer currentK = N / K + 1;
        Integer currentN = N % K;

        printWriter.println(currentK + " " + currentN);
        printWriter.flush();
    }

    public static void L0312(){
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        Integer A1 = scanner.nextInt();
        Integer A2 = scanner.nextInt();
        Integer AN = scanner.nextInt();

        Integer D = A2 - A1;
        AN = A1 + D * (AN - 1);

        printWriter.println(AN);
        printWriter.flush();
    }
}
