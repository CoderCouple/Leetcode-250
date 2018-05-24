class Solution {
    public int uniquePaths(int m, int n) {
        long result =1;
        for(int i=m+n-2,j=1;i>Math.max(m-1,n-1);i--,j++){
            result = (result*i)/j;
        }
        return (int)result;
    }
}
