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

      // write your code here
      MinimumWire(graph);
   }
    
    public static class MWPair implements Comparable<MWPair>{
        int vrtx;
        int pvrtx; // parent vertex
        int wt;
        MWPair(int vrtx,int pvrtx,int wt){
            this.vrtx = vrtx;
            this.pvrtx = pvrtx;
            this.wt = wt;
        }
        
        public int compareTo(MWPair o){
            return this.wt - o.wt;
        }
    }
    
    public static void MinimumWire(ArrayList<Edge>[] graph){
        PriorityQueue<MWPair> pq = new PriorityQueue<>();
        int src = 0;
        pq.add(new MWPair(src,-1,0));
        boolean[] visited = new boolean[graph.length];
        while(pq.size()>0){
            MWPair rem = pq.remove();
            if(!visited[rem.vrtx]){
                visited[rem.vrtx] = true;
                if(rem.pvrtx != -1){
                    System.out.println("["+rem.vrtx+"-"+rem.pvrtx+"@"+rem.wt+"]");
                }
                for(Edge e : graph[rem.vrtx]){
                    if(!visited[e.nbr]){
                        pq.add(new MWPair(e.nbr,rem.vrtx,e.wt));
                    }
                }
            }
        }
    }
    
}