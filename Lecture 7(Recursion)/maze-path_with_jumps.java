import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();
	        int m = scn.nextInt();
	        String psf = "";
	        printMazePaths(0,0,n-1,m-1,psf);
	        System.out.println();

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
       
        if(sr==dr&&sc==dc){
	            System.out.println(psf);
	            return;
	        }
	        //horizontal call
	        for(int i=1;sc+i<=dc;i++){
	            printMazePaths(sr,sc+i,dr,dc,psf+"h"+i);
	        }
	        
	        //vertical call
	        for(int j=1;sr+j<=dr;j++){
	            printMazePaths(sr+j,sc,dr,dc,psf+"v"+j);
	            
	        }
	        
	        //diagonal call
	        for(int k=1;sr+k<=dr&&sc+k<=dc;k++){
	            printMazePaths(sr+k,sc+k,dr,dc,psf+"d"+k);
	        }
    }

}