import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        for(int row=0;row<n;row++){
            int min = arr[row][0];
            int minidx = 0;
            for(int col=1;col<n;col++){
                if(arr[row][col]<min){
                    min = arr[row][col];
                    minidx = col;
                }
            }
            
            boolean flag = true;
            for(int k=0;k<n;k++){
                if(arr[k][minidx]>arr[row][minidx]){
                    flag = false;
                }
            }
            
            if(flag == true){
                System.out.println(arr[row][minidx]);
                return;
            }
        }
        
        System.out.println("Invalid input");
    }    
}