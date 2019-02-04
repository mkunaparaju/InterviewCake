package main.TreesGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {

    }

    public void bfs(int v, ArrayList<Integer> adj[], boolean visited[])
    {
        LinkedList<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.add(v);
        visited[v] = true;

        while (nodeQueue.size() !=0){

            v = nodeQueue.poll();
            System.out.print(v + " ");
            Iterator<Integer> iter = adj[v].listIterator();

            while(iter.hasNext()){
                int i = iter.next();
                if(!visited[i]){
                    visited[i] = true;
                    nodeQueue.offer(i);
                }
            }

        }
    }


}
