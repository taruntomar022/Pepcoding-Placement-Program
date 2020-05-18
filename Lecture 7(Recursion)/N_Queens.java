import java.io.*;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Main{
    public static void main(String args[] ) throws Exception {
        
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int chess[][] = new int[n][n];
        if(printQueens(chess,0)==false){
            System.out.println("NO");
        }
        display(chess);
    }
    public static boolean isSafe(int chess[][],int row,int col){
        //upper move
        for(int i = row;i>=0;i--){
            if(chess[i][col]==1){
                return false;
            }
        }
        //left diagonal
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        //right diagonal
        for(int i=row-1,j=col+1;i>=0&&j<chess.length;i--,j++){
            if(chess[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    public static boolean printQueens(int chess[][],int row){
        if(row==chess.length){
            return true;
        }
        for(int col=0;col<chess.length;col++){
            if(isSafe(chess,row,col)){
                chess[row][col] = 1;
                
                if(printQueens(chess,row+1) == true){
                    return true;
                } 
                chess[row][col] = 0;
            }
        }
        return false;
    }
    
    public static void display(int chess[][]){
    
            System.out.println("YES");
        
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess.length;j++){
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
