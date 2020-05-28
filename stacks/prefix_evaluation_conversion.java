import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    prefix_con(exp);
 }
 
 public static void prefix_con(String exp){
     Stack<Integer> eval = new Stack<>();
     Stack<String> infix = new Stack<>();
     Stack<String> postfix = new Stack<>();
     for(int i=exp.length()-1;i>=0;i--){
         char ch = exp.charAt(i);
         String infix_res = "";
         String postfix_res ="";
         if(ch >= '0' && ch<='9'){
             eval.push(ch-'0');
             infix.push(ch+"");
             postfix.push(ch+"");
         }else{
             int op1 = eval.pop();
            int op2 = eval.pop();
            int ans = solve(op1,op2,ch);
            eval.push(ans);
            String op2_infix = infix.pop();
            String op1_infix = infix.pop();
            infix_res = "("+op2_infix+ch+op1_infix+")";
            infix.push(infix_res);
            String op2_postfix = postfix.pop();
            String op1_postfix = postfix.pop();
            postfix_res = op2_postfix+op1_postfix+ch;
            postfix.push(postfix_res);
         }
     }
     System.out.println(eval.peek());
      System.out.println(infix.peek());
      System.out.println(postfix.peek());
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