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

      int src = Integer.parseInt(br.readLine());
      dijkstra(graph,src);
      
   }
   
   public static class Pair implements Comparable<Pair>{
       int vrtx;
       String psf;
       int wsf;
       Pair(int v,String psf,int wsf){
           this.vrtx = v;
           this.psf = psf;
           this.wsf = wsf;
       }
       
       public int compareTo(Pair other){
           return this.wsf - other.wsf;
       }
   }
   
   public static void dijkstra(ArrayList<Edge>[] graph,int src){
       boolean[] visited = new boolean[graph.length];
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       pq.add(new Pair(src,""+src,0));
       while(pq.size()>0){
           // remove
           Pair res = pq.remove();
           if(!visited[res.vrtx]){
            //   mark + print
               visited[res.vrtx] = true;
               System.out.println(res.vrtx + " via "+res.psf+" @ "+res.wsf);
               // add
               for(Edge e : graph[res.vrtx]){
                   if(!visited[e.nbr]){
                       pq.add(new Pair(e.nbr,res.psf+e.nbr,res.wsf+e.wt));
                   }
               }
               
           }
       }
   } 
}