import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int arr[][] = new int[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            arr[i][j] = scn.nextInt();
        }
    }
    int start = 0;
    while(start<m){
        if(start%2==0){
            for(int i=0;i<n;i++){
                System.out.println(arr[i][start]);
            }
        }
        if(start%2!=0){
            for(int i=n-1;i>=0;i--){
                System.out.println(arr[i][start]);
            }
        }
        start++;
    }
 }
