import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximumSubArray {

  public static int kadane(int[] arr){
    int maxSoFar = 0, maxToHere = 0;
    int len = arr.length;
    for(int i=0; i < len; i++){
      maxToHere += arr[i];
      if(maxToHere < 0){
        maxToHere = 0;
      }
      if(maxToHere > maxSoFar){
        maxSoFar = maxToHere;
      }
    }
    return maxSoFar;
  }
  
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int q = sc.nextInt();
      for(int i=0; i<q; i++){
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int j=0; j < n; j++){
          arr[j] = sc.nextInt();
        }
        
        int maxCont = kadane(arr);
        int maxNonCont = 0;
        int maximum = Integer.MIN_VALUE;
        
        for(int j=0; j<n; j++){
          if(arr[j] > 0){
            maxNonCont += arr[j];
          }
          if(arr[j] > maximum){
            maximum = arr[j];
          }
        }
        
        if(maxCont == 0){
          maxCont = maximum;
        }
        
        if(maxNonCont == 0){
          maxNonCont = maximum;
        }
        System.out.print(maxCont + " " + maxNonCont + "\n");
      }
    }
}