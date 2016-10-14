import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SockPairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(int c_i=0; c_i < n; c_i++){
            int key = in.nextInt();
            Integer count = (Integer) hmap.get(key);
            if(count == null){
              hmap.put(key, 1);
            } else {
              hmap.put(key, count + 1);
            }
        }
        int result = 0;
        for(int key: hmap.keySet()){
          result = result + hmap.get(key)/2;
        }
        System.out.println(result);
    }
}