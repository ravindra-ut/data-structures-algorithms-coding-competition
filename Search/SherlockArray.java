import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockArray {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int tests = sc.nextInt();
      while(tests > 0){
        tests--;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i ++){
          arr[i] = sc.nextInt();
        }
        int i = 0, j = n - 1;
        long sum = 0;
        while(i!=j){
          if(sum<=0){
            sum = sum + arr[i];
            i++;
          } else {
            sum = sum - arr[j];
            j--;
          }
        }
        if(sum == 0){
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
    }
}