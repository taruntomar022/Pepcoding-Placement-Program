import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in); 
        String str = scn.nextLine();
        System.out.println(balancedB(str));
    }
    public static boolean balancedB(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            char res = str.charAt(i);
            if(res == '('||res == '{'||res == '['){
                st.push(res);
            }
            else if(res == ')'){
                if(st.size()==0||st.peek()!='('){
                    return false;
                }else{
                    st.pop();
                }
            }
            else if(res == '}'){
                if(st.size()==0||st.peek() != '{'){
                   return false;
                }else{
                   st.pop();
                }
            }
            else if(res == ']'){
                if(st.size()==0||st.peek() != '['){
                    return false;
                }else{
                    st.pop();
                }
            }
    }if(st.size()>0){
        return false;
    }
    
    return true;
    
        
    }
}
