package AlgoTrick;

import java.util.LinkedList;

public class Node implements Comparable<Node>{
    String name;
    Node dad;
    int key;
    private LinkedList<Edge> edges;
    public Node() {
        this.edges = new LinkedList<Edge>();
    }

    public Node(String N) {
        this.name = N;
    }
    @Override
    public int compareTo(Node obj) {
        if (this.getKey() > obj.getKey()) {
            return 1;
        } else if (this.getKey() < obj.getKey()) {
            return -1;
        } else {
            return 0;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Edge> edges) {
        this.edges = edges;
    }

    public void printEdge() {
        for (Edge x : edges) {
            System.out.print("(" + x.getSrc().getName() + ",--" + x.getWeight() + "--," + x.des.getName() + ")");
        }
        System.out.print("\n");

    }

    public Node getDad() {
        return dad;
    }

    public void setDad(Node dad) {
        this.dad = dad;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}
