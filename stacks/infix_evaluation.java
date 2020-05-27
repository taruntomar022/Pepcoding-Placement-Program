import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    System.out.println(infix_eval(str));
 }
 
 public static int infix_eval(String str){
    Stack<Integer> operand = new Stack<>();
    Stack<Character> operator = new Stack<>();
    for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);
        if(ch >= '0' && ch <= '9'){
            operand.push(ch-'0');
        }else if(ch == '('){
            operator.push(ch);
        }else if(ch == ')'){
            while(operator.peek() !='('){
                char optr = operator.pop();
                int opr2 = operand.pop();
                int opr1 = operand.pop();
                int ans = solve(opr1,opr2,optr);
                operand.push(ans);
             }
             operator.pop();
        }else if(ch == '-'||ch == '+'||ch=='*'||ch == '/'){
            while(operator.size()>0&& operator.peek() != '(' && preced(operator.peek())>=preced(ch)){
                char optr = operator.pop();
                int opr2 = operand.pop();
                int opr1 = operand.pop();
                int ans = solve(opr1,opr2,optr);
                operand.push(ans);
            }
            operator.push(ch);
        }
    }
    while(operator.size()>0){
        char optr = operator.pop();
        int opr2 = operand.pop();
        int opr1 = operand.pop();
        int ans = solve(opr1,opr2,optr);
        operand.push(ans);
    }
    return operand.peek();
 }
 
 public static int solve(int opr1, int opr2, char optr){
     if(optr == '+'){
         return opr1+opr2;
     }
     else if(optr == '-'){
         return opr1-opr2;
     }
     else if(optr == '*'){
         return opr1*opr2;
     }
     else{
         return opr1/opr2;
     }
 }
 
 public static int preced(char optr){
     if(optr=='-'||optr=='+'){
         return 1;
     }else{
         return 2;
     }
 }
}