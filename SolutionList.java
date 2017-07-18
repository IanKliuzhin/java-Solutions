import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class SolutionList {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named SolutionList. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        LinkedList<Integer> L = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            L.add(sc.nextInt());
        }
        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            if (sc.next().equals("Insert")) {
                int ind = (int) sc.nextInt();
                int el = (int) sc.nextInt();
                L.add(ind, el);
            } else {
                int ind = sc.nextInt();
                L.remove(ind);
            }
        }

        for (Object o : L) {
            System.out.print(o + " ");
        }
    }
}
