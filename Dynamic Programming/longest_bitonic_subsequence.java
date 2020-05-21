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
        lbs(arr,n);
    }
    
    public static void lbs(int arr[],int n){
        int ldp[] = new int[n];
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]&&max<ldp[j]){
                    max = ldp[j];
                }
            }
            ldp[i] = max+1;
        }
        
        int rdp[] = new int[n];
        for( int i=n-1;i>=0;i--){
            int max = 0;
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]&&max<rdp[j]){
                    max = rdp[j];
                }
            }
            rdp[i] = max+1;
        }
        int ans = ldp[0]+rdp[0]-1;
        for(int i=1;i<n;i++){
            if(ans<ldp[i]+rdp[i]-1){
                ans = ldp[i]+ rdp[i]-1;
            }
        }
        
        System.out.println(ans);
    }

}