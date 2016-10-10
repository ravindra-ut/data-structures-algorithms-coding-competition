import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalaceBrackets {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      for(int i=0; i<n; i++){
        String word = sc.next();
        Stack<Character> stack = new Stack<Character>();
        boolean balance = true;
        for(int j=0; j < word.length(); j++){
          char c = word.charAt(j);
          if(c == '[' || c == '(' || c == '{'){
            stack.push(new Character(c));
          }else{
            if(stack.isEmpty()){
              balance = false;
              break;
            } else {
              char o = (char) stack.pop();
              // check paranethis match
              if((c == ']' && o == '[') || (c == ')' && o == '(') || (c == '}' && o == '{')){
                continue;
              } else {
                balance = false;
                break;
              }
            }
          }
        }
        if(!stack.isEmpty() || balance == false){
          System.out.println("NO");
        } else {
          System.out.println("YES");
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