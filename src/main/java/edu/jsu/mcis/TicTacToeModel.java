package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        /* INSERT YOUR CODE HERE */
		
		Mark [width][width] grid;

        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */
        for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
				gred[i][j] = EMPTY;
			}
		}
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        /* INSERT YOUR CODE HERE */
		if(isValidSquare && !isSquareMarked){ //Using these built in functions to determine if the square is occupied and a valid square
			if(xTurn){
				grid[row][col] = X;
			}
			else{
				grid[row][col] = O;
			}
		}
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */
		if(row < width && col < width && row >= 0 && col >=0){
			return true;
		}
		else{
			return false;
		}
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE */
		if(grid[row][col] == EMPTY){
			return false;
		}
		else{
			return true;
		}
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */
		return grid[row][col]
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
		if(isMarkWin(X)){
			return X;
		}
		else if(isMarkWin(O)){
			return O;
		}
		else if(isTie()){
			return TIE
		}
		else{
			return NONE;
		}
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
		//Loop through the grid checking for marks of the specified type.
		for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
				
				//CHECK IF THE MARK MATCHES
				if(getMark(i,j) == mark){//The mark is the one we're checking for
				
					//CHECKING ABOVE
					if(i - 1 >= 0){//There actually is an above
						if(getMark(i-1,j) == mark){//The one above is the one we're checking for
							if(row - 2 >= 0){// There is an above above
								if(getMark(i-2,j) == mark){
									return true;
								}
							}
							else if(row + 1 <= width){//There is a below
								if(getMark(i+1,j) == mark){
									return true;
								}
							}
						}
					}
					//CHECKING BELOW
					if(i + 1 <= width){//There actually is a below
						if(getMark(i+1,j) == mark){//The one below is the one we're checking for
							if(row + 2 <= width){//There is a way below
								if(getMark(i+2,j) == mark){
									return true;
								}
							}
						}
					}
					//CHECKING LEFT
					if(j - 1 >= 0){//There is a left
						if(getMark(i,j-1) == mark){//The mark to the left matches
							if(j - 2 >= 0){//There is a left left
								if(getMark(i,j-2) == mark){//The mark to the left left matches
									return true;
								}
							}
							else if(j + 1 <= width){//There is a right
								if(getMark(i,j+1) == mark){//The mark to the right matches
									return true;
								}
							}
						}
					}
					//CHECKING RIGHT
					if(j + 1 <= width){//There is a right
						if(getMark(i,j+1) == mark){//The mark to the right matches
							if(j + 2 <= width){//There is a right right
								if(getMark(i,j+2) == mark){//The mark to the right right matches
									return true;
								}
							}
						}
					}
					//CHECKING LEFT TO RIGHT DIAGONAL
					if(i - 1 >= 0 && j - 1 >= 0){//If upleft exists
						if(getMark(i-1,j-1) == mark){//upleft is our mark
							if(i - 2 >= 0 && j - 2 >= 0){//If upupleft exists 
								if(getMark(i-2,j-2) == mark){//Upupleft is our mark
									return true;
								}
							}
							else if(i + 1 <= width && j + 1 <= width){//There is a bottom right
								if(getMark(i+1,j+1) == mark){//bottom right is our mark
									return true;
								}
							}
						}
					}
					if(i + 1 <= width && j + 1 <= width){//There is a bottom right
						if(getMark(i+1,j+1) == mark){//Bottom Right is our mark
							if(i + 2 <= width && j + 2 <= width){//There is a bottom bottom right
								if(getMark(i+2,j+2) == mark){//Bottom bottom right is our mark
									return true;
								}
							}
						}
					}
					//CHECKING RIGHT TO LEFT DIAGONAL
					if(i + 1 <= width && j - 1 >= 0){//If up right exists
						if(getMark(i+1,j-1) == mark){//up right is our mark
							if(i + 2 <= width && j - 2 >= 0){//If up up right exists 
								if(getMark(i+2,j-2) == mark){//Up up right is our mark
									return true;
								}
							}
							else if(i - 1 >= width && j + 1 <= width){//There is a bottom left
								if(getMark(i-1,j+1) == mark){//bottom left is our mark
									return true;
								}
							}
						}
					}
					if(i - 1 >= 0 && j + 1 <= width){//There is a bottom left
						if(getMark(i-1,j+1) == mark){//Bottom left is our mark
							if(i - 2 >= 0 && j + 2 <= width){//There is a bottom bottom left
								if(getMark(i-2,j+2) == mark){//Bottom bottom left is our mark
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false; //IT SAID TO REMOVE but there's got to be a way to tell you no it didn't win. We've tried everything, no win.

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
		//Check to see if there's an empty space left
		for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
				if(getMark(i,j) == EMPTY){
					return false;
				}
			}
		}
		
		//If we get here then every space is not empty
		if(isMarkWin(X) or isMarkWin(O)){
			return false;
		}
		else{
			return true;
		}
        
    }

    public boolean isGameover(){
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
    
}