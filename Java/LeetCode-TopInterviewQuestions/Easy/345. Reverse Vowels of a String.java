class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray())
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' 
               || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                stack.push(c);
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
             if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' 
               || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                sb.replace(i,i+1,Character.toString(stack.pop()));
        }

        return sb.toString();
    }
}



=================================================Solution 2============================================

    
    class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length()==0) return s;
        
        int start=0;
        int end=s.length()-1;
        char [] c = s.toCharArray();
        
        while(start<end){
            while(start<end){
                if(c[start] == 'a' || c[start] == 'e' || c[start] == 'i' || c[start] == 'o' || c[start] == 'u' 
                || c[start] == 'A' || c[start] == 'E' || c[start] == 'I' || c[start] == 'O' || c[start] == 'U'){
                    break;
                }
                start++;
            }
            
            while(start<end){
                if(c[end] == 'a' || c[end] == 'e' || c[end] == 'i' || c[end] == 'o' || c[end] == 'u' 
                || c[end] == 'A' || c[end] == 'E' || c[end] == 'I' || c[end] == 'O' || c[end] == 'U'){
                     break;
                 }
                end--;
            } 
            
            char ch = c[start];
            c[start]=c[end];
            c[end]=ch;
            
            start++;
            end--;
        }
        
        return String.valueOf(c);
    }
}
