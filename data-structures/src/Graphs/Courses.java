package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/
 */
public class Courses
{
    public static int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[] visited = new int[A+1];
        for (int i =1; i<= A; i++) {
            visited[i] = 0;
        }
        List<List<Integer>> graph = new ArrayList<>(A+1);
        for (int i =0; i<= A ;i ++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0; i< B.size() ; i++) {
            graph.get(B.get(i)).add(C.get(i));
        }
        for (int i =1; i<= A ; i++) {
            if (visited[i] == 0) {
                int[] localVisited = new int[A+1];
                for (int k = 0; k<= A; k++) {
                    localVisited[k] = 0;
                }
                if (dfs(i, graph, visited, localVisited) == 1) {
                    return 0;
                }
            }
        }
       return 1;
    }


    private static int dfs(int start,List<List<Integer>> graph, int[] visited ,int[] localVisited) {
        if (visited[start] == 0) {
            visited[start] = 1;
            localVisited[start] = 1;
            for (int i =0; i< graph.get(start).size() ;i++) {
                if (localVisited[graph.get(start).get(i)] == 1) {
                    return 1;
                } else {
                    if (localVisited[graph.get(start).get(i)] ==0 && dfs(graph.get(start).get(i), graph, visited, localVisited)==1) {
                        return 1;
                    }
                }
            }
        }
        localVisited[start] = 0;
        return 0;
    }

    public static int isCycle(int start,List<List<Integer>> graph, int[] visited , int A) {
        Queue<Integer> queue = new LinkedList<>();
        int[] localVisited = new int[A+1];

        for (int i =1; i<= A; i++) {
            localVisited[i] = 0;
        }
        queue.add(start);
        visited[start] = 1;
        localVisited[start] =1 ;
        while (!queue.isEmpty()) {
            Integer src = queue.poll();
            for ( int i =0; i< graph.get(src).size() ; i++) {
                if (localVisited[graph.get(src).get(i)] == 1) {
                    return 1;
                } else {
                    visited[graph.get(src).get(i)] = 1;
                    localVisited[graph.get(src).get(i)] = 1;
                    queue.add(graph.get(src).get(i));
                }
            }
        }
        return 0;
    }

    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        map.put(a.get(0), 0);
        for (int i =1; i< a.size() ;i++) {
            if(map.containsKey(b - a.get(i))) {
                Integer index1 = map.get(b - a.get(i));
                res.add(index1 +1 );
                res.add(i+1);
                return res;
            } else if (map.containsKey(a.get(i))){
            } else {
                map.put(a.get(i), i);

            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        B.add(3);
        C.add(1);
        B.add(3);
        C.add(5);
        B.add(1);
        C.add(7);
        B.add(5);
        C.add(2);
        B.add(5);
        C.add(4);
        B.add(2);
        C.add(6);
        B.add(4);
        C.add(6);
        B.add(6);
        C.add(8);
        B.add(7);
        C.add(8);
        B.add(7);
        C.add(2);
//        B.add(1);
//        C.add(2);
//        B.add(2);
//        C.add(1);
        System.out.println(solve(8, B, C));
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        a.get(0).set(0, 'X');
    }
}
