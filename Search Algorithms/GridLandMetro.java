// merging intervals
// sort the intervals in the increasing order of start time
// push the earliest start time and end time pair to stack
// for each item in intervals
//   check interval start time > top of stack end time. push this item to stack eg: 1,4 6,9
//   check interval end time < top of stack end time. do nothing e.g 1,4  2,3 = 1, 4
//   check interval start time < top of stack end time and end time > top of stack end time merge it 1,4 2, 6 = 1, 6

//4 4 3
//2 2 3
//3 1 4
//4 4 4

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GridLandMetro {
  class LongPair{
    long x;
    long y;
    public LongPair(long x, long y){
      this.x = x;
      this.y = y;
    }
  }
  
  public void solve(){
    Scanner sc = new Scanner(System.in);
    long n = sc.nextInt();
    long m = sc.nextInt();
    long k = sc.nextInt();
    HashMap<Long, LinkedList> hmap = new HashMap<Long, LinkedList>();
    for(int i=0; i < k; i++){
      long r = sc.nextInt();
      long c1 = sc.nextInt();
      long c2 = sc.nextInt();
      @SuppressWarnings("unchecked")
      LinkedList<LongPair> l = hmap.get(r);
      if(l == null){
        l = new LinkedList<LongPair>();
        hmap.put(r, (LinkedList<LongPair>)l);
      }
      l.addFirst(new LongPair(c1, c2));
    }
    long totalTrackLen = 0;
    for(long key: hmap.keySet()){
      @SuppressWarnings("unchecked")
      LinkedList<LongPair> l = (LinkedList<LongPair>) hmap.get(key);
      
      l.sort( new Comparator<LongPair>(){
        @Override
        public int compare(LongPair p1,LongPair p2){
          if(p1.x > p2.x){
            return 1;
          } else if(p1.x == p2.x){
            return 0;
          } else {
            return -1;
          }
        }
      });
      long start, end;
      LongPair lp =l.getFirst();
      start = lp.x;
      end = lp.y;
      long rowLen = 0;
      for(LongPair it: l){
        // new interval started
        if(it.x > end){
          rowLen = rowLen + (end - start) + 1;
          start = it.x;
          end = it.y;
        } else if(it.x <= end && it.y >= end){
          end = it.y; // merge intervals   
        }
      }
      rowLen = rowLen + (end - start) + 1;
      totalTrackLen += rowLen;
      //System.out.printf("%d %d %d\n", key, rowLen, totalTrackLen);
    }
    long result = n * m - totalTrackLen;
    System.out.println(result);
  }
  
  public static void main(String[] args) {
    GridLandMetro gd = new GridLandMetro();
    gd.solve();
  }
}