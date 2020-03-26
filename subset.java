import java.io.*;
import java.util.*;

public class Main{
    
    public static void insert(int[] arr, Scanner scn){
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
    }

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    insert(arr, scn);
    subset(arr);
 }
public static void subset(int[] arr){
    int range = (int)Math.pow(2,arr.length);
    int st = 0;
    while(st<range){
        int bin = st;
        int idx = arr.length-1;
        int k = 0;
        String ans = "";
        while(k<arr.length){
            int rem = bin%2;
            bin = bin/2;
            if(rem == 0){
                ans = "-\t"+ans;
            }
            else{
                ans = arr[idx]+"\t"+ans;
            }
            k++;
            idx--;
            
        }
        System.out.println(ans);
        st++;
    }
    
}
}