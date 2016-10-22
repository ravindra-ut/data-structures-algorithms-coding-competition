import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximumSubArraySum {

  public static long kadane(long[] arr, long m){
    TreeSet<Long> S = new TreeSet<>();
    S.add(new Long(0)) ;
    Long ceiling;
    long sum = 0, ans = 0;
    for(int i=0; i<arr.length; i++){
      sum += arr[i] ;
      sum %= m ;
      ceiling = S.ceiling(sum) ;
      if(ceiling != null){
        ans = Math.max(ans, (sum - ceiling + m)%m) ;
      } else {
        ans = Math.max(ans,sum) ;
      }
      S.add(sum) ;
    }
    return ans;
  }
  
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int q = sc.nextInt();
      for(int i=0; i<q; i++){
        
        int n = sc.nextInt();
        long m = sc.nextLong();
        long[] arr = new long[n];
        
        for(int j=0; j < n; j++){
          arr[j] = sc.nextLong();
        }
        
        long maxCont = kadane(arr, m);
        System.out.println(maxCont);
      }
    }
}