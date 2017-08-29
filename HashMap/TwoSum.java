class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> valueToIndex = new HashMap<>();
    for(int i=0; i < nums.length; i++){
      int remainder = target - nums[i];
      if(valueToIndex.containsKey(remainder)){
        int [] result = {valueToIndex.get(remainder), i};
        return result;
      }
      valueToIndex.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum found");
  }
}
