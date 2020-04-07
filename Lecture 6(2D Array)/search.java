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
        int searchele = scn.nextInt();
        int j=n-1;
        int i=0;
        while(!(i>=n||j<0)){
            if(arr[i][j]==searchele){
                System.out.println(i);
                System.out.println(j);
                return;
            }else if(arr[i][j]>searchele){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("Not Found");
        
    }

}