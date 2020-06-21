import java.util.*;

public class Main{

public static void main(String[] args) {

// write your code here.
    PriorityQueue<String> pq = new PriorityQueue<>();
    pq.add("Aaman");
    pq.add("sgjh");
    pq.add("Kal");
    pq.add("khs");
    pq.add("hjsjgh");
    pq.add("klkgzhhg");
    pq.add("nnsjhhgghhgjss");
    pq.add("ahaggshjhjkkjjkjkkj");
    System.out.println("Size: "+pq.size());
    while(pq.size()>0){
        System.out.println(pq.remove());
    }

 }
}