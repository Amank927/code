package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Digraph
{
    private Set<Node> nodes;
    private Map<Node, List<Node>> edgeMap;

    public Digraph()
    {
        nodes = new HashSet<>();
        edgeMap = new HashMap<>();
    }

    public Set<Node> getNodes()
    {
        return nodes;
    }

    public void addNode(Node node)
    {
        this.nodes.add(node);
    }

    public void addEdge(Node src, Node dest)
    {
        this.nodes.add(src);
        this.nodes.add(dest);
        List<Node> destinations = new ArrayList<>();
        if (edgeMap.containsKey(src)) {
            destinations = edgeMap.get(src);
        }
        destinations.add(dest);
        edgeMap.put(src, destinations);
    }

    public List<Node> getEdgesOfANode(Node node)
    {
        return edgeMap.containsKey(node) ? edgeMap.get(node) : new ArrayList<>();
    }

    public void bfsTraversal(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node);
            for (Node dest : getEdgesOfANode(node)) {
                if (!visited.contains(dest)) {
                    queue.add(dest);
                    visited.add(dest);
                }
            }
        }
    }

    public void dfsTraversal(Node startNode) {
        actualDfs(startNode, new HashSet<>());
    }

    private void actualDfs(Node startNode, Set<Node> visited)
    {
        if (!visited.contains(startNode)) {
            visited.add(startNode);
            System.out.println(startNode);
        } else
        {
            return;
        }
        for (Node dest : getEdgesOfANode(startNode)) {
            if (!visited.contains(dest)) {
                actualDfs(dest, visited);
            }
        }
    }
    public static void main(String[] args)
    {
        Node<String> node1 = new Node("a");
        Node<String> node2 = new Node("b");
        Node<String> node3 = new Node("c");
        Digraph graph = new Digraph();

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addEdge(node1,node2);
        graph.addEdge(node1, node3);
        System.out.println("BFS-------------------------");
        graph.bfsTraversal(node1);
        System.out.println("DFS-------------------------");
        graph.dfsTraversal(node1);
    }
}
