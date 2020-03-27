import java.io.*;
import java.util.*;

public class Main {

    public static void insert(int arr[][],Scanner scn){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int arr[][] = new int[r][c];
        insert(arr,scn);
        exitpoint(arr);
    }
    
    public static void exitpoint(int arr[][]){
        //0 => east direction row same, col changes
        //1 => south direction row changes, col same
        //2 => west direction, row same, col changes
        //3 => north direction, row changes , col same
        int dir = 0;
        int n = arr.length;
        int m = arr[0].length;
        int row = 0,col=0;
        while(true){
            dir = (dir + arr[row][col])%4;
            if(dir == 0){
                //east dir
                col++;
            }
            else if(dir == 1){
                //south
                row++;
            }
            else if(dir == 2){
                //west
                col--;
            }
            else{
                //north
                row--;
            }
    
        //exit point calculation
        if(col==m){
            //right wall exit
            col--;
            break;
        }
        else if(row == n){
            //bottom wall exit
            row--;
            break;
        }
        else if(col == -1){
            //left wall exit
            col++;
            break;
        }
        else if(row == -1){
            //top wall exit
            row++;
            break;
        }
    }
    System.out.println(row);
    System.out.println(col);
  }

}