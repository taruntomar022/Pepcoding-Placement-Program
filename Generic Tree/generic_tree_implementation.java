import java.io.*;
import java.util.*;

public class Main{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int val){
            this.data = val;
        }
    }
    
    public static Node construct(int input[]){
        Stack<Node> st = new Stack<>();
        Node root = new Node(input[0]);
        st.push(root);
        for(int i=1;i<input.length;i++){

            if(input[i] == -1){
                // end of a node means it has no more children
                st.pop();
            }else{
                Node node = new Node(input[i]);
                // to search for the parent of the node
                Node parent = st.peek();
                // add this node to its parent arraylist
                parent.children.add(node);
                st.push(node);
            }
        }
        
        return root;
    }
    
    public static void display(Node node){
        // self printing of the node
        System.out.print(node.data +" -> ");
        for(int i=0;i<node.children.size();i++){
            Node child = node.children.get(i);
            System.out.print(child.data+" ");
        }
        System.out.print(".");
        System.out.println();
        
        // printing its child
        for(int i=0;i<node.children.size();i++){
            Node child = node.children.get(i);
            display(child);
        }
    }
    
    public static void main(String args[]){
        int input[] = {10,20,50,-1,60,-1,-1,30,70,-1,80,-1,-1,40,100,-1,-1,-1};
        Node root = construct(input);
        display(root);
        // System.out.println(root.data);
    }
}