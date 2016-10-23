/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
// or problem can be thought as 0, 0, 0, 1 ,1 , 1
// we have sequence of 0's followed by 1.
// find the first '1' in array.
// just do modified version of binary search

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while(low != high){
            int mid = low + (high - low)/2;
            if(isBadVersion(mid)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}