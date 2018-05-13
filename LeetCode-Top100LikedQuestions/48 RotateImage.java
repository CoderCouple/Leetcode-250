package Test;

public class RotateImage_48 {

	public static void rotate(int[][] matrix) {
		int n = matrix.length;

		for (int r = 0; r < (n / 2); r++) {

			int i = 0 + r;
			int j = 0 + r;
			int k = n - 1 - r;
			int l = n - 1 - r;

			while (j < n - 1 - r) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[k][i];
				matrix[k][i] = matrix[l][k];
				matrix[l][k] = matrix[j][l];
				matrix[j][l] = temp;

				j++;
				k--;
			}
		}
	}
	
	public static void printMatrix(int [][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				System.out.print(matrix[i][j]+" ");
			}
		System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrix(matrix);
		rotate(matrix);
		printMatrix(matrix);
	}

}
