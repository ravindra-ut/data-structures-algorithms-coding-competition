import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestRectangle {
     
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      // store index of maximum values
      int[] stack = new int[n];
      int[] hist = new int[n];
      int top = -1;
      int largest_area = 0;
      int current_area = 0;
      int topBarIndex;
      for(int i=0;i<n;i++){
        hist[i] = sc.nextInt();
      }
      int i = 0;
      while(i<n){
        // stack is empty or next bar is equal or greater
        if(top == -1 || hist[stack[top]] <= hist[i]){
          top = top + 1;
          stack[top] = i;
          i = i + 1;
        } else {
          // remove maximum eelment
          // same time calculate area and update largest
          topBarIndex = stack[top];
          top = top - 1;
          // when stack is empty, this was lowest element upto we saw now
          // so width is simply i
          // otherwise pull previous top index and subtract it with and 1.
          if(top == -1) {
            current_area = hist[topBarIndex] * i;
          }else{
            current_area = hist[topBarIndex] * (i - stack[top] - 1);
          }
          if(current_area > largest_area){
            largest_area = current_area;
          }
        }
      }

      while(top != -1){
        topBarIndex = stack[top];
        top = top - 1;
        if(top == -1) {
          current_area = hist[topBarIndex] * n;
        }else{
          current_area = hist[topBarIndex] * (n - stack[top] - 1);
        }
        if(current_area > largest_area){
          largest_area = current_area;
        }
      }
      System.out.println(largest_area);
    }
}