import java.io.*;
import java.util.*;
public class Main{
    public static class HashMap<K, V>{
        private class HMNode{
            K key;
            V value;
            HMNode(K key,V value){
                this.key = key;
                this.value = value;
            }
        }
        
        private LinkedList<HMNode>[] buckets;
        private int size;
        
        public void initBuckets(int cap){
            buckets = new LinkedList[cap];
            for(int i=0;i<cap;i++){
                buckets[i] = new LinkedList<>();
            }
        }
        
        public HashMap(){
            initBuckets(4);
            size = 0;
        }
        
        // to generate bucket index
        public int hashFunction(K key){
            int hc = key.hashCode();
            // to make it in range
            int bi = Math.abs(hc)%buckets.length;
            return bi;
        }
        
        // find tthe data index of value in bucket
        public int findInBucket(int bi, K key){
            int di = 0;
            for(HMNode node : buckets[bi]){
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;
        }
        
        // rehashing
        public void rehashing(){
            // store the old bucket in an array
            LinkedList<HMNode>[] oldBuckets = buckets;
            // create a new bucket of size double than the old bucket
            initBuckets(2 * oldBuckets.length);
            size = 0;
            // store the value of oldbucket in the new bucket
            for(LinkedList<HMNode> bucket : oldBuckets){
                for(HMNode node : bucket){
                    put(node.key, node.value);
                }
            }
        }
        
        // put
        public void put(K key, V value){
            // bucket index
            int bi = hashFunction(key);
            // data index
            int di = findInBucket(bi, key);
            // if key exists
            if(di != -1){
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }else{
                HMNode node = new HMNode(key, value);
                buckets[bi].addLast(node);
                size++;
            }
            
            double lambda = (size*1.0)/buckets.length;
            if(lambda > 2.0){
                rehashing();
            }
            
        }
        // get
        public V get(K key){
            int bi = hashFunction(key);
            int di = findInBucket(bi, key);
            if(di != -1){
                HMNode node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }
        
        // containsKey
        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = findInBucket(bi, key);
            if(di != -1){
                return true;
            }else{
                return false;
            }
        }
        
        // ketSet
        public ArrayList<K> keyset(){
            ArrayList<K> keys = new ArrayList<>();
            for(LinkedList<HMNode> bucket : buckets){
                for(HMNode node : bucket){
                    keys.add(node.key);
                }
            }
            
            return keys;
        }
        
        // size
        public int size(){
            return size;
        }
        
        // remove
        public V remove(K key){
            int bi = hashFunction(key);
            int di = findInBucket(bi, key);
            if(di != -1){
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }else{
                return null;
            }
        }
        public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print(node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
    }
    }
    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
    
}