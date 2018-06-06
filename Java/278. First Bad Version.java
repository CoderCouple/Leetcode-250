package Test;

public class FirstBadPosition {
	    public static  int firstBadVersion(int n) {
	        int start = 0;
	        int end = n;
	        
	        while (end-start>1){
	            int mid = start + (end -start)/2;
	            
	            if(!isBadVersion(mid))
	                start = mid;
	            else end =mid;
	        }
	        
	            return end;
	    }
	

	    public static boolean isBadVersion(int n){
	    	return true;
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
