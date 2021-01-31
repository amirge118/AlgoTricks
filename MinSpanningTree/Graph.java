package AlgoTrick;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Graph {

    private int numOfnotes;
    private Node[] Nlist;

    Graph(int num) {
        Nlist = new Node[num];
        this.numOfnotes = num;
        for (int i = 0; i < num; i++) {
            Nlist[i] = new Node();
        }
    }

    public void AddEdge(String nameSrc, String nameDes, int W) {
        Node src = null;
        Node des = null;
        for (Node x : this.Nlist) {
            if (x.getName().contains(nameSrc))
                src = x;
            if (x.getName().contains(nameDes))
                des = x;
        }

        Edge newEdge = new Edge();
        newEdge.setWeight(W);
        newEdge.setDes(des);
        newEdge.setSrc(src);
        src.getEdges().add(newEdge);
        Edge newEdge2 = new Edge();
        newEdge2.setWeight(W);
        newEdge2.setDes(src);
        newEdge2.setSrc(des);
        des.getEdges().add(newEdge2);
    }

    public void printG() {
        for (int i = 0; i < this.numOfnotes; i++) {
            //System.out.println(Nlist[i].getName() + ":");
            Nlist[i].printEdge();
        }
        System.out.print("\n");
    }

    public int getNumOfnotes() {
        return numOfnotes;
    }

    public Node[] getNlist() {
        return Nlist;
    }

    public void setNumOfnotes(int numOfnotes) {
        this.numOfnotes = numOfnotes;
    }

    public void setNlist(Node[] nlist) {
        Nlist = nlist;
    }

    public Graph MinTreeGraph(String firstNodeName) {
        Prim(firstNodeName);
        int i;
        Graph G = new Graph(this.getNumOfnotes());
        for (i =0;i<this.getNumOfnotes();i++){
            G.getNlist()[i].setName(this.getNlist()[i].getName());
            G.getNlist()[i].setDad(this.getNlist()[i].getDad());
            G.getNlist()[i].setKey(this.getNlist()[i].getKey());
        }
        for (Node x :Nlist) {
            if (x.getDad()!=null){
                G.AddEdge(x.getName(),x.getDad().getName(),x.getKey());
            }
            
        }
        return G;
    }

    public void Prim(String firstNode) {

        Node rootNode = null;
        //MAKE ALL NODES KEYS TO MAX AND DAD TO NULL
        for (Node x: this.Nlist) {
            x.setKey(Integer.MAX_VALUE);
            x.setDad(null);
            //FIND THE ROOT
            if (x.getName().contains(firstNode)) {
                rootNode = x;
            }
        }
        rootNode.setKey(0);
        //ENTER ALL THE NODES TO QUEUE
        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>();
        for (Node x: this.Nlist) {
            nodePriorityQueue.add(x);
        }
//WHILE QUEUE IS NOT EMPTY
        while (!nodePriorityQueue.isEmpty()) {

            Node u = nodePriorityQueue.peek();
            LinkedList<Edge> VEdges= u.getEdges();
            //CHECK IN EVERY edges in the node with min key
            for (Edge e: VEdges) {
                Node v = e.getDes();
                int u_vWeight = e.getWeight();
                if (nodePriorityQueue.contains(e.getDes()) && u_vWeight < v.getKey()) {
                    nodePriorityQueue.remove(v);
                    v.setDad(u);
                    v.setKey(u_vWeight);
                    nodePriorityQueue.add(v);
                }
            }
            nodePriorityQueue.remove(u);
        }
    }

    public void RemoveOneEdge(Edge newEdge) {
        int weigh = newEdge.getWeight();
        Node maxedge = null;
        Stack<Node> deslist = new Stack<>();
        Stack<Node> srclist = new Stack<>();
        Node checkfamily = newEdge.getSrc();
        while (checkfamily.getDad() != null) {
            srclist.add(checkfamily.getDad());
            checkfamily = checkfamily.getDad();
            if (checkfamily == null) {
                break;
            }
        }
        checkfamily = newEdge.getDes();
        while (checkfamily.getDad() != null) {
            deslist.add(checkfamily.getDad());
            checkfamily = checkfamily.getDad();
            if (checkfamily == null) {
                break;
            }
        }
        if (deslist.size() < srclist.size()) {
            if (Checkifincloud(srclist, newEdge.getDes())) {
                checkfamily = newEdge.getSrc();
                while (checkfamily != newEdge.getDes()) {
                    if (checkfamily.getKey() > weigh) {
                        weigh = checkfamily.getKey();
                        maxedge = checkfamily;
                    }
                    checkfamily = checkfamily.getDad();
                }

            }
        } else if (Checkifincloud(deslist, newEdge.getSrc())) {
            checkfamily = newEdge.getDes();
            while (checkfamily != newEdge.getSrc()) {
                if (checkfamily.getKey() > weigh) {
                    weigh = checkfamily.getKey();
                    maxedge = checkfamily;
                }
                checkfamily = checkfamily.getDad();
            }
        } else {
            int count = 1;
            Node checkdes = null;
            Node checksrc = null;
            while (true) {
                checkdes = deslist.peek();
                checksrc = srclist.peek();
                if (checksrc != checkdes) {
                    break;
                }
                deslist.pop();
                srclist.pop();
            }
            checkfamily = newEdge.getDes();
            while (checkfamily != checkdes.getDad()) {
                if (checkfamily.getKey() > weigh) {
                    weigh = checkfamily.getKey();
                    maxedge = checkfamily;
                }
                checkfamily = checkfamily.getDad();
            }
            checkfamily = newEdge.getSrc();
            while (checkfamily != checksrc.getDad()) {
                if (checkfamily.getKey() > weigh) {
                    weigh = checkfamily.getKey();
                    maxedge = checkfamily;
                }
                checkfamily = checkfamily.getDad();
            }
        }


        if (maxedge != null) {
            for (Node p : this.Nlist) {
                if (p.getName() == maxedge.getName()) {
                    for (Edge x : p.getEdges()) {
                        if (x.getDes().getName() == maxedge.getDad().getName()) {
                            p.getEdges().remove(x);
                            break;
                        }
                        ;
                    }
                }
                if (p.getName() == maxedge.getDad().getName()) {
                    for (Edge x : p.getEdges()) {
                        if (x.getDes().getName() == maxedge.getName()) {
                            p.getEdges().remove(x);
                            break;
                        }
                    }
                }
            }
                this.AddEdge(newEdge.getSrc().getName(), newEdge.getDes().getName(), newEdge.getWeight());
                return;



        }
        return;

    }

    public Boolean Checkifincloud( Stack<Node> list,Node a){
    for (Node x:list ) {
        if (x.getName()==a.getName()){
            return true;
        }
    }
    return false;
}


}
