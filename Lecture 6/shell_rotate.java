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
        
        int shell = scn.nextInt();
        int rot = scn.nextInt();
        shellrotate(arr,shell,rot);
        
    }
    
    public static void shellrotate(int arr[][],int shell, int rot){
        int n = arr.length;
        int m = arr[0].length;
        int x = m-2*(shell-1);
        int y = n-2*(shell-1);
        int count = 2*(x+y)-4;
        // System.out.println(count);
        //1. Extract shell elements
        extract(arr,shell,count,rot);
        //2. Rotate shell elements
        
        //3. Insert shell elements
        
    }

    public static void extract(int arr[][],int shell,int count,int rot){
        int n = arr.length;
        int m = arr[0].length;
        int arr1d[] = new int[count];
        int pos = 0;
        
        //left wall
        for(int i=shell-1;i<=n-shell;i++){
            arr1d[pos] = arr[i][shell-1];
            pos++;
        }
        //bottom wall
        for(int j=shell;j<=m-shell;j++){
            arr1d[pos] = arr[n-shell][j];
            pos++;
        }
        //right wall
        for(int i=n-shell-1;i>=shell-1;i--){
            arr1d[pos] = arr[i][m-shell];
            pos++;
        }
        //top wall
        for(int j=m-shell-1;j>shell-1;j--){
            arr1d[pos] = arr[shell-1][j];
            pos++;
        }
        
        rotate(arr1d,shell,rot,count,arr);
        
    }

    public static void rotate(int arr1d[],int shell, int rot,int count,int arr[][]){
        rot = rot%count;
        if(rot<0){
            rot += count;
        }
        int rotation = count - rot;
        int[] narr = new int[count]; 
        int post = 0;
        for(int j=rotation;j<count;j++){
            narr[post] = arr1d[j];
            post++;
        }
        
        for(int h=0;h<rotation;h++){
            narr[post] = arr1d[h];
            post++;
        }
        
        insert(narr,shell,arr);
    }

    public static void insert(int narr[],int shell, int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int count = narr.length;
        int pos = 0;
        //left wall
        for(int i=shell-1;i<=n-shell;i++){
            arr[i][shell-1] = narr[pos];
            pos++;
        }
        //bottom wall
        for(int j=shell;j<=m-shell;j++){
            arr[n-shell][j] = narr[pos];
            pos++;
        }
        //right wall
        for(int i=n-shell-1;i>=shell-1;i--){
            arr[i][m-shell] =  narr[pos];
            pos++;
        }
        //top wall
        for(int j=m-shell-1;j>shell-1;j--){
            arr[shell-1][j] =  narr[pos];
            pos++;
        }
        
        display(arr);
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