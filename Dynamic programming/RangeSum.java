// Range sum via dynamic programming
public class RangeSum {
    int[] sums;
    
    public RangeSum(int[] nums) {
        int length = nums.length;
        sums = new int[length+1];
        sums[0] = 0;
        for(int i=1; i <= length; i++){
          sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}