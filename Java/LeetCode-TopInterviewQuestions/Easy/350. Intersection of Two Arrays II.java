class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if(nums1.length==0 || nums2.length==0)
            return new int [0];
        
        int [] small = nums1.length <= nums2.length ? nums1 : nums2;
        int [] large = nums1.length > nums2.length ? nums1 : nums2;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int index=0;
        
        for(int element : large)
                map.put(element,map.getOrDefault(element,0)+1);
        
        for(int element : small)
            if(map.containsKey(element)){
                result.add(element);
                map.put(element,map.get(element)-1);
                if(map.get(element)==0)
                    map.remove(element);
            }
                

        int [] res = new int [result.size()];
        for (int item : result){
            res[index]=item;
            index++;
        }
        return res;
    }
}
