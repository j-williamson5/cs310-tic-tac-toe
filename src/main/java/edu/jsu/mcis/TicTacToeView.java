package edu.jsu.mcis;

import static edu.jsu.mcis.TicTacToeModel.Mark.EMPTY;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import javax.swing.*;
import java.applet.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class TicTacToeView extends JPanel implements ActionListener{

    private TicTacToeModel model;
    
 
	private JPanel buttonsPanel;
	private JButton[][] squares;
	private JLabel resultLabel;
		
	/* CONSTRUCTOR */

    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
		
		this.squares = new JButton[model.getWidth()][model.getWidth()];
		buttonsPanel = new JPanel(new GridLayout(model.getWidth(),model.getWidth()));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.resultLabel = new JLabel();
		this.resultLabel.setName("ResultLabel");
		this.resultLabel.setText("Result");
		
		
		// loop through every row and col
		for(int row = 0; row < model.getWidth(); row++){
			for(int col = 0; col < model.getWidth(); col++){
				squares[row][col] = new JButton();
				squares[row][col].addActionListener(this);
				squares[row][col].setName("Square" + row + col);
				// finish initializing JButton; add to JPanel
				buttonsPanel.add(squares[row][col]);
			}	
		}
		add(buttonsPanel);
		add(resultLabel);
		
    }
	public void viewModel(){
		for(int row = 0; row < model.getWidth(); row++){
			for(int col = 0; col < model.getWidth(); col++){
				switch(model.getMark(row,col)){
					case X:
						squares[row][col].setText("X");
						break;
					case O:
						squares[row][col].setText("O");
						break;
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(!model.isGameover()){
			//Set up the source and cast it to a jbutton for use with .getName and .setText
			JButton button = (JButton) e.getSource();
			
			
			//Get the row and col to change the grid in the model
			int row = Integer.parseInt(button.getName().substring(6,7));
			int col = Integer.parseInt(button.getName().substring(7,8));
			
			model.makeMark(row,col);
			
			
		}
		if(model.isGameover()){
			showResult(model.getResult().toString());
		}
		viewModel();
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
		
        resultLabel.setText(r);
    }
}
