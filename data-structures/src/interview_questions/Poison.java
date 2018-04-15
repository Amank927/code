package interview_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Poison
{
    static class pair {
        int a;

        int b;

        public pair(int a, int b)
        {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Integer n = 0;
        if ( scanner.hasNext()){
            n = scanner.nextInt();
        }
        while (n-- > 0) {
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextInt());
            }

            Stack<pair> s = new Stack<>();
            int maxa = 0;
            for (int i = 0; i < n; i++) {
                if (s.empty()) {
                    s.push(new pair(arr.get(i), 0));
                }
                else {
                    pair temp = s.peek();

                    if (arr.get(i) < temp.a) {
                        int sc = 1;
                        maxa = Math.max(maxa, sc);
                        s.push(new pair(arr.get(i), sc));
                    }
                    else {

                        pair v = s.peek();
                        int pr = v.b;
                        while (!s.empty() && v.a <= arr.get(i)) {
                            s.pop();
                            if (s.empty())
                                break;
                            pr = Math.max(pr, v.b);
                            v = s.peek();
                        }

                        if (s.empty()) {
                            s.push(new pair(arr.get(i), 0));
                        }

                        else {
                            s.push(new pair(arr.get(i), pr + 1));
                            maxa = Math.max(maxa, pr + 1);
                        }


                    }
                }
            }
            System.out.println(maxa);
        }
    }
}
