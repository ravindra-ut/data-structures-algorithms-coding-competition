import java.util.*;

public class IntersectionSortedArrays{

  public int[] intersection(int[] a, int[] b){
    // arrays are assumed to be sorted
    int i = 0, j = 0;
    ArrayList<Integer> result = new ArrayList<Integer>();
    while(i < a.length && j < b.length){
      if(a[i] == b[j]){
        result.add(a[i]);
        // ignore duplicate elements
        while(i < a.length && a[i] == b[j]){
          i++;
        }
        j++;
      } else if(a[i] < b[j]){
        i++;
      } else {
        j++;
      }
    }
    int[] arr = new int[result.size()];
    for(i=0; i < result.size(); i++){
      arr[i] = result.get(i);
    }
    return arr;
  }
}