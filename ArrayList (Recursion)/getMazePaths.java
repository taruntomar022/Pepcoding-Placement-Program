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
	   ArrayList<String> horizontalP = getMazePaths(sr,sc+1,dr,dc); 
	   ArrayList<String> verticalP = getMazePaths(sr+1,sc,dr,dc);
	   ArrayList<String> myresult = new ArrayList<>();
	   
       for(String val:horizontalP){
            myresult.add("h"+val);
	   }
       
       for(String val:verticalP){
            myresult.add("v"+val);
        }
        
        return myresult;
    }

}