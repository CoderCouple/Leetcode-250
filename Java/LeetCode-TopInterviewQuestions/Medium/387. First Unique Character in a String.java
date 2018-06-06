class Solution {
    public int firstUniqChar(String s) {
        //ASCII code for A=65 and a=97
        
        int firstOccrence=0, secondOccrence = 0;
        for(char c : s.toCharArray()){
            if(getBit(c-'a',firstOccrence)){
               secondOccrence = setBit(c-'a',secondOccrence);
            } else {
                firstOccrence = setBit(c-'a',firstOccrence);
            }
        }
        
        //System.out.println(Integer.toBinaryString(secondOccrence));
        for(int i=0; i<s.length();i++){
            if(!getBit(s.charAt(i) - 'a',secondOccrence))
                return i;
        }
        
        return -1;
    }
    
    public boolean getBit(int index, int number){
        return (number & (1 << index)) != 0;
    }
    
    public int setBit(int index, int number){
        return number |= (1 << index); 
    }
}
