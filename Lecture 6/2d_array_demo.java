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
    
    public static void display(int [][]arr,int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int row = scn.nextInt();
    int col = scn.nextInt();
    int [][]arr = new int[row][col];
    insert(arr,scn,row,col);
    display(arr,row,col);
 }

}