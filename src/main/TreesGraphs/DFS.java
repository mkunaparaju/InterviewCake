package main.TreesGraphs;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class DFS {

    public static void main(String[] args) {

    }

    public void DFS(int v, LinkedList<Integer> adj[], boolean visited[])
    {
        if(visited[v]) return;
        visited[v] = true;
        System.out.print(v + " ");
        LinkedList<Integer> adjList = adj[v];
        for(int i : adjList){
            DFS(i, adj, visited);
        }
    }


}
