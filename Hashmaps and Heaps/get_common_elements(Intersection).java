import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n1= scn.nextInt();
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
        
        if(hm.containsKey(a1[i])){
            int val = hm.get(a1[i]);
            hm.put(a1[i], val+1);
        }else{
            hm.put(a1[i],1);
        }
    }
    for(int i=0;i<n2;i++){
        int num = a2[i];
        if(hm.containsKey(num)){
            int val = hm.get(num);
            hm.put(num,val-1);
            System.out.println(num);
            if(hm.get(num)==0){
                hm.remove(num);
            }
        }
    }

 }

}