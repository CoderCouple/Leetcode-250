package Test;

public class BestTimeToBuyAndSellStock_121 {

	 public static int maxProfit(int[] prices) {
	        int max=0;int i=0;
	        
	        for(int j=1; j<prices.length; j++){
	            int curr_max = prices[j] - prices[i];
	            max = Math.max(max,curr_max);
	            if(curr_max <0)
	                i=j;
	        }
	        return max;
	    }
	
	public static void main(String[] args) {
		int array []= {7,1,5,3,6,4};
		System.out.println("Max Profit : "+maxProfit(array));
	}

}
