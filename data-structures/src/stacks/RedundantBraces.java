package stacks;

import java.util.Stack;

public class RedundantBraces
{
    public static int braces(String a) {
        int len = a.length();
        if (len == 0) {
            return 1;
        }
        Stack<Character> stack = new Stack<>();
        int i =0;
        while (i< len) {
            if (a.charAt(i) != ')') {
                stack.push(a.charAt(i));
            } else {
                boolean expr = false;
                int countVar = 0;
                Character current = stack.pop();
                while (!stack.isEmpty() && current != '(') {
                    if (current == '*' || current == '-' || current == '+' || current == '/') {
                        expr = true;
                        current = stack.pop();
                    } else {
                        countVar++;
                        current = stack.pop();
                    }
                }
                if (!(expr && countVar >0)) {
                    return 1;
                }

            }
            i++;
        }
        while (stack.isEmpty()) {
            Character character = stack.pop();
            if (character == '(') {
                return 1;
            }
        }
        return 1;
    }

    public static void main(String[] args)
    {
        System.out.println(braces("a+b"));
        int[] dp = new int[1];
    }

}
