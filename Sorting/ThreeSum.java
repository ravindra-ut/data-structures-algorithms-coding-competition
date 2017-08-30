import java.util.*;

class ThreeSum {
  
    public List<List<Integer>> threeSum(int[] a) {
        // sort the arrays
        Arrays.sort(a);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0; i + 2 < a.length; i++){
            // if elements are greater then zero just break
            if(a[i] > 0) {
                break;
            }
            // if previous elements are same continue
            if(i > 0 && a[i] == a[i-1]){
                continue;
            }
            // now do standard two sum problem
            int target = 0 - a[i];
            int low = i + 1, high = a.length - 1;
            while(low < high){
                if(a[low] + a[high] == target){
                    res.add(Arrays.asList(a[i], a[low], a[high]));
                    while(low < high && a[low] == a[low+1]) low++;
                    while(low < high && a[high] == a[high-1]) high--;
                    low++;
                    high--;
                } else if(a[low] + a[high] < target){
                    while(low < high && a[low] == a[low+1]) low++;
                    low++;
                } else {
                    while(low < high && a[high] == a[high-1]) high--;
                    high--;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args){
      ThreeSum t = new ThreeSum();
      int [] array = {-1,0,1,2,-1,-4};
      System.out.println(t.threeSum(array));
    }
    
}