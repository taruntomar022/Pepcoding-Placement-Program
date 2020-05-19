import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int tq = scn.nextInt();
        int b = scn.nextInt();
        combinations(new boolean[b],tq,0,"",-1);
    }
    //qpsf -> queen placed so far
    // lqpb -> last queen placed in which box
    static int counter = 0;
    public static void combinations(boolean[] boxes, int tq,int qpsf,String asf,int lqpb){
        //base class
        if(qpsf == tq){
            counter ++;
            System.out.println(counter+" . "+asf);
            return;
        }
        
        for(int b = lqpb+1;b < boxes.length; b++){
            if(boxes[b] == false){
                boxes[b] = true;
                combinations(boxes,tq,qpsf+1,asf+"q"+(qpsf+1)+"b"+b+" ",b);
                // after traversing makes the boxes false
                boxes[b] = false;
            }
        }
    }
}