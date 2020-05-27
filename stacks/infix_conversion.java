import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    infix_conv(exp);
 }
 
 public static void infix_conv(String exp){
     //optr op1 op2
     Stack<String>  prefix = new Stack<>();
     //op1 op2 optr
     Stack<String> postfix = new Stack<>();
     //operator stack
     Stack<Character> operator = new Stack<>();
     for(int i=0;i<exp.length();i++){
         char ch = exp.charAt(i);
         if(isOperand(ch)){
             prefix.push(""+ch);
             postfix.push(""+ch);
         }else if(ch == '('){
             operator.push(ch);
         }else if(ch == ')'){
             while(operator.peek()!='('){
                char optr = operator.pop();
                // prefix 
                String preOp2 = prefix.pop();
                String preOp1 = prefix.pop();
                prefix.push(optr + preOp1 + preOp2);
                //postfix
                String postOp2 = postfix.pop();
                String postOp1 = postfix.pop();
                postfix.push(postOp1 + postOp2 + optr);
             }
             
             operator.pop();
         }else if(ch == '-'||ch == '+'|| ch == '*' || ch == '/'){
             while(operator.size()>0 && operator.peek() !='(' && preced(operator.peek())>=preced(ch)){
                 char optr = operator.pop();
                // prefix 
                String preOp2 = prefix.pop();
                String preOp1 = prefix.pop();
                prefix.push(optr + preOp1 + preOp2);
                //postfix
                String postOp2 = postfix.pop();
                String postOp1 = postfix.pop();
                postfix.push(postOp1 + postOp2 + optr);
             }
             operator.push(ch);
         }
     }
     
     while(operator.size()>0){
         char optr = operator.pop();
         // prefix 
        String preOp2 = prefix.pop();
        String preOp1 = prefix.pop();
        prefix.push(optr + preOp1 + preOp2);
        //postfix
        String postOp2 = postfix.pop();
        String postOp1 = postfix.pop();
        postfix.push(postOp1 + postOp2 + optr);
        
     }
     
    System.out.println(postfix.peek());
    System.out.println(prefix.peek());
 }
 
 public static int preced(char optr){
     if(optr == '-'|| optr == '+'){
         return 1;
     }else{
         return 2;
     }
 }
 
 public static boolean isOperand(char ch){
     if((ch>='0'&&ch<='9')||(ch>='a'&&ch<='z'||ch>='A'&&ch<='Z')){
         return true;
     }
     return false;
 }
}