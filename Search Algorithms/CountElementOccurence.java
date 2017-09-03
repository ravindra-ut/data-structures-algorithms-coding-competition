import java.util.*;

public class CountElementOccurence {
 // DO NOT MODIFY THE LIST
 public int binarySearch(final List<Integer> a, int b, boolean searchFirst){
     int low = 0, high = a.size() - 1, result = -1;
     while(low<=high){
         int mid = low + (high - low)/2;
         int midElement = a.get(mid);
         if(midElement == b){
             // we found element
             result = mid;
             if(searchFirst){
                 high = mid - 1;
             } else {
                 low = mid + 1;
             }
         } else if (midElement < b) {
             low = mid + 1;
         } else {
             high = mid - 1;
         }
     }
     return result;
 }
 public int findCount(final List<Integer> a, int b) {
     int firstIndex = binarySearch(a, b, true);
     if(firstIndex == -1){
         return 0;
     }
     int lastIndex = binarySearch(a, b, false);
     return lastIndex - firstIndex + 1;
 }
}