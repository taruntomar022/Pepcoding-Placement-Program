import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(dp(str));
    }
    
    public static boolean dp(String str){
        Stack<Character> st = new Stack<>();
 
        for(int i=0;i<str.length();i++){
            char res = str.charAt(i);
            if(res == ')'){
                if(st.peek()=='('){
                    return true;
                }else{
                    while(st.peek()!='('){
                        st.pop();
                    }
                    st.pop();
                }
        
            }else{
                st.push(res);
            }
        }
        return false;
    }

}