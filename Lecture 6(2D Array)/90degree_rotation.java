import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[][] = new int[n][n];
        transpose(arr);
        for(int row=0;row<n;row++){
            reverse(arr,row);
        }
        display(narr);
    }
    
    public static void transpose(int arr[][]){
        
    }

    public static void reverse(int arr[][],int rowNo){
        int start=0;
        int end = arr[0].length;
        while(start<end){
            int temp = arr[rowNo][end];
            arr[rowNo][start] = arr[rowNo][end];
            arr[rowNo][end] = temp;
            start++;
            end--;
        }
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}