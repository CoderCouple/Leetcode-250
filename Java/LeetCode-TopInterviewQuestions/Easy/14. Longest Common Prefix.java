class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String result="";
        int shortestString=Integer.MAX_VALUE;
        
        if(strs.length==0)
            return result;
        
        for(String str : strs)
            if(str.length()<shortestString)
                shortestString=str.length();
        
        if(shortestString==0)
            return result;
        
        for(int i=0;i<shortestString;i++){
            for(int j=1;j<strs.length;j++){
                if(strs[0].charAt(i)!=strs[j].charAt(i))
                    return result;
            }
            result=result+strs[0].charAt(i);
        }
        return result;
    }
}
