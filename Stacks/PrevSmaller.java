import java.util.*;

public class PrevSmaller {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        Deque<Integer> stack = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(Integer num: arr){
          // approach is to maintain max stack
          while(!stack.isEmpty()){
            // look at the top of the stack
            Integer top = stack.peek();
            // if top is smaller then we have found nearest element
            if(top < num){
              result.add(top);
              stack.push(num);
              break;
            } else {
            // otherwise pop
              stack.pop();
            }
          }
          // if all elements were greater than current element
          // stack will be empty so add -1 and push current element
          if(stack.isEmpty()){
            result.add(-1);
            stack.push(num);
          }
        }
        return result;
    }
}