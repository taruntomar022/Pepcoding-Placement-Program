import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        
        //memoization
        System.out.println(minMoves(arr));
        //recursion
        // System.out.pritnln(minMoves(arr,0);
        
    }
    
    //by recursion
    // public static int minMoves(int steps[],int pos){
    //     if(pos==steps.length-1){
    //         //destination reached
    //         return 0;
    //     }
        
    //     int maxMove = steps[pos];
    //     if(maxMove == 0){
    //         return Integer.MAX_VALUE;
    //     }
    //     int min = Integer.MAX_VALUE;
    //     for(int len = 1;len<=maxMove&&pos+len<steps.length;len++){
    //         min = Math.min(min,minMoves(steps,pos+len));  //minimum till now
    //     }
    //     return min+1;
    // }

    //memoization
    public static int minMoves(int[] arr,int n){
        if(pos == steps.length-1){
            return 0;
        }
    }
}