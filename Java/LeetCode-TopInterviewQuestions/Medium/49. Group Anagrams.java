class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        
        for(String str : strs){
            List<String> list;
            String key= getSortedString(str);
            if(map.containsKey(key))
                list=map.get(key);
            else{
                list = new ArrayList<String>();
                result.add(list);
            }
            list.add(str);
            map.put(key,list);
        }
        return result;
    }
    
    public String getSortedString(String str){
        char [] acharArray = str.toCharArray();
        Arrays.sort(acharArray);
        return String.valueOf(acharArray);
    }
}
