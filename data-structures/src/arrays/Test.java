package arrays;

import java.util.Stack;

public class Test
{
    public static String simplifyPath(String path) {
        if(path.equals("") || path.equals("/")) {
            return path;
        }
        String[] words = path.split("/");
        System.out.println(words.length);
        for(int i=0; i< words.length;i++) {
            System.out.println(words[i] +"----");
        }
        Stack<String> stack = new Stack<>();
        int i=0;
        while (i < words.length) {
            if(words[i].equals("") || words[i].equals(".")) {
                i++;
                continue;
            } else if(words[i].equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                i++;
            } else {
                stack.push(words[i]);
                i++;
            }
        }
        Stack<String> stack2 = new Stack<>();
        while(!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        String res = "/";
        while(!stack2.isEmpty()) {
            if(stack2.size() == 1) {
                res = res + stack2.pop() ;
            } else {
                res = res + stack2.pop() + "/";
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        System.out.println("." ==".");
        System.out.println(simplifyPath("/abb/javc/cuhb/////"));
    }
}
