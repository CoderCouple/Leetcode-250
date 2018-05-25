class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currList = new ArrayList<Integer>();
        if(nums.length==0)
            return result;
        else {
            getSet(nums,0,result,currList);
        }
       return result;
    }
    
    public void getSet(int nums [], int index ,  List<List<Integer>> result,  List<Integer> currList){
        if(index==nums.length){
            result.add(currList);  
            return;
        }
        
        List<Integer> newList = new ArrayList<Integer>();
        newList.addAll(currList);
        newList.add(nums[index]);
        getSet(nums,index+1,result,currList);
        getSet(nums,index+1,result,newList);
        return;
    }
}
