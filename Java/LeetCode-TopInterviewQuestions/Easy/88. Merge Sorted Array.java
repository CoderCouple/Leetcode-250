class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] large=nums1;
        int [] small=nums2;
        int l=m;
        int s=n;
        
        if(nums1==null || nums1.length==0)
            return;
        if(nums2==null || nums2.length==0)
            return;
        
        if(nums1.length>=nums1.length){
            large=nums1;
            l=m-1;
            small=nums2;
            s=n-1;
        } else {
            large=nums2;
            l=n-1;
            small=nums1;
            s=m-1;
        }
        
        int counter=large.length-1;
        while(s>=0 && l>=0){
            if(small[s]>=large[l]){
                large[counter]=small[s];
                s--;
            } else {
                large[counter]=large[l];
                l--;
            }
            counter--;
        }
        
        while(l>=0 && counter>=0){
            large[counter]=large[l];
            l--;
            counter--;
        }
            
        while(s>=0 && counter>=0){
            large[counter]=small[s];
            s--;
            counter--;
        }
        
    }
}
