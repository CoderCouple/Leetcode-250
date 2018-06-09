class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
           sb.append(s.charAt(i));
        return sb.toString();
    }
}


====================================Solution 2=======================================
    
    
    class Solution {
    public String reverseString(String s) {
        char [] ch = s.toCharArray();
        for(int i=0,j=ch.length-1;i<(ch.length/2);i++,j--){
            char c = ch[i];
            ch[i]=ch[j];
            ch[j]=c;
        }
        return String.valueOf(ch);
    }
}
