class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int element : nums){
            if(set.contains(element))
                set.remove(element);
            else set.add(element);
        }
        return set.iterator().next();
    }
}

=============================================Solution 2===========================================
