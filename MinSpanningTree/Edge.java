package AlgoTrick;

public class Edge {
    int weight;
    Node src;
    Node des;

    public void setSrc(Node src) {
        this.src = src;
    }

    public void setDes(Node des) {
        this.des = des;
    }

    public Node getSrc() {
        return src;
    }

    public Node getDes() {
        return des;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Edge() {
    }

    public Edge(Node src, Node des, int w) {
        super();
        this.src = src;
        this.des = des;
        this.weight = w;
    }




}
