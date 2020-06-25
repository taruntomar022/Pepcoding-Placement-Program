import java.util.PriorityQueue;

public class KlargestElement {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
  
        for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }
  
        int k = Integer.parseInt(br.readLine());
        // write your code here
        
        findLargest(arr,k);
      }
      public static void findLargest(int ar[],int n){
          PriorityQueue<Integer> pq = new PriorityQueue<>();
          for(int i=n;i<ar.length;i++){
              if(i<n){
                  pq.add(ar[i]);
              }else{
                  int min = pq.peek();
                  if(min<ar[i]){
                      pq.remove();
                      pq.add(ar[i]);
                  }
              }
            }
          while(pq.size() > 0){
              System.out.println(pq.remove());
          }
      }
}