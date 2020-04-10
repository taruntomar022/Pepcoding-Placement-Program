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
        System.out.println(buySell(arr));
    }

    public static int buySell(int arr[]){
        int n = arr.length;
        int bp = 0, sp = 0, profits = 0;
        for(int idx = 0;idx<=n-2;idx++){
            if(arr[idx] <= arr[idx+1]){
                //prices hike
                sp++;
            }else{
                //potential loss
                
                //settle previous profits
                profits += arr[sp] - arr[bp];
                
                //update your selling and buying point
                sp = bp = idx+1;
            }
        }
        
        //include latest profit
        profits += arr[sp] - arr[bp];
        
        return profits;
    }
}