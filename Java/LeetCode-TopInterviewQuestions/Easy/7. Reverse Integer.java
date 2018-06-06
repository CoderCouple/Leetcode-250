class Solution {
    public int reverse(int x) {
        if(x<0)
            return getReverse(-1*x)*-1;
        else
            return getReverse(x);
    }
    
    public int getReverse(int num){
        long number=0;
        int lastDigit=0;
        int remainingDigits=num;
        
        while(remainingDigits>0){
            lastDigit=remainingDigits%10;
            remainingDigits=remainingDigits/10;
            number=number*10+lastDigit;
        }
        
        if(number>Integer.MAX_VALUE || number<Integer.MIN_VALUE)
            return 0;
        else return (int)number;
    }
}
