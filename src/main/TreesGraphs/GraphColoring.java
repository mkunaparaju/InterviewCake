package main.TreesGraphs;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class GraphColoring {

    public static void main(String[] args) {
        GraphNode a = new GraphNode("a");
        GraphNode b = new GraphNode("b");
        GraphNode c = new GraphNode("c");

        a.addNeighbor(b);
        b.addNeighbor(a);
        b.addNeighbor(c);
        c.addNeighbor(b);

        GraphNode[] graph = new GraphNode[] { a, b, c };

        colorGraph(graph);

        for(GraphNode node: graph){
            System.out.println(node.getColor());
        }
    }

    private static void colorGraph(GraphNode[] graph) {
        if(graph.length == 0) throw new IllegalArgumentException("Must have atleast one graph");
        GraphNode start = graph[0];
        ArrayDeque<GraphNode> queue = new ArrayDeque<>();
        queue.offer(start);
        List<String> allColors = new ArrayList<>();
        allColors.add("r");
        allColors.add("b");
        allColors.add("g");
        allColors.add("y");
        Set<GraphNode> visited = new HashSet<>();

        while(!queue.isEmpty()){
            System.out.println("inside queue");
            GraphNode node = queue.poll();
            List<String> illegal = new ArrayList<>();

            if(!visited.contains(node)) {
                if (!node.hasColor()) {
                   // System.out.println("node " + node.getLabel());
                    for (GraphNode neighbour : node.getNeighbors()) {

                        if (neighbour.hasColor()) {
                            illegal.add(neighbour.getColor());
                            System.out.println("neigh color " +neighbour.getLabel() +" " + neighbour.getColor());
                        } else {
                            System.out.println("neightbor adding " + neighbour.getLabel());
                            queue.offer(neighbour);
                        }
                    }
                    for (String color : allColors) {
                        //System.out.println("node " + node.getLabel() + " color " + color);
                        if (!illegal.contains(color)) node.setColor(color);
                    }
                }
                visited.add(node);
            }
        }
    }


}
 class GraphNode {

    private String label;
    private Set<GraphNode> neighbors;
    private String color;

    public GraphNode(String label) {
        this.label = label;
        neighbors = new HashSet<GraphNode>();
        color = null;
    }

    public String getLabel() {
        return label;
    }

    public Set<GraphNode> getNeighbors() {
        return Collections.unmodifiableSet(neighbors);
    }

    public void addNeighbor(GraphNode neighbor) {
        neighbors.add(neighbor);
    }

    public boolean hasColor() {
        return color != null;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
