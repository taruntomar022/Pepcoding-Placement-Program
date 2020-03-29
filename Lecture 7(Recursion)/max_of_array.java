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
        int maxval = maxOfArray(arr, 0);
        System.out.print(maxval);
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length-1){
            return arr[idx];
        }
        int ele = arr[idx];
        int max = maxOfArray(arr,idx+1);
        if(ele>max){
            return ele;
        }
        
        return max;
    }
}