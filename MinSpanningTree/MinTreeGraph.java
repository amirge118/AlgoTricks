package AlgoTrick;

public class MinTreeGraph {

    public static void main(String[] args) {
        Graph G = new Graph(21);
        int i = 0;
        String[] setNames = {"a", "b", "c", "d", "e", "f","g","h","i","j", "k", "l", "m", "n", "o","p","q","r","s","t","u"};
        for (Node x : G.getNlist()) {
            x.setName(setNames[i++]);
        }
        G.AddEdge("a", "b", 10);
        G.AddEdge("b", "c", 2);
        G.AddEdge("c", "d", 3);
        G.AddEdge("d", "e", 4);
        G.AddEdge("e", "f", 5);
        G.AddEdge("f", "g", 8);
        G.AddEdge("g", "h", 5);
        G.AddEdge("h", "i", 11);
        G.AddEdge("i", "j", 12);
        G.AddEdge("j", "k", 14);
        G.AddEdge("k", "l", 10);
        G.AddEdge("l", "m", 1);
        G.AddEdge("m", "n", 8);
        G.AddEdge("n", "o", 21);
        G.AddEdge("o", "p", 3);
        G.AddEdge("p", "q", 45);
        G.AddEdge("q", "r", 10);
        G.AddEdge("r", "s", 8);
        G.AddEdge("s", "t", 17);
        G.AddEdge("t", "u", 10);
        G.AddEdge("u", "s", 1);
        G.AddEdge("a", "c", 30);
        G.AddEdge("b", "d", 4);
        G.AddEdge("c", "e", 14);
        G.AddEdge("d", "f", 100);
        G.AddEdge("e", "g", 62);
        G.AddEdge("f", "h", 22);
        G.AddEdge("g", "i", 23);
        G.AddEdge("h", "j", 41);
        G.AddEdge("i", "k", 18);
        G.AddEdge("j", "l", 11);
        G.AddEdge("k", "m", 8);
        G.AddEdge("l", "n", 7);
        G.AddEdge("m", "o", 9);
        G.AddEdge("n", "p", 3);
        G.AddEdge("o", "q", 7);
        G.AddEdge("p", "r", 1);
        G.AddEdge("q", "s", 14);
        G.AddEdge("r", "t", 10);
        G.AddEdge("s", "u", 13);
        G.AddEdge("t", "q", 28);
        G.AddEdge("a", "f", 12);
        G.AddEdge("b", "e", 14);
        G.AddEdge("c", "f", 7);
        G.AddEdge("d", "g", 1);
        G.AddEdge("e", "h", 5);
        G.AddEdge("f", "i", 7);
        G.AddEdge("g", "j", 12);
        G.AddEdge("h", "k", 78);
        G.AddEdge("i", "l", 10);
        G.AddEdge("j", "m", 56);
        G.AddEdge("k", "n", 24);
        G.printG();


        Graph MinTree = G.MinTreeGraph("a");
        MinTree.printG();

        Edge newEdge= new Edge(G.getNlist()[5],G.getNlist()[7],100);
        MinTree.RemoveOneEdge(newEdge);
        MinTree.printG();
        Edge newEdge2= new Edge(G.getNlist()[0],G.getNlist()[3],6);
        MinTree.RemoveOneEdge(newEdge2);
        MinTree.printG();



    }


}
