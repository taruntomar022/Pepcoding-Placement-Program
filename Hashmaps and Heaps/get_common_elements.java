import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int a1[] = new int[n1];
    for(int i=0;i<n1;i++){
        a1[i] = scn.nextInt();
    }
    int n2 = scn.nextInt();
    int a2[] = new int[n2];
    for(int i=0;i<n2;i++){
        a2[i] = scn.nextInt();
    }
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i=0;i<n1;i++){
        hm.put(a1[i],0);
    }
    
    for(int i=0;i<n2;i++){
        int num = a2[i];
        if(hm.containsKey(num)){
            System.out.println(num);
            hm.remove(num);
        }
    }
 }

}