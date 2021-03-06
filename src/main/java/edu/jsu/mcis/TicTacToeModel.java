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
        TIE("TIE"), 
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
		
       grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */
    for(int i = 0; i < width; i++){
		for(int j = 0; j < width; j++){
                        grid[i][j] = Mark.EMPTY;
                  }
        }
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        /* INSERT YOUR CODE HERE */
        if(isValidSquare(row,col) && !isSquareMarked(row,col)){ //Using these built in functions to determine if the square is occupied and a valid square
                   if(xTurn){
                        grid[row][col] = Mark.X;
						xTurn = false;
						
					}
					else{
                        grid[row][col] = Mark.O;
						xTurn = true;
					}
					return true;
        }  
		
		
        return false; //No return Statement?
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
        if(grid[row][col] == Mark.EMPTY){
	return false;
        }
        else{
	return true;
        }
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */
		return grid[row][col];
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
		if(isMarkWin(Mark.X)){
			return Result.X;
		}
		else if(isMarkWin(Mark.O)){
			return Result.O;
		}
		else if(isTie()){
			return Result.TIE;
		}
		else{
			return Result.NONE;
		}
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
		int consecutiveMarks = 0;
		
		//CHECK FOR VERTICAL WINS
		for(int i = 0; i < width; i++){//Loop through top row
				for(int j = 0; j < width; j++){//Go below it until you hit the bottom
					if(getMark(i,j) == mark){
						consecutiveMarks++;
					}
					else{
						consecutiveMarks = 0;
					}
				}
				if(consecutiveMarks == width){
					return true;
				}
		
			consecutiveMarks = 0;
		}
		
		//CHECK FOR HORIZONTAL WINS
		for(int j = 0; j < width; j++){//Loop through the first column
				for(int i = 0; i < width; i++){//Go to the right of it until you hit the right
					if(getMark(i,j) == mark){//If the mark matches add one to the total
						consecutiveMarks++;
					}
					else{
						consecutiveMarks = 0;
					}
				}
				if(consecutiveMarks == width){
					return true;
				}
			consecutiveMarks = 0;
		}
		
		//CHECKING LEFT TO RIGHT DIAGONAL
		for(int i = 0; i < width; i++){
			if(getMark(i,i) == mark){
				consecutiveMarks++;
			}
			else{
				consecutiveMarks = 0;
			}
			
			if(consecutiveMarks == width){
				return true;
			}
		}
		consecutiveMarks = 0;
		
		//CHECKING RIGHT TO LEFT DIAGONAL
		for(int i = 0; i < width; i++){
			if(getMark(i,width - 1 - i) == mark){
				consecutiveMarks++;
			}
			else{
				consecutiveMarks = 0;
			}
			if(consecutiveMarks == width){
				return true;
			}
		}
		consecutiveMarks = 0;
		
		return false; //IT SAID TO REMOVE but there's got to be a way to tell you no it didn't win. We've tried everything, no win.
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
        //Check to see if there's an empty space left
        for(int i = 0; i < width; i++){
	for(int j = 0; j < width; j++){
                        if(getMark(i,j) == Mark.EMPTY){
                                return false;
                         }
                    }
         }
		
        //If we get here then every space is not empty
        if(isMarkWin(Mark.X) || isMarkWin(Mark.O)){
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
