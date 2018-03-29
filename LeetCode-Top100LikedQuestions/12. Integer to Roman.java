class Solution {
    public static String intToRoman(int num) {
	        
	        String MDigits []={"","M","MM","MMM"};
	        String CDigits []={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
	        String XDigits []={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
	        String IDigits []={"","I","II","III","IV","V","VI","VII","VIII","IX"};
	        
	        return MDigits[num/1000]+CDigits[(num/100)%10]+XDigits[(num/10)%10]+IDigits[num%10];
	    }
}
