class Solution {
    public void solve(char[][] board) {
        if(board.length==0)
            return;
        
        int row=0;int col=0;
        for(; col<board[row].length;col++)
        {
            if(board[row][col]=='O')
                captureIslands( board,row,col);
        }
        col--;
        for(; row<board.length;row++)
        {
            if(board[row][col]=='O')
                captureIslands( board,row,col);
        }
        row--;
        for(; col>=0;col--)
        {
            if(board[row][col]=='O')
                captureIslands( board,row,col);
            
        }
        col++;
        for(; row>=0;row--)
        {
            if(board[row][col]=='O')
                captureIslands( board,row,col);
        }
        
        for(int r =0; r<board.length;r++)
        {  for(int c=0; c<board[r].length;c++) 
           {
             
              if(board[r][c]=='O')
                  board[r][c]='X';
                  
              if(board[r][c]=='Y')
                  board[r][c]='O';
           }
        }
               
        
           
    }
    
    public void captureIslands(char[][] board,int row,int col){

         System.out.println("row: "+row +", col: "+ col);
         if(row<0 || row>=board.length || col<0 || col>=board[row].length || board[row][col]!='O')
             return;
  
        board[row][col] = 'Y';   
        for(int i=-1;i<=+1;i++){
            for(int j=-1;j<=+1;j++){
                if(Math.abs(i)+Math.abs(j)!=1)
                    continue;
               captureIslands(board,row+i,col+j);
            }
                   
            }
        }
    }
