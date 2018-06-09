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
