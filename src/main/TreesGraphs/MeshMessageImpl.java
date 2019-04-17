package main.TreesGraphs;

import sun.security.krb5.internal.PAData;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class MeshMessageImpl {

    public static void main(String[] args) {
        Map<String, String[]> network = new HashMap<String, String[]>() {{
            put("Min", new String[]{"William", "Jayden", "Omar"});
            put("William", new String[]{"Min", "Noam", "Adam"});
            put("Jayden", new String[]{"Min", "Amelia", "Ren", "Noam"});
            put("Ren", new String[]{"Jayden", "Omar"});
            put("Amelia", new String[]{"Jayden", "Miguel", "Adam"});
            put("Adam", new String[]{"Amelia", "Miguel", "Sofia", "Lucas"});
            put("Miguel", new String[]{"Amelia", "Adam", "Liam", "Nathan"});
            put("Noam", new String[]{"Nathan", "Jayden", "William"});
            put("Omar", new String[]{"Ren", "Min", "Scott"});
        }};
        MeshMessageImpl mm = new MeshMessageImpl();
        List<String> path = mm.getRoute(network, "Jayden", "Adam");

        for (int i = 0; i < path.size(); i++) System.out.print(path.get(path.size() - 1 - i) + " ");
    }

    private List<String> getRoute(Map<String, String[]> network, String start, String end) {
        if (start.equalsIgnoreCase(end)) return Collections.singletonList(start);

        HashSet<String> visitedNames = new HashSet<>();
        Queue<String> messageQueue = new LinkedList<>();

        HashMap<String, String> parentMap = new HashMap<>();

        messageQueue.offer(start);
        visitedNames.add(start);
        parentMap.put(start, null);

        while (!messageQueue.isEmpty()) {
            String name = messageQueue.poll();

            System.out.println("name " + name);
            if (name.equalsIgnoreCase(end)) {
                return constructPath(parentMap, start, end);
            }

            for (String child : network.get(name)) {
                if (!visitedNames.contains(child)) {
                    messageQueue.offer(child);
                    parentMap.put(child, name);
                    visitedNames.add(child);
                }
            }
        }

       return null;
    }

    private List<String> constructPath(HashMap<String, String> parentMap, String start, String end) {
        printParetMap(parentMap);

        List<String> path = new ArrayList<>();
        String curr = end;

        while(curr != null){
            path.add(curr);

            curr = parentMap.get(curr);
        }
        return path;
    }

    private void printParetMap(HashMap<String, String> parentMap) {
        Iterator<String> iter = parentMap.keySet().iterator();
        while(iter.hasNext()){
            String a = iter.next();
            System.out.println(a + " " + parentMap.get(a));

        }
        System.out.println();
    }

}


class Path {
    private String name;
    private List<String> pathToReachName;
    private int indexOfSmallestPath;

    Path(String name, List<String> pathToReachName, int indexOfSmallestPath) {
        this.name = name;
        this.pathToReachName = pathToReachName;
        this.indexOfSmallestPath = indexOfSmallestPath;
    }
}

class ParentName {
    String parent;
    String name;
    List<String> pathToReachName;


    ParentName(String parent, String name, List<String> pathToReachName) {
        this.parent = parent;
        this.name = name;
        this.pathToReachName = pathToReachName;
    }
}