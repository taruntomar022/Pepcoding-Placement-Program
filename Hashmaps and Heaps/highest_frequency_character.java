import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int idx = 0;idx < str.length();idx++){
            char ch = str.charAt(idx);
            if(hm.containsKey(ch)){
                int val = hm.get(ch);
                hm.put(ch, val+1);
            }else{
                hm.put(ch,1);
            }
        }
        int maxf = Integer.MIN_VALUE;
        char maxfc = ' ';
        for(Character key : hm.keySet()){
            if(hm.get(key) > maxf){
                maxf = hm.get(key);
                maxfc = key;
            }
        }
        System.out.println(maxfc);
    }

}