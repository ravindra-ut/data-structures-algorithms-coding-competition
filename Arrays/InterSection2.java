import java.util.*;

public class InterSection2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
          int key = nums1[i];
          Integer value = map.get(key);
          if(value == null){
            map.put(key, 1);
          } else {
            map.put(key, value + 1);
          }
        }
        Vector<Integer> result = new Vector<>();
        for (int i = 0; i < nums2.length; i++) {
          int key = nums2[i];
          Integer value = map.get(key);
          if (value != null && value != 0) {
            result.add(key);
            map.put(key, value - 1);
          }
        }
        int[] result2 = new int[result.size()];
        int k = 0;
        for(Integer i: result){
            result2[k++] = i;
        }
        return result2;
    }
}