class Solution {
    public void setZeroes(int[][] matrix) {
        boolean c = true; 
        boolean r = true;
        for(int row=0; row<matrix.length; row++)
        {      if(matrix[row][0]==0)
                        c=false;
        }
          
        for(int col=0; col<matrix[0].length;  col++)
        {
                if(matrix[0][col]==0)
                        r=false;
        } 
        
            for(int row=1; row<matrix.length; row++)
            for(int col=1; col<matrix[row].length; col++){
                if(matrix[row][col]==0)
                {
                               
                    matrix[row][0]=0;
                    matrix[0][col]=0;
                }
            }
        
        for(int row=matrix.length-1; row>=0; row--)
            for(int col=matrix[row].length-1; col>=0; col--){
                if(matrix[row][0]==0 || matrix[0][col]==0)    
                    matrix[row][col]=0;
                }
        
        System.out.println("r: " + r);
         System.out.println("c: " + c);
        if(!c)
        {
            for(int i = 0; i < matrix.length; i++)
                matrix[i][0]=0;
        }
        if(!r)
        {
            for(int j =0; j<matrix[0].length;j++)
                matrix[0][j]=0;
        }
    }
}
