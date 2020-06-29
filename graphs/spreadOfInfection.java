
import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
    public static class Pair{
        int vrtx;
        int toi; // time of infection
         Pair(int v,int tp){
             this.vrtx = v;
             this.toi = tp;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      System.out.println(spreadOfInfection(graph,src,t,0));
      
   }
    public static int spreadOfInfection(ArrayList<Edge>[] graph,int src,int t,int tp){
      boolean visited[] = new boolean[graph.length]; 
      Queue<Pair> que = new ArrayDeque<>();
      int count = 0;
      que.add(new Pair(src,1));
      while(que.size()>0){
          Pair res = que.remove();
              if(!visited[res.vrtx]){
                  visited[res.vrtx] = true;
                  count++;
              for(Edge e : graph[res.vrtx]){
                  if(!visited[e.nbr] && res.toi < t)
                      que.add(new Pair(e.nbr,res.toi+1));
                  }
              }
      }
        return count;
    }
}
