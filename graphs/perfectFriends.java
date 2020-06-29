import java.io.*;
import java.util.*;

public class Main {
   static class Edge{
       int vrtx;
       int nbr;
    
        Edge(int v,int n){
            this.vrtx = v;
            this.nbr = n;
        }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[n];
      for(int i=0;i<n;i++){
          graph[i] = new ArrayList<>();
      }
      
      for(int j=0;j<k;j++){
          String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
          graph[v1].add(new Edge(v1,v2));
          graph[v2].add(new Edge(v2,v1));
      }
      
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean visited[] = new boolean[graph.length];
      for(int vrtx = 0;vrtx < graph.length;vrtx++){
          if(!visited[vrtx]){
            // mark viisted
            visited[vrtx] = true;
            // gcc
            ArrayList<Integer> component = new ArrayList<>();
            gcc(graph,vrtx,visited,component);
            comps.add(component);
          }
      }
     
      int res = 0;
    for(int len = 0;len < comps.size(); len++){
        int prod = 1;
        for(int j = len + 1;j < comps.size(); j++){
            prod = comps.get(len).size() * comps.get(j).size();
            res += prod;
            // System.out.println(len +" ->" +prod);
        }
    }
    
    System.out.println(res);
   }
   
   public static void gcc(ArrayList<Edge>[] graph, int vrtx, boolean[] visited, ArrayList<Integer> component){
       component.add(vrtx);
       visited[vrtx] = true;
       for(Edge e : graph[vrtx]){
           if(!visited[e.nbr]){
               gcc(graph,e.nbr,visited,component);
           }
       }
   }

}