class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0)
            return 0;
        int gridTracker [][] = new int [grid.length][grid[0].length];
        return getMinPath(grid ,0 ,0 ,0, gridTracker);
    }
    
    public int getMinPath(int [][] grid , int row, int col, int curr_sum, int [][] gridTracker){
        if(row<0 || row >=grid.length || col<0 || col >=grid[row].length)
            return Integer.MAX_VALUE;
        
        if(gridTracker[row][col]==-1)
            return Integer.MAX_VALUE;
        
        curr_sum += grid[row][col];
        
        if(row == grid.length-1 && col==grid[row].length-1)
            return curr_sum;
        
        gridTracker[row][col]=-1;
        
        int right =getMinPath(grid ,row ,col+1 ,curr_sum, gridTracker);
        int down = getMinPath(grid ,row+1 ,col ,curr_sum, gridTracker);

        gridTracker[row][col]=0;
        return Math.min(right,down);
    }
}


=============================================Solution 2==============================================
    
//This solution is not created by me.
//I took reference from folloing web source.
//http://buttercola.blogspot.com/2014/09/leetcode-minimum-path-sum.html


public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
         
        int m = grid.length;
        int n = grid[0].length;
         
        int[][] dp = new int[m][n];
         
        dp[0][0] = grid[0][0];;
         
        // update the first row
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
         
        // update the first column
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
         
        //use the previously calculated values
        //select the minimum cost to reach a perticular path.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
         
        return dp[m - 1][n - 1];
    }
}

=============================================Solution 3==============================================
    
//This solution is not created by me.
//I took reference from folloing web source.
//http://buttercola.blogspot.com/2014/09/leetcode-minimum-path-sum.html
    
    public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
         
        int m = grid.length;
        int n = grid[0].length;
         
        int[] dp = new int[n];
        dp[0] = grid[0][0];
         
        // set the first row
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
         
        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
         
        return dp[n - 1];
    }
}

