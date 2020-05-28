import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    postfix_eval(exp);
    
 }
 
 public static void postfix_eval(String exp){
     Stack<Integer> eval = new Stack<>();
     Stack<String> infix = new Stack<>();
     Stack<String> prefix = new Stack<>();
     for(int i=0;i<exp.length();i++){
         char ch = exp.charAt(i);
         String infix_res = "";
         String prefix_res ="";
         if(ch>='0'&&ch<='9'){
             eval.push(ch-'0');
             infix.push(ch+"");
             prefix.push(ch+"");
         }else{
             if(ch == '-'||ch == '+'||ch=='*'||ch == '/'){
                int op2 = eval.pop();
                int op1 = eval.pop();
                int ans = solve(op1,op2,ch);
                eval.push(ans);
                String op2_infix = infix.pop();
                String op1_infix = infix.pop();
                infix_res = "("+op1_infix+ch+op2_infix+")";
                infix.push(infix_res);
                String op2_prefix = prefix.pop();
                String op1_prefix = prefix.pop();
                prefix_res = ch+op1_prefix+op2_prefix;
                prefix.push(prefix_res);
            }
        }
     }
      System.out.println(eval.peek());
      System.out.println(infix.peek());
      System.out.println(prefix.peek());
 }
 
 
 
 public static int solve(int op1, int op2, char optr){
     if(optr == '+'){
         return op1+op2;
     }
     else if(optr == '-'){
         return op1-op2;
     }
     else if(optr == '*'){
         return op1*op2;
     }
     else{
         return op1/op2;
     }
 }
}