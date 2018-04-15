package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LongestPath
{
    static class Node {
        int val;

        public Node(int val)
        {
            this.val = val;
        }
    }
    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight)
        {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static class Graph
    {
        private List<Node> nodes;
        private Map<Integer, List<Edge>> edgeMap;

        public Graph() {
            nodes = new ArrayList<>();
            edgeMap = new HashMap<>();
        }
        public void addNode(Node node) {
            this.nodes.add(node);
        }
        public void addEdge(Edge edge) {
            if(this.edgeMap.containsKey(edge.start)) {
                List<Edge> oldList = this.edgeMap.get(edge.start);
                oldList.add(edge);
                this.edgeMap.put(edge.start, oldList);
            } else {
                List<Edge> edgeList = new ArrayList<>();
                edgeList.add(edge);
                this.edgeMap.put(edge.start, edgeList);
            }
        }

        public void longestPath(Integer fromNode) {
            ArrayList<Integer> topoPath = topoSort();
            int[] ld = new int[nodes.size() ];
            for (int i =0 ; i < ld.length ;i++) {
                ld[i] = Integer.MIN_VALUE;
            }
            ld[fromNode] = 0;
            for (int i =0; i< topoPath.size() ;i++) {
                for(int j =0 ;edgeMap.get(topoPath.get(i)) != null  && j < edgeMap.get(topoPath.get(i)).size() ; j++) {
                    ld[edgeMap.get(topoPath.get(topoPath.get(i))).get(j).end] = Math.max(ld[edgeMap.get(topoPath.get(i)).get(j).end],
                                ld[i] + edgeMap.get(topoPath.get(i)).get(j).weight );
                }
            }
            for (int i =0 ;i < ld.length ;i++) {
                System.out.println(ld[i]);
            }
        }
        public ArrayList<Integer> topoSort() {
            boolean[] visited = new boolean[nodes.size()];
            ArrayList<Integer> res = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for (int i=0; i< nodes.size() ;i++) {
                if (!visited[nodes.get(i).val]) {
                    actualTopoSort(nodes.get(i).val, visited, stack);
                }
            }
            while (!stack.isEmpty()) {
                res.add(stack.pop());
            }
            return res;
        }

        public void actualTopoSort(Integer start, boolean[] visited, Stack<Integer> stack) {
            visited[start] = true;
            for(int i=0; edgeMap.get(start) != null && i< edgeMap.get(start).size() ;i++) {
                if (!visited[edgeMap.get(start).get(i).end]) {
                    visited[edgeMap.get(start).get(i).end] = true;
                    actualTopoSort(edgeMap.get(start).get(i).end, visited, stack);
                }
            }
            stack.push(start);
        }
    }

    public static void main(String[] args)
    {
        Graph graph = new Graph();
        Node node = new Node(0);
        graph.addNode(node);
        graph.addNode(new Node(1));
        graph.addNode(new Node(2));
        graph.addNode(new Node(3));
        graph.addNode(new Node(4));
        graph.addNode(new Node(5));
        graph.addEdge(new Edge(0, 1, 5));
        graph.addEdge(new Edge(0, 2, 3));
        graph.addEdge(new Edge(1, 3, 6));
        graph.addEdge(new Edge(1, 2, 2));
        graph.addEdge(new Edge(2, 4, 4));
        graph.addEdge(new Edge(2, 5, 2));
        graph.addEdge(new Edge(2, 3, 7));
        graph.addEdge(new Edge(3, 5, 1));
        graph.addEdge(new Edge(3, 4, -1));
        graph.addEdge(new Edge(4, 5, -2));
        graph.topoSort();
        graph.longestPath(1);

    }
}
