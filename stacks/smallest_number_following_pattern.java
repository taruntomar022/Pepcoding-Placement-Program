import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    snp(str);
    // code
 }
 
 public static void snp(String str){
     int count = 1;
     Stack<Integer> st = new Stack<>();
     String ans = "";
     for(int i=0;i<=str.length();i++){
         st.push(count);
         count++;
         while(st.size()>0&&(i==str.length()||str.charAt(i)=='i')){
             ans += st.pop();
         }
     }
     System.out.println(ans);
 }
}