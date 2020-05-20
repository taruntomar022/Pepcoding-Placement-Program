import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int denominations[] = new int[n];
        for(int i=0;i<n;i++){
            denominations[i] = scn.nextInt();
        }
        int amt = scn.nextInt();
        piCombination(denominations,amt,0,"");
        
    }
    static int counter = 0;
   //lpi=> index of last payment made 
    public static void piCombination(int denominations[], int amt,int lpi,String asf){
        if(amt == 0){
            counter++;
            System.out.println(counter+" -> " + asf);
            return;
        }
        
        for(int inst=lpi;inst<denominations.length;inst++){
            if(amt>=denominations[inst]){
                piCombination(denominations,amt-denominations[inst],inst,asf+denominations[inst]+" ");
            }
        }
    }
    
}