import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        bs(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void bs(int arr[],int si,int li){
        //base case
        if(li == 0){
            return;
        }
        if(si == li){
            // a new journey begins as the largest number has reached the end, now li changes
            bs(arr,0,li-1);
            return;
        }
        int temp;
        if(arr[si]>arr[si+1]){
            temp = arr[si];
            arr[si] = arr[si+1];
            arr[si+1] = temp;
        }
        bs(arr,si+1,li);
    }
}