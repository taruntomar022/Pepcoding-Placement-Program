import java.io.*;
import java.util.*;

public class Main {

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
        floodfill(arr, 0,0,"",new boolean[n][m]);
    }

    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited){
        if(row<0||col<0||row>=maze.length||col>=maze[0].length||maze[row][col]==1||visited[row][col]==true){
            //invalid movement
            return;
        }
        
        if(row==maze.length-1&&col==maze[0].length-1){
            //destination
            System.out.println(psf);
            return;
        }
        
        visited[row][col] = true; //block is occupied
        
        //top movement
        floodfill(maze,row-1,col,psf+"t",visited);
        //left
        floodfill(maze,row,col-1,psf+"l",visited);
        //down
        floodfill(maze,row+1,col,psf+"d",visited);
        //right
        floodfill(maze,row,col+1,psf+"r",visited);
        
        //block is unoccupied
        visited[row][col] = false;
    }
}