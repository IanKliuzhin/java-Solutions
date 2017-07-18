import java.io.*;
import java.util.*;

public class Token {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();



        // Write your code here.
        String[] tokens = s.trim().split("[\\s!,?._'@]+");
        System.out.println(s.isEmpty() ? 0 : tokens.length);
        for (String token:tokens) {
            System.out.println(token);
        }
        scan.close();
    }
}
