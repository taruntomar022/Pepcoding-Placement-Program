import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
    // Node(){
    //     this.data = data;
    // }
    // Node(int val){
    //     this.data = val;
    // }
  }
  
  private static class Pair{
     Node node;
     int level;
     Pair(Node node,int level){
         this.node = node;
         this.level= level;
     }
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }
//---------------Using main queue and child queue----------------------
//   public static void levelOrderLinewise(Node node){
//     // write your code here
//     Queue<Node> childQue = new ArrayDeque();
//     Queue<Node> mainQue = new ArrayDeque();
//     mainQue.add(node);
//     while(mainQue.size()>0){
//         // remove
//         Node temp = mainQue.remove();
        
//         // print
//         System.out.print(temp.data+" ");
//         // add in child queue
//         for(Node child:temp.children){
//             childQue.add(child);
//         }
        
//         if(mainQue.size()==0){
//             System.out.println();
//             mainQue = childQue;
//             childQue = new ArrayDeque();
//         }
//     }
//   }

// --------------adding null to the queue when level completes--------------------
//   public static void levelOrderLinewise(Node node){
//       Queue<Node> que = new ArrayDeque();
//       que.add(node);
//       que.add(new Node(Integer.MIN_VALUE));
//       while(que.size()>0){
//           // remove
//           Node temp = que.remove();
//           if(temp.data == Integer.MIN_VALUE){
//               // add a new line
//               System.out.println();
//               if(que.size()>0){
//                 que.add(new Node(Integer.MIN_VALUE));
//               }
//           }else{
//               // print
//               System.out.print(temp.data+" ");
//               // add child in queue
//               for(Node child: temp.children){
//                   que.add(child);
//               }
//           }
//       }
//   }

// --------------using count variable, approach----------------------
    //  public static void levelOrderLinewise(Node node){
    //      Queue<Node> que = new ArrayDeque();
    //      que.add(node);
    //      while(que.size()>0){
    //         int count = que.size();
    //         for(int i=0;i<count;i++){
    //             //remove
    //             node = que.remove();
    //             //print
    //             System.out.print(node.data+" ");
    //             // add
    //             for(Node child:node.children){
    //                 que.add(child);
    //             }
    //         } 
    //         System.out.println();
    //      }
         
         
    //  }

// -----------------using level-maintain approach-----------------------

    public static void levelOrderLinewise(Node node){
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(node,1));
        int level = 1;
        while(que.size()>0){
            //remove
            Pair remP = que.remove();
            Node temp = remP.node;
            int pl = remP.level;
            if(remP.level > level){
                level = remP.level;
                System.out.println();
            }
            //print
            System.out.print(temp.data+" ");
            //add
            for(Node child: temp.children){
                que.add(new Pair(child,level+1));
            }
        }
    }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    levelOrderLinewise(root);
  }

}
