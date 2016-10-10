import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TextEditor {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      Stack<Character> st = new Stack<Character>();
      Stack<String> undoSt = new Stack<String>();
      for(int i=0; i < n; i++){
        int op = sc.nextInt();
        if(op == 1){
          String word =  sc.next();
          int length = word.length();
          for(int j=0; j < length; j++){
            st.push(new Character(word.charAt(j)));
          }
          // undo of add is delete
          // 2 + length
          undoSt.push("2" + String.valueOf(length));
        } else if(op == 2){
          int length = sc.nextInt();
          StringBuilder str = new StringBuilder(""); 
          for(int j=0; j < length; j++){
            str.append(st.pop());
          }
          // push string to undo stack
          undoSt.push("1" + str.reverse());
        } else if (op == 3) {
          int position = sc.nextInt();
          System.out.println(st.get(position - 1));
        } else{
          String opStr = undoSt.pop();
          if(opStr.charAt(0) == '1'){
            for(int k = 1; k < opStr.length(); k++){
              st.push(opStr.charAt(k));
            }
          } else {
            int length = Integer.parseInt(opStr.substring(1));
            for(int k=0; k < length; k++){
              st.pop();
            }
          }
        }
      }
    }
}