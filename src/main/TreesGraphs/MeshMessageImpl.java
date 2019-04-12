package main.TreesGraphs;

import java.util.*;

public class MeshMessageImpl {

    public static void main(String[] args) {
        Map<String, String[]> network = new HashMap<String, String[]>() {{
            put("Min",     new String[] { "William", "Jayden", "Omar" });
            put("William", new String[] { "Min", "Noam","Adam" });
            put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
            put("Ren",     new String[] { "Jayden", "Omar" });
            put("Amelia",  new String[] { "Jayden", "Miguel" });
            put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
            put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
            put("Noam",    new String[] { "Nathan", "Jayden", "William" });
            put("Omar",    new String[] { "Ren", "Min", "Scott" });
        }};
        MeshMessage mm = new MeshMessage();;
        List<String> path = mm.getRoute(network, "Jayden", "Adam");

        for(String name : path) System.out.print(name + " ");
    }

    private List<String> getRoute(Map<String, String[]> network, String start, String end) {
        HashMap<String, List<String>> visitedPathMap = new HashMap<>();
        

    }
}
