import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
	    int m = scn.nextInt();
        ArrayList<String> result = getMazePaths(0,0,n-1,m-1);
        System.out.println(result);

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr&&sc==dc){
	            ArrayList<String> list = new ArrayList<>();
                list.add("");
                return list;
	   }
	   
	   if(sr>dr||sc>dc){
	       ArrayList<String> invalid = new ArrayList<String>();
	       return invalid;
	   }
	   
	   ArrayList<String> myresult = new ArrayList<>();
	   ArrayList<String> len1;
	   ArrayList<String> len2;
	   ArrayList<String> len3;
	     
	   for(int i=1;sc+i<=dc;i++){
	           len1 = getMazePaths(sr,sc+i,dr,dc);
	           for(String val:len1){
	               myresult.add("h"+i+val);
	           }
	        }
	        
	        //vertical call
	        for(int j=1;sr+j<=dr;j++){
	           len2 = getMazePaths(sr+j,sc,dr,dc);
	           for(String val:len2){
	               myresult.add("v"+j+val);
	           }
	        }
	        
	        //diagonal call
	        for(int k=1;sr+k<=dr&&sc+k<=dc;k++){
	          len3 = getMazePaths(sr+k,sc+k,dr,dc);
	          for(String val:len3){
	               myresult.add("d"+k+val);
	           }
	        }
        return myresult;
    }

}