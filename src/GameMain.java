import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;				// Scanner required for player input

public class GameMain {
	private static Scanner scanner = new Scanner(System.in);  // Scanner for input
	
	private Grid grid;					// The game board
	private boolean gameOver;			// Whether game is playing or over
	private Player winner;				// Winner of the game
	private Player currentPlayer;		// Current player (enum)
	private Box row;
	private Box col;
	
 
   /**
    * Constructor
    * Sets up the game. Creates the grid and sets the values of the variables before calling the play method.
    */
   public GameMain() {
	   // Create the grid
	   grid = new Grid();
	   gameOver = false; 
	   currentPlayer = Player.X;
       winner = null;
	   play();
	   
	   /* TODO: Create a new instance of the "Grid"class
	   
	   // Reset the game variables to their defaults

	   // TODO: Assign the default values for currentPlayer (Player.X), gameOver (false), and winner (null)

	   // Begin playing the game
	   
	   // TODO: Call the "play()" method*/
	   

   }
   
   /**
    * Controls the game play, rotates between player turns until a winner is decided.
    */
   public void play() {
	   do {
	         playerMove(currentPlayer);			// Have the player perform their move
	         grid.display();					// Display the current game board
	         checkForWinner(currentPlayer);		// Checks if the game has been won
	         
	         // Display results if game is over
	         if(gameOver) {
	        	 if(winner == Player.X) {
		        	 System.out.println("Player X wins!");
		         } else if(winner == Player.O) {
		        	 System.out.println("Player O wins!");
		         } else {
	        		 System.out.println("Draw!");
	        	 }
	         }
	         
	         // Switch turn to the next player
	         if(currentPlayer == Player.X) {
	        	 currentPlayer = Player.O;
	         } else {
	        	 currentPlayer = Player.X;
	         }
	         
	      } while (!gameOver);  // repeat until game-over
   }
 
   /** 
    * Handles the player making their move, checks if the move is valid before making it.
    */
   public void playerMove(Player turnPlayer) {
	   
      boolean validInput = false;
      
      do {
    	  
    	  // Display instructions to the player

    	  
         if (turnPlayer == Player.X) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
            
        	 // TODO: Inform Player 'O' to enter their move
        	 System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
        	 
         }
         
         // Obtains input from the player for both row and column
         int row = scanner.nextInt();
         int col = scanner.nextInt();
         
         // Decrease the value entered by 1 to compensate for the array index starting at 0
         row--;
         col--;
         
         // Verify the values the player entered are valid (position is valid and empty)
         if (row >= 0 && row < grid.ROWS && col >= 0 && col < grid.COLUMNS && grid.board[row][col].content == Player.EMPTY) {
        	 grid.board[row][col].content = turnPlayer;
        	 grid.currentRow = row;
        	 grid.currentCol = col;
        	 validInput = true;
         } else {
        	 // TODO: Display an error message that the move was not valid.
        	 System.out.println("WARNING: INVALID MOVE, PLEASE TRY AGAIN!");
         }
         
      } while (!validInput);   // Repeat until input is valid
      
      
   }
 
   /**
    * Checks if the game has ended
    */
   public void checkForWinner(Player turnPlayer) {
      if (grid.hasWon(turnPlayer)) {
    	  winner = turnPlayer;
    	  gameOver = true;
    	  // TODO: Set gameOver and winner appropriately
      } else if (grid.isDraw()) {

    	  // TODO: Set gameOver and winner appropriately
    	  winner = Player.EMPTY;
    	  gameOver = true;
      }
   }
 
   /**
    * The main() method
 * @throws IOException 
 * @throws NumberFormatException 
    */
   public static void main(String[] args) throws NumberFormatException, IOException {
	   // TODO: Add a loop to restart the game once it has finished
	   // TODO: Then update the loop to ask the player if they want to play again, exit if they do not
	   new GameMain();
	   // Prompt the user whether to play again
	   
	   
	   do { 
		   System.out.print("Play again? YES (1)  NO(2) ");
		   BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in)); 
	       int key = Integer.parseInt(bufferRead.readLine());
		   System.out.println(key); 
		   if (key == 2) {
		      System.out.println("Terminating the Game!");
		      System.exit(0);  // terminate the program
		   }
		   else if (key == 1) {
		      System.out.println("Please be ready for a new Game!"); 
		      new GameMain();
		   }
		   else {
			 System.out.println("INVALID input, please only choose between YES (1) or  NO(2)");
			 key = Integer.parseInt(bufferRead.readLine());
		   }

		} while (true); 
			
	}  // repeat until user did not answer yes */

 
	      
}
	   
