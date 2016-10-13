import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestRectangle {

     public static int pop(){
       
    }
     
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
        // stack is empty or next bar is equal or greater
        if(top == -1 || hist[stack[top]] <= hist[i]){
          top = top + 1;
          stack[top] = i;
        } else {
          // remove all maximum elments
          // same time calculate area and update largest
          while(top == -1 || stack[top] > hist[i]){
            topBarIndex = stack[top];
            top = top - 1;
            current_area = hist[topBarIndex] * (i - topBarIndex);
            if(current_area > largest_area){
              largest_area = current_area;
            }
          }
          if(top != -1 && stack[top] == hist[i]){
            continue;
          } else {
            top =  top + 1;
            stack[top] = i;
          }
        }
      }

      while(top != -1){
        topBarIndex = stack[top];
        top = top - 1;
        current_area = hist[topBarIndex] * (n - topBarIndex);
        if(current_area > largest_area){
           largest_area = current_area;
        }
      }
      System.out.println(largest_area);
    }
}