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
        int x = scn.nextInt();
        
        System.out.print(lastIndex(arr,0,x));
    }

    public static int lastIndex(int[] arr, int idx, int x){
        
        if(idx == arr.length){
            return -1;
        }
        //pre stack build
        int forwardIdx = lastIndex(arr,idx+1,x);
        //post area, stack destroy
        if(forwardIdx == -1){
            //element not found
            if(arr[idx]==x){
                return idx;
            }
            return -1;
        }else{
            //element was found earlier
            return forwardIdx;
        }
        
        
    }

}