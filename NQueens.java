//backtracking: undo what we did

//0 and 1— 1 is for where queen is taken on a square

//Recursive function— requires base case

public class NQueens {
	int n;
	int[][] board;
	int row, col;

	public NQueens(int n) {
		this.n = n;
		board = new int[n][n];
	}

	public void printToConsole(int[][] board, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 1) {
					System.out.println(" Q ");
				}
				else {
					System.out.println(" __ ");
				}
				System.out.println();
			}
		}
	}

	boolean placeNQueens() throws Exception 
	{
		if(n<4 && n>1) {
			throw new Exception("n can't be smaller than 4!");
		}

		if(n<1) {
			throw new Exception("n can't be 1!");
		}

		return placeNQueens(0);
	}

	boolean placeNQueens(int row) throws Exception {
		//Base case
		if(row == n)
			return true;

		for(int col = 0; col < n; col++)  { //it is n because n is number of col and rows
			if(canPlaceAQueen(row, col)) {
				board[row][col] = 1;
				if(placeNQueens(row+1))
					return true;
				else
					board[row][col] = 0; //1 to 0 because queen not at the square anymore: backtracking
			}
		}
		return false;
	}

	boolean canPlaceAQueen(int row, int col) {
		//Check if no queen can be placed in the row
		for(int i = 0; i < col; i++) {
			if(board[row][i] == 1)
				return false;
		}

		//Check if no queen can be placed in the column
		for(int i = 0; i < row; i++) {
			if(board[i][col] == 1)
				return false;
		}

		//Diagonal (upper, right bottom)
		for(int i = row; i>=0; i--) {
			for(int j = col; j>=0; j--) {
				if(board[i][j] == 1)
					return false;
			}
		}
		
		//Diagonal(Upper, right top)
		for(int i = row; i<n; i++) {
			for(int j = col; j >=0;j--) {
				if(board[i][j] == 1)
					return false;
			}
		}
		return true;
	}
}