class Solution {
    public int numIslands(char[][] grid) {
        int result=0;
         if(grid.length ==0)
            return result;
        
        int gridTracker [][] = new int[grid.length][grid[0].length];
        for(int row=0; row<grid.length;row++)
            for(int col=0; col<grid[row].length;col++){
                if(gridTracker[row][col]!=-1 && grid[row][col]=='1'){
                     result++;
                     isIsland(grid, row, col, gridTracker);
                }    
            } 
        return result;
    }
    
    public void isIsland(char[][] grid, int row, int col, int[][] gridTracker) {
        if(row<0 || row >=grid.length || col<0 || col>=grid[row].length)
            return;
        
        if(grid[row][col]=='0')
            return;
        
        if(gridTracker[row][col]==-1)
            return;
        
        gridTracker[row][col]=-1;
        for(int i= -1; i<=1; i++)
            for(int j= -1; j<=1; j++){
                if(Math.abs(i)+Math.abs(j)!=1)
                    continue;
                isIsland(grid, row+i, col+j, gridTracker);
            }
    }
}
