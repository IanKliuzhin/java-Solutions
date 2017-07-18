import java.util.*;

class SolutionStack {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.nextLine();
            boolean isBalanced = true;
            //Complete the code
            Stack<Character> straightStack = new Stack<Character>();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
                    straightStack.push(input.charAt(i));
//                    System.out.println(straightStack.peek());
                }
            }
//            System.out.println();
            Stack<Character> reverseStack = new Stack<Character>();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '}' || input.charAt(i) == ']' || input.charAt(i) == ')') {
                    reverseStack.push(input.charAt(i));
//                    System.out.println(reverseStack.peek());
                }
            }
//            System.out.println("StraightStack: " + straightStack);
//            System.out.println("ReverseStack: " + reverseStack);
            try {
                while (!straightStack.empty()) {
                    switch (straightStack.pop()) {
                        case '(':
                            if (reverseStack.peek().equals(')')) {
                                reverseStack.pop();
                            } else {
//                                System.out.println();
                                isBalanced = false;
                            }
                            break;
                        case '[':
                            if (reverseStack.peek().equals(']')) {
                                reverseStack.pop();
                            } else {
                                isBalanced = false;
                            }
                            break;
                        case '{':
                            if (reverseStack.peek().equals('}')) {
                                reverseStack.pop();
                            } else {
                                isBalanced = false;
                            }
                            break;
                    }
//                    System.out.println("StraightStack: " + straightStack);
//                    System.out.println("ReverseStack: " + reverseStack);

                }
                if (!reverseStack.isEmpty()) {
                    isBalanced = false;
                }
            } catch (EmptyStackException E) {
                isBalanced = false;
            }
            System.out.println(isBalanced);
        }
    }
}
