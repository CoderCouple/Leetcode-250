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
