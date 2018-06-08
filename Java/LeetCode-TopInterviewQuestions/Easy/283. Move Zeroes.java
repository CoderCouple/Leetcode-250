class Solution {
    public void moveZeroes(int[] nums) {
        int first=-1;
        int second=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                first=i;
                break;
            } 
        }
        
        if(first<0)
            return; 
        
        for(int i=first;i<nums.length;i++){
            if(nums[i]!=0){
                second=i;
                break;
            } 
        }
        
        if(second==nums.length)
            return;
        
        for(int i=second;i<nums.length;i++){
            if(nums[i]!=0){
                nums[first]=nums[i];
                first++;
            }
        }
        
        for(int i=first;i<nums.length;i++)
            nums[i]=0;
            
    }
}
