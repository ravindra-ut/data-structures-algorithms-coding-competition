public class HouseRobber {
  public int rob(int[] nums) {
    /*
    Dynamic programming
    Bottom-up approach
    Since we cannot rob 2 adjacent houses, generally, we cannot rob house[n] and house [n-1] at the same night
    For house n,
    the maximum amount of money you can rob is either the money you got from first n-1 house,
    OR the money you got from first n-2 house plus the money you can get from house n.
    */
    
    int l = nums.length;
    if (l == 0){
        return 0;
    }

    int[] robbedmoney = new int[l]; //robbedmoney[i] array is used to store the maximum amount of money that can be robbed from the first i houses.
    for (int i = 0; i < l; i ++){
        if (i == 0){
            robbedmoney[i] = nums[i];
        }
        else if (i == 1){
            robbedmoney[i] = Math.max(nums[i], nums[i-1]);
        }
        else{
            robbedmoney[i] = Math.max(robbedmoney[i - 2] + nums[i], robbedmoney[i-1]);
        }
    }
    
    return robbedmoney[l - 1];
  }
}