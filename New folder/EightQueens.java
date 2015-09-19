/*eight queens
you have an 8x8 chess board
how many ways are there to have 8 queens on the board such that none of them are in a position to eat another queen?
*/
import java.util.*;
public class eightqueens{
	public static int successCounter = 0;//keeping track of the number of successes
	public static void main(String[] args) {
		for (int i = 0; i<8; i++)		
		successcounter(i);					
			
			System.out.println(successCounter);
	}
	public static int successcounter(int k){
		int [][] board = new int [8][8];
		runner(board, 0, k);
		return successCounter;
	}
	public static void runner(int [][] board, int row, int column){
		makeQueen(board, row, column);
		//keeping track of queens

		//cloning an array to make a "status"
		for(int i = row;i<8;i++)
		{
			for(int j = 0;j<8;j++)
			{
				int[][] status = cloneArray(board);
				if(status[i][j] == 0)
				{
					runner(status,i,j);
				}
			}
		}
		
		/*int queenCounter = 0;
		for (int i = row;i<8;i++)
		{
			for (int j = column;j<8;j++)
			{
				if (board[i][j] == 2)
				{
					queenCounter++;
				}
			}
		}
		//if number of queens reaches 8, add to the success counter 
		if (queenCounter == 8)
		{
			successCounter++;
		}*/
	}

	public static void makeQueen(int [][] board, int row, int column){
		//check a square to see if you can put a queen there by checking if it is '0', and 
		//if the square fits, then put a queen there by marking the square as '2'
		//if (board [row][column] == 0) //if the square is '0', make a queen
		//{
		
		//if number of queens reaches 8, add to the success counter 
		
			board [row][column] = 2; //marking square as a queen
			blockCells(board, row, column); //marking the squares that can't have queens on them using blockCells
		//}
		//row++;
		//column++;
		//blockCells(board, row, column);
			int queenCounter = 0;
			for (int i = 0;i<8;i++)
			{
				for (int j = 0;j<8;j++)
				{
					if (board[i][j] == 2)
					{
						queenCounter++;
					}
				}
			}
			if (queenCounter == 8)
			{
				successCounter++;
			}
			for (int[] arr : board) {
				//System.out.println("Second cut:");
				System.out.println(Arrays.toString(arr));
				
			}
	}
 
	public static void blockCells(int [][] board, int row, int column){
		//once you put a queen, mark all the other spaces as '1' to show that it's taken
		for (int k=0; k<8; k++) //rows+columns
		{
			//if (k != row && k != column) 
			{
				board [row][k] = 1;
				board [k][column] = 1;			
			}
		}
		for (int m=1; m<(8-row)&&m<(8-column); m++) //diagonal
		{
			board [row+m][column+m] = 1;
		}
		for (int m=1; m<=row&&m<=column; m++) //diagonal again
		{
			board [row-m][column-m] = 1;
		}
		for (int m=1; m<(8-row)&&m<=column; m++) //diagonal again
		{
			board [row+m][column-m] = 1;
		}
		for (int m=1; m<=row&&m<(8-column); m++) //diagonal yet again
		{
			board [row-m][column+m] = 1;
		}
			board [row][column] = 2;
	}

	public static int[][] cloneArray(int[][] array) {
	    int[][] clone = new int[8][8];
	    for (int i = 0; i < 8; i++) 
	    {
	        System.arraycopy(array[i], 0, clone[i], 0, 8);
	    }
	    return clone;
	}
}