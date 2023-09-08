public class Main {

    public static void main(String[] args) {

        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");

        System.out.println("\nGraph:");
        myGraph.printGraph();

        /*
            EXPECTED OUTPUT:
            ----------------
            Graph:
            {A=[], B=[]}

        */

    }

}