import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int tq = scn.nextInt();
        int b = scn.nextInt();
        permutations(new boolean[b],tq,0,"");
    }
    //qpsf -> queen placed so far
    static int counter = 0;
    public static void permutations(boolean[] boxes, int tq,int qpsf,String asf){
        //base class
        if(qpsf == tq){
            counter ++;
            System.out.println(counter+" . "+asf);
            return;
        }
        
        for(int b = 0;b < boxes.length; b++){
            if(boxes[b] == false){
                boxes[b] = true;
                permutations(boxes,tq,qpsf+1,asf+"q"+(qpsf+1)+"b"+b+" ");
                // after traversing makes the boxes false
                boxes[b] = false;
            }
        }
    }
}