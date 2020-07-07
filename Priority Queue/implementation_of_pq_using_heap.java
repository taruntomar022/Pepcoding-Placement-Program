import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    
    public void swap(int idx1,int idx2){
        int d1 = data.get(idx1);
        int d2 = data.get(idx2);
        data.set(idx1,d2);
        data.set(idx2,d1);
    }

    public void upheapify(int ci){
        if(ci == 0){
            // single element int the arraylist
            return;
        }
        else{
            int pi = (ci-1)/2;
            if(data.get(pi) > data.get(ci)){
                swap(pi,ci);
                upheapify(pi);
            }
        }
    }

    public void add(int val) {
      data.add(val);
      // data is always added in the last
      upheapify(data.size()-1);
    }

    public void downheapify(int pi){
        int lci = (pi*2)+1;
        int rci = (pi*2)+2;
        int minidx = pi;
        if(data.size() > lci && data.get(minidx) > data.get(lci)){
            minidx = lci;
        }
        if(data.size() > rci && data.get(minidx) > data.get(rci)){
            minidx = rci;
        }
        if(minidx != pi){
            swap(minidx,pi);
            downheapify(minidx);
        }
    }

    public int remove() {
      if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      else{
          swap(0, data.size()-1);
          int ele = data.remove(data.size()-1);
          downheapify(0);
          return ele;
      }
    }

    public int peek() {
      if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }else{
          int ele = data.get(0);
          return ele;
      }
    }

    public int size() {
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}