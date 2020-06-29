import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean visited[] = new boolean[graph.length];
      for(int vrtx = 0;vrtx < graph.length;vrtx++){
        if(!visited[vrtx]){
            // unvisited
            visited[vrtx] = true;
            // gcc
            ArrayList<Integer> component = new ArrayList<>();
            gcc(graph,vrtx,visited,component);
            comps.add(component);
        }
          
      }

      System.out.println(comps);
   }// fill ArrayList and mark all directly or indirectly connected vertices
   public static void gcc(ArrayList<Edge>[] graph,int vrtx, boolean visited[],ArrayList<Integer> component){
       component.add(vrtx);
       visited[vrtx] = true;
       for(Edge e : graph[vrtx]){
           if(!visited[e.nbr])
           gcc(graph,e.nbr,visited,component);
       }
       
   }
}