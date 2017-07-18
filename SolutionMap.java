//Complete this code or write your own from scratch

import java.util.*;
import java.io.*;

class SolutionMap {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        HashMap<String, Integer> pb = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            pb.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            if (pb.containsKey(s)) {
                System.out.println(s + "=" + pb.get(s));
            } else {
                System.out.println("Not found");
            }
        }
    }
}
