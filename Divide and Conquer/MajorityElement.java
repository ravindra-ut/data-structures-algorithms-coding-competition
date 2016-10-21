public class MajorityElement {
    public int majorityElement(int[] nums) {
        int maj_index = 0, count = 1;
        int i;
        int size = nums.length;
        for (i = 1; i < size; i++) 
        {
            if (nums[maj_index] == nums[i])
                count++;
            else
                count--;
            if (count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        int majorityCandidate = nums[maj_index];
        count = 0;
        int minLength = size/2;
        for(i=0; i<size; i++){
            if(nums[i] == majorityCandidate){
                count++;
                if(count > minLength){
                  break;
                }
            }
        }
        return majorityCandidate;
    }
}