package Graphs;

public class GfgBfs
{
    public static void main(String[] args)
    {
        Digraph digraph = new Digraph();
        Node<Integer> node0 = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        digraph.addNode(node0);
        digraph.addNode(node1);
        digraph.addNode(node2);
        digraph.addNode(node3);
        digraph.addEdge(node0, node1);
        digraph.addEdge(node0, node2);
        digraph.addEdge(node1, node2);
        digraph.addEdge(node2, node0);
        digraph.addEdge(node2, node3);
        digraph.addEdge(node3, node3);
        digraph.bfsTraversal(node2);
    }
}
