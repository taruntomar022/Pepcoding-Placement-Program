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
    // to get all the connected graphs
      ArrayList<ArrayList<Integer>> comps = getAllConnectedComponents(graph);
      if(comps.size() == 1){
          System.out.println("true");
      }else{
          System.out.println("false");
      }
   }
   
   public static ArrayList<ArrayList<Integer>> getAllConnectedComponents(ArrayList<Edge>[] graph){
      ArrayList<ArrayList<Integer>> comp = new ArrayList<>();
      boolean visited[] = new boolean[graph.length];
       for(int vrtx = 0;vrtx < graph.length;vrtx++){
           if(!visited[vrtx]){
               ArrayList<Integer> component = new ArrayList<>();
               gcc(graph,vrtx,visited,component);
               comp.add(component);
           }
       }
       return comp;
   }
   
   public static void gcc(ArrayList<Edge>[] graph,int vrtx,boolean visited[],ArrayList<Integer> component){
       component.add(vrtx);
       visited[vrtx] = true;
       for(Edge e : graph[vrtx]){
           if(!visited[e.nbr]){
               gcc(graph,e.nbr,visited,component);
           }
       }
   }
}