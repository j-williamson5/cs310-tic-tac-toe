package edu.jsu.mcis;

import static edu.jsu.mcis.TicTacToeModel.Mark.EMPTY;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
		String heading = "\n  ";
		for(int i = 0; i < model.getWidth(); i++){
			heading += Integer.toString(i);
		}
	System.out.print(heading + "\n");//This is the heading and blank line
	for(int i = 0; i < model.getWidth(); i++){
        System.out.print("\n" + Integer.toString(i) + " ");//Print the 0,1,2 etc on the left and a space as well
        for(int j = 0; j < model.getWidth(); j++){
			if(model.getMark(i,j) == EMPTY){//If the square is empty print the -
				System.out.print("-");
				}
			else{
				System.out.print(model.getMark(i,j));//If the square isn't empty print the mark in it
				}
			}
		}
		System.out.print("\n\n\n\n");
	}

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */

		if(model.isXTurn()){
			System.out.println("\n" + "Player 1 (X) Move:");
		}

		else{
			System.out.println("\n" + "Player 2 (O) Move:");
		}

		System.out.println("Enter the row and column numbers, separated by a space: ");
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
	
         System.out.println("ERROR: Incorrect input");
    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println("\n" + r + "!");
    }
}
