import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int a[] = new int[n];
    for(int i=0;i<n;i++){
        a[i] = scn.nextInt();
    }
    // initialization
    HashMap<Integer, Boolean> hm = new HashMap<>();
    for(int i=0;i<n;i++){
        hm.put(a[i],true);
    }
    
    for(int key : hm.keySet()){
        if(hm.containsKey(key - 1)){
            hm.put(key,false); // value update
        }
    }
    // answer formation
    int sp = -1;
    int seqSize = 0;
    for(int i=0;i<n;i++){
        if(hm.get(a[i])==true){
            // local starting point found
            int lsp = a[i];
            int count = 1;
            boolean flag = true;
            int val = lsp + 1;
            while(flag){
                if(hm.containsKey(val)){
                    val = val + 1;
                    count++;
                }else{
                    flag = false;
                }
            }
            if(count > seqSize){
                seqSize = count;
                sp = lsp;
            }
        }
    }
    
    for(int i=sp;i< sp + seqSize;i++){
        System.out.println(i);
    }
 }

}