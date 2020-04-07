import java.io.*;
import java.util.*;

public class Main{
    
    public static void insert(int [][]arr,Scanner scn,int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j] = scn.nextInt();
            }
        }
    }

    public static void prod(int [][]arr1,int [][]arr2){
        int row1 = arr1.length;
        int col1 = arr1[0].length;
        int row2 = arr2.length;
        int col2 = arr2[0].length;
        int [][]prod = new int[row1][col2];
        if(col1!=row2){
            System.out.println("Invalid input");
        }else{
            
            
            for(int i=0;i<row1;i++){
                for(int j=0;j<col2;j++){
                    prod[i][j] = 0;
                    for(int k=0;k<col1;k++){
                        prod[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }
            for(int i=0;i<row1;i++){
            for(int j=0;j<col2;j++){
                System.out.print(prod[i][j]+" ");
            }
            System.out.println();
        }
        }
    }
    
public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int row1 = scn.nextInt();
    int col1 = scn.nextInt();
    int arr1[][] = new int[row1][col1];
    insert(arr1,scn,row1,col1);
    int row2= scn.nextInt();
    int col2 = scn.nextInt();
    int arr2[][] = new int[row2][col2];
    
    insert(arr2,scn,row2,col2);
    
    prod(arr1,arr2);
 }

}