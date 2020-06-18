import java.util.*;

public class Main{

public static class Node{
    int data;
    Node left;
    Node right;
    
    Node(int data){
        this.data = data;
    }
    Node(int data, Node lc, Node rc){
        this.data = data;
        this.left = lc;
        this.right = rc;
    }
}

public static Node construct(int input[],int lo, int hi){
    // base case
    if(lo> hi){
        return null;
    }
    
    int mid = (lo + hi)/2;
    int data = input[mid];
    Node lc = construct(input, lo, mid-1);
    Node rc = construct(input, mid+1,hi);
    Node node = new Node(data, lc, rc);
    
    return node;
}
public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
public static void main(String[] args) {

int input[] = {12, 25, 37, 50, 62, 75, 87};
Node root = construct(input, 0, input.length-1);
display(root);
 }
}