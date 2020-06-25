import java.io.*;
import java.util.*;

public class hashmap {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    private int findInBucket(int bi,K key){
        // returns index if key exists in the bucket otherwise returns -1
        int di = 0;
        for(HMNode node : buckets[bi]){
            if(node.key.equals(key)){
                // key found --> return index
                return di;
            }
            di++;
        }
        // kkey not found --> -1
        return -1;
        
    }
    private void rehashing() throws Exception{
        LinkedList<HMNode>[] oldBuckets = buckets;
        // create new bucket
        initbuckets(2 * oldBuckets.length);
        size = 0;
        // add nodes from old bucket to new bucket
        for(LinkedList<HMNode> bucket : oldBuckets){
            for(HMNode node : bucket){
                put(node.key,node.value);
            }
        }
    }
    
    private int hashFunction(K key){
        // return bucket index
        int hc = key.hashCode();
        
        // to get it in range
        int bi = Math.abs(hc)%buckets.length;
        return bi;
    }
    public void put(K key, V value) throws Exception {
      // bucket index
      int bi = hashFunction(key);
      // data index
      int di = findInBucket(bi, key);
      // if data is present in the bucket array
      if(di != -1){
          // if key exists ---> then update
          HMNode node = buckets[bi].get(di);
          node.value = value;
      }
      else{
          // if key doesn't exists --> then insert it
          HMNode node = new HMNode(key,value);
          buckets[bi].addLast(node);
          size++;
      }
      
      // lambda -> loading factor
      //  here we have to multiply it with 1.0 to convert it to float
      double lambda = (size * 1.0) / buckets.length;
      // here 2.0 is the threshold value
      // if lambda is greater than threshold value then we have to do rehashing
      if(lambda > 2.0){
          // maintain number of elements per bucket ratio
          // rehashing
          rehashing();
      }
      
    }

    public V get(K key) throws Exception {
      int bi = hashFunction(key);
      int di = findInBucket(bi,key);
      if(di != -1){
          //if key exists then return value
          HMNode node = buckets[bi].get(di);
          return node.value;
      }else{
          // if key doesn't exists then return null
          return null;
      }
    }

    public boolean containsKey(K key) {
      int bi = hashFunction(key);
      int di = findInBucket(bi,key);
      
      if(di != -1){
          // if key exists return true
          return true;
      }
      else{
          // if key doesn't exists return false
          return false;
      }
    }

    public V remove(K key) throws Exception {
      int bi = hashFunction(key);
      int di = findInBucket(bi,key);
       if(di != -1){
           // if key exists then return its value and remove the node
           HMNode node = buckets[bi].remove(di);
           size--;
           return node.value;
       }
       else{
           // if key doesn't exists return null
           return null;
       }
    }

    public ArrayList<K> keyset() throws Exception {
      ArrayList<K> keys = new ArrayList<>();
      for(LinkedList<HMNode> bucket : buckets){
          for(HMNode node : bucket){
              keys.add(node.key);
          }
      }
      return keys;
    }

    public int size() {
      return size;
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