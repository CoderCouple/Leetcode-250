class Solution(object):
    def twoSum(self, nums, target):
        dict = {};
        
        for i in range(len(nums)):
            dict[nums[i]]= i
            
        #print(dict)
        for i in range(len(nums)):
            if (target - nums[i]) in dict.keys() and dict[target-nums[i]]!=i:
                return [i,dict[target-nums[i]]]
