/**
 * The grid represents the game board.
 */
public class Grid {
	// Define the amount of rows and columns
	int ROWS = 3;			// Rows
	int COLUMNS = 3;		// Columns
 
	Box[][] board;								// Represents the game board as a grid
	int currentRow;								// Row that was played last
	int currentCol;								// Column that was played last
 
	/**
	 * Constructor
	 */
   public Grid() {
      
      // TODO: Initialise the board array using ROWS and COLUMNS
	  board = new Box[ROWS][COLUMNS];
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            board[row][col] = new Box(row, col);
         }
      }
   }
 
   public void init() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLUMNS; ++col) {
	            board[row][col].clear();  // clear the board content
	         }
	      }
	   }
   
   /**
    * Checks if the game has ended in a draw
    * One way to do this is to check that there are no empty positions left
    */

   
   public boolean isDraw() {
	   
	   // TODO: Check whether the game has ended in a draw. 
	   // Hint: Use a nested loop (see the constructor for an example). Check whether any of the Boxes in the board grid are Player.Empty. If they are, it is not a draw.
	   // Hint: Return false if it is not a draw, return true if there are not empty positions left
	   for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLUMNS; ++col) {
	            if (board[row][col].content == Player.EMPTY) {
	               return false; // an empty player found, not a draw, exit
	            }
	         }
	      }
	      return true; // no empty cell, it's a draw

   }
 
   /**
    * Return true if the turn player has won after making their move at the coordinate given
    */
  public boolean hasWon(Player player) {

	   
	  return (board[currentRow][0].content == player         // 3-in-the-row
               && board[currentRow][1].content == player
               && board[currentRow][2].content == player
          || board[0][currentCol].content == player      // 3-in-the-column
               && board[1][currentCol].content == player
               && board[2][currentCol].content == player
          || currentRow == currentCol            // 3-in-the-diagonal
               && board[0][0].content == player
               && board[1][1].content == player
               && board[2][2].content == player
          || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
               && board[0][2].content == player
               && board[1][1].content == player
               && board[2][0].content == player);
	   
   }
 
   /**
    * Draws the tic-tac-toe board to the screen
    */
   public void display() {
      for (int row = 0; row < ROWS; ++row) {
    	  for (row = 0; row < ROWS; ++row) {
    	         for (int col = 0; col < COLUMNS; ++col) {
    	            board[row][col].display();   // each cell paints itself
    	            if (col < COLUMNS - 1) System.out.print("|");
    	         }
    	         System.out.println();
    	         if (row < ROWS - 1) {
    	            System.out.println("-----------");
    	         }
    	  }
      }
   }
}