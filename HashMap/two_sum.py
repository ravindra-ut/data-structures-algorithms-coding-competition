class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        value_to_index = {}
        result = []
        for index, value in enumerate(nums):
            # if duplicate values present store only first
            # two values of indices
            if value in value_to_index:
                if len(value_to_index[value]) < 2:
                    value_to_index[value].append(index)
            else:
                value_to_index[value] = [index]
        
        for value in value_to_index:
            if (target - value) in value_to_index:
                if value == (target - value):
                    result = value_to_index[value]
                else:
                    result = value_to_index[value] + value_to_index[(target-value)]
                break
        return result
