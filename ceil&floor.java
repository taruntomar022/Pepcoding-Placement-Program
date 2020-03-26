import java.io.*;
import java.util.*;

public class Main{

public static void insert(int[] arr,Scanner scn){
    for(int i=0;i<arr.length;i++){
        arr[i] = scn.nextInt();
    }
}
public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    insert(arr,scn);
    int ele = scn.nextInt();
    int floorval = -1;
    int ceilval = -1;
    int pos = 0;
    int idx = 0;
    while(pos<n){
        if(arr[pos]<=ele){
            floorval = arr[pos];
            idx = pos;
        }else{
            break;
        }
        
        pos++;
    }
    if(arr[idx]==ele){
        ceilval = arr[idx];
    }else{
        ceilval = arr[idx+1];
    }
    System.out.println(ceilval);
    System.out.println(floorval);
    
 
     
 }

}