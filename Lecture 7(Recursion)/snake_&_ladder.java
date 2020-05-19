import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        // snake and ladder array
        int snl[] = new int[20];
        snl[3] = 17; //ladder
        snl[7] = 11;  //ladder
        snl[13] = 5;  //snake
        snl[19] = 2;   //snake
        // dice history of the player will be stored in moves array
        int moves[] = {2,5,3,4,6,3,4,3,5,1};
        
        phb(0,20,snl,moves,0);
    }
    
    public static void phb(int src,int dest,int snl[],int[] moves, int mvidx){
        //base case
        if(src==dest){
            System.out.println("WIN");
            return;
        }
        // if we have covered all the moves
        if(mvidx == moves.length){
            System.out.println(src);
            return;
        }
        
        if(src == 0){
            //opening with 0 and 6 only
            if(moves[mvidx] == 0 || moves[mvidx] == 6){
                // now i can start my game and I will be at 1 index
                phb(1,dest,snl,moves,mvidx+1);
            }else{
                // if i didn't get 1 or 6 , then I will throw dice again, 
                //and here the mvidx increases but source will remain zero
                phb(src,dest,snl,moves,mvidx+1);
            }
        }else{
            // if we face any snake or ladder, then the moves index will 
            //not increase but our source changes
            if(snl[src]!=0){
                phb(snl[src],dest,snl,moves,mvidx);
            }else{
                if(src + moves[mvidx]<=dest){
                    phb(src+moves[mvidx],dest,snl,moves,mvidx+1);
                }else{
                // if we are getting larger moves than required 
                //    to reach the destination , then we'll just increase
                //the moves array but we'll not change the moves
                    phb(src,dest,snl,moves,mvidx+1);
                }
            }
            
        }
    }
}