import java.util.*;

public class RedundantBraces {

    public static void main(String[] Args)
    {
        Scanner sc= new Scanner(System.in);
        String str=sc.next();
        System.out.println(braces(str));
    }
    
    public static int braces(String str) {
        int N = str.length();
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < N; ++i) {
            if(str.charAt(i) == ')') {
                int cnt = 0;
                while(stack.peek() != '(') {
                  stack.pop();
                  cnt++;
                }
                stack.pop();
                if(cnt < 2)
                  return 1;
            }
            else {
                stack.push(str.charAt(i));
            }
        }
     
        boolean is = true;
        // checking for extra paranthese
        // invalid expression
        while(stack.size()>0) {    
            if(stack.peek() == '(' || stack.peek() == ')') {
              is = false;
              break;
            }
            stack.pop();
        }

        if(!is)
        {
          return 1;
        }
        return 0;
    }
}