package it.unibo.oop.lab06.generics1;

/**
 *
 */
public final class UseGraph {

    private UseGraph() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String... args) {
        final Graph<String> g = new OrientedGraph<>();
        g.addNode("a");
        g.addNode("b");
        g.addNode("c");
        g.addNode("d");
        g.addNode("e");
        g.addEdge("a", "b");
        g.addEdge("b", "c");
        g.addEdge("c", "d");
        g.addEdge("d", "e");
        g.addEdge("c", "a");
        g.addEdge("e", "a");
        /*
         * Should print ["a","b","c","d","e"], in any order
         */
        System.out.println(g.nodeSet());
        /*
         * ["d","a"], in any order
         */
        System.out.println(g.linkedNodes("c"));
        /*
         * Must print either the path b,c,a or b,c,d,e,a
         */
        System.out.println(g.getPath("b", "a"));
        
        final Graph<String> g2 = new UndirectedGraph<>();
        g2.addNode("a");
        g2.addNode("b");
        g2.addNode("c");
        g2.addNode("d");
        g2.addNode("e");
        g2.addEdge("a", "b");
        g2.addEdge("b", "c");
        g2.addEdge("c", "d");
        g2.addEdge("d", "e");
        g2.addEdge("c", "a");
        g2.addEdge("e", "a");
        /*
         * Should print ["a","b","c","d","e"], in any order
         */
        System.out.println(g2.nodeSet());
        /*
         * ["d","a","b"], in any order
         */
        System.out.println(g2.linkedNodes("c"));
        /*
         * Must print the path b,a
         */
        System.out.println(g2.getPath("b", "a"));
    }
}
