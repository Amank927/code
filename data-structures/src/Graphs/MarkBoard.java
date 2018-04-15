package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class MarkBoard {
    public static class Pair
    {
        int p1;
        int p2;
        public Pair(int a, int b) {
            this.p1 = a;
            this.p2 = b;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair pair = (Pair) o;

            if (p1 != pair.p1) {
                return false;
            }
            return p2 == pair.p2;
        }

        @Override
        public int hashCode()
        {
            int result = p1;
            result = 31 * result + p2;
            return result;
        }
    }
    public static void solve(ArrayList<ArrayList<Character>> a) {
        int len = a.size();
        boolean[][] visited = new boolean[len][len];
        for (int i=0;i<len ;i++) {
            for(int j=0;j<len ;j++) {
                visited[i][j] = false;
            }
        }
        Set<Pair> cannotMark = new HashSet<>();
        for (int i=0;i< len ;i++) {
            for (int j=0;j< len ;j++) {
                if (a.get(i).get(j) == 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                }
                else if (a.get(i).get(j) == 'O' && !visited[i][j]){
                    Queue<Pair> queue = new LinkedList<>();
                    Stack<Pair> stack = new Stack<>();
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Pair p = queue.poll();
                        stack.push(p);
                        if ( p.p1+1 >= len || p.p1-1 < 0 || p.p2+1 >= len || p.p2-1 < 0 ) {
                            while(!stack.isEmpty()) {
                                Pair p1 = stack.pop();
                                cannotMark.add(p1);
                            }
                        }else {
                            if(p.p1+1 < len && a.get(p.p1+1).get(p.p2) == 'O' && !visited[p.p1+1][p.p2]) {
                                queue.add(new Pair(p.p1+1, p.p2));
                            }
                            if (p.p1+1 < len) {
                                visited[p.p1 + 1][p.p2] = true;
                            }
                            if(p.p1 -1 >=0 && a.get(p.p1-1).get(p.p2) == 'O' && !visited[p.p1-1][p.p2]) {
                                queue.add(new Pair(p.p1-1, p.p2));
                            }
                            if (p.p1 -1 >=0) {
                                visited[p.p1 - 1][p.p2] = true;
                            }
                            if(p.p2 +1 < len && a.get(p.p1).get(p.p2+1) == 'O' && !visited[p.p1][p.p2+1]) {
                                queue.add(new Pair(p.p1, p.p2+1));
                            }
                            if (p.p2 +1 < len) {
                                visited[p.p1][p.p2 + 1] = true;
                            }
                            if(p.p2-1 >= 0 && a.get(p.p1).get(p.p2-1) == 'O' && !visited[p.p1][p.p2-1]) {
                                queue.add(new Pair(p.p1, p.p2-1));
                            }
                            if(p.p2-1 >= 0 ) {
                                visited[p.p1][p.p2 - 1] = true;
                            }
                        }
                    }
                }
            }
        }

        for (int i=0;i<len ;i++) {
            for(int j=0;j<len ;j++) {
                if (a.get(i).get(j) == 'O' && !cannotMark.contains(new Pair(i,j))) {
                    a.get(i).set(j, 'X');
                }
            }
        }

//        for (int i=0;i<len ;i++) {
//            for(int j=0;j<len ;j++) {
//                System.out.print(a.get(i).get(j));
//            }
//            System.out.println();
//        }

    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        ArrayList<Character> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList('X', 'O', 'X'));
        ArrayList<Character> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList('X', 'O', 'X'));
        ArrayList<Character> list3 = new ArrayList<>();
        list3.addAll(Arrays.asList('X', 'O', 'X'));
        a.add(list1);
        a.add(list2);
        a.add(list3);
        solve(a);
    }
}
