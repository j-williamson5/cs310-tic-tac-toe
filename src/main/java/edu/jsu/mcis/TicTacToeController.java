package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeController {

    private TicTacToeModel model;
    private TicTacToeView view;
    private Scanner keyboard;
    
    /* CONSTRUCTOR */

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        
        /* Initialize model and view */

        this.model = model;
        this.view = view;
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);

    }

    public void controlModel() {
        
        /* Prompt player for next move using view's showNextMovePrompt() */
        
        view.showNextMovePrompt();
        
        /* Receive and validate input, which should be read at the keyboard as
           two integers, the row and the column (for example, "1 1" for the
           center square of a 3 x 3 grid).  Make mark if input is valid, or show
           error message using view's showInputError() if input is invalid. */
        
        /* INSERT YOUR CODE HERE */
	String input = keyboard.nextLine();
	int row = Character.getNumericValue(input.charAt(0));
	int col = Character.getNumericValue(input.charAt(2));

	if(row < model.getWidth() && col < model.getWidth() && row >= 0 && col >=0){//If the input is valid
		model.makeMark(row,col);
	}
	else{
		view.showInputError();
	}
        
    model.getResult();

    }

}
