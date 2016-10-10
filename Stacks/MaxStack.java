import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxStack {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      Stack stack = new Stack();
      Stack maxStack = new Stack();
      for(int i=0; i<n; i++){
        int op = sc.nextInt();
        if(op == 1){
          // push to stack
          int value = sc.nextInt();
          stack.push((int)value);
          if(!maxStack.isEmpty()){
            int maxValue = (int) maxStack.peek();
            if(maxValue <= value){
              maxStack.push((int)value);
            }
          } else {
            // if its empty push the first element
            maxStack.push((int) value);
          }
        } else if(op == 2){
          // pop from stack
          if(!stack.isEmpty()){
            int value = (int) stack.pop();
            int maxValue = (int) maxStack.peek();
            if(maxValue == value){
              maxStack.pop();
            }
          }
        } else {
          // return maximum element from stack
          System.out.println(maxStack.peek());
        }
      }
    }
}

/*
10
1 97
2
1 20
2
1 26
1 20
2
3
1 91
3
*/