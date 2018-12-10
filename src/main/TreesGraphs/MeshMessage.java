package main.TreesGraphs;

import javax.naming.Name;
import java.lang.reflect.Array;
import java.util.*;

public class MeshMessage {
//not done do again later
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
        ArrayDeque<NamePath> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        HashMap<String, List<String>> path = new HashMap<>();
        NamePath node = new NamePath(start, path);
        queue.offer(node);

        while (!queue.isEmpty()) {
            NamePath pair = queue.poll();
            String name = pair.name;
            path = pair.path;

            System.out.println(name);
            if (!visited.contains(name)) {
                if(path.containsKey(name)){
                    List<String> pathNames = path.get(name);
                    pathNames.add(name);
                    path.put(name,pathNames );
                }
                else{
                    List<String> pathNames = new ArrayList<String>();
                    pathNames.add(name);
                    path.put(name,pathNames );
                }
                if (name == end) break;
                for (String next : network.get(name)) {
                    System.out.println("next " + next);
                    if(path.containsKey(next)){
                        List<String> nextNames = path.get(next);
                        nextNames.add(name);
                        path.put(next, nextNames);
                    }else{
                        List<String> nextNames = new ArrayList<>();
                        nextNames.add(name);

                        path.put(next, nextNames);
                    }
                    queue.offer(new NamePath(next, path));
                }
                visited.add(name);
            }
        }


        return path.get(end);
    }

}

class NamePath{
    String name;
    HashMap<String, List<String>> path;

    NamePath(String name, HashMap<String, List<String>> path){
        this.name = name;
        this.path = path;
    }
}