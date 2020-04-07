import java.io.*;
import java.util.*;

public class Main {
    
    public static void insert(int arr[][],Scanner scn,int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j] = scn.nextInt();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        int arr[][] = new int[row][col];
        
        insert(arr,scn,row,col);
        
        int count = 0;
        int rowmin = 0;
        int rowmax = row-1;
        int colmin = 0;
        int colmax = col-1;
        while(count<row*col){
            
            
            //left wall
            for(int st=rowmin;st<=rowmax&&count<row*col;st++){
                System.out.println(arr[st][colmin]);
                count++;
            }
            colmin++;
            //bottom wall
            for(int st=colmin;st<=colmax&&count<row*col;st++){
                System.out.println(arr[rowmax][st]);
                count++;
            }
            rowmax--;
            
            
            //right wall
            for(int st=rowmax;st>=rowmin&&count<row*col;st--){
                System.out.println(arr[st][colmax]);
                count++;
            }
            colmax--;
            //top wall
            for(int st=colmax;st>=colmin&&count<row*col;st--){
                System.out.println(arr[rowmin][st]);
                count++;
            }
            rowmin++;
            
            
            
            
        
        }
        
    }

}