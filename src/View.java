import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Game;
import model.GameMode;
import model.Move;

public class View implements java.util.Observer {

	private JApplet applet;
	private Controller controller;
	private Container contentPane;
	private JPanel centrePane;
	
	private JButton human_computer_button; 
	private JButton computer_computer_button;
	private JPanel modeButtonPane;
	
	private JButton rock_button;
	private JButton paper_button;
	private JButton scissors_button;
	private JPanel moveButtonPane;
	
	private JLabel player_one_score_label;
	private JLabel player_two_score_label;
	private JLabel tie_label;
	private JPanel scorePane;
	
	public View(JApplet applet) {
		this.applet = applet;
		this.contentPane = applet.getContentPane();
		this.controller = (Controller)applet;
		init();
	}
	
	public void init() {
	    //Execute a job on the event-dispatching thread:
	    //creating this applet's GUI.
	    try {
	        javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
	            public void run() {
	            		createSelectModeGUI();
	            }
	        });
	    } catch (Exception e) {
	        System.err.println("createGUI didn't successfully complete");
	    }
	}
	
	public void createSelectModeGUI() {
		modeButtonPane = initModeButtonPane();
		contentPane.add(modeButtonPane, BorderLayout.SOUTH);
		centrePane = new JPanel();
		contentPane.add(centrePane, BorderLayout.CENTER);
	}
	
	private void addScorePane(String player1, int score1, 
			String player2, int score2, int tieScore) {
		String playerOneScore = player1 + " Wins: " + score1 + "       ";
		String playerTwoScore = player2 + " Wins: " + score2 + "       ";
		String tie = "Ties: " + tieScore + "       ";
		player_one_score_label = new JLabel(playerOneScore);
		player_two_score_label = new JLabel(playerTwoScore);
		tie_label = new JLabel(tie);
		scorePane = new JPanel();
		scorePane.add(player_one_score_label);
		scorePane.add(tie_label);
		scorePane.add(player_two_score_label);
		contentPane.add(scorePane, BorderLayout.NORTH);
	}
	
	private JButton createMoveButton(String buttonName, final Move move) {
		JButton move_button = new JButton(buttonName);
	
		move_button.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  controller.setPlayerOneMove(move);
			  }
		});
		return move_button;
	}
	
	private void addMoveButtonPane() {
		rock_button = createMoveButton("Rock", Move.ROCK);
		paper_button = createMoveButton("Paper", Move.PAPER);
		scissors_button = createMoveButton("Scissors", Move.SCISSORS);

		moveButtonPane = new JPanel();
		
		// Lay out the buttons from left to right
		moveButtonPane.add(rock_button);
		moveButtonPane.add(paper_button);
		moveButtonPane.add(scissors_button);
		centrePane.add(moveButtonPane, BorderLayout.CENTER);
	}

	private JPanel initModeButtonPane() {
		// create a button for human v.s. computer
		human_computer_button = 
				new JButton("New Human VS Computer game");
		
		human_computer_button.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  controller.create_human_VS_computer_game();
			  }
		});
		
		// create a button for computer v.s. computer
		computer_computer_button = 
				new JButton("New Computer VS Computer game");
		
		computer_computer_button.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  controller.create_computer_VS_computer_game();
			  }
		});
		
		// create button panel for the two game mode buttons
		JPanel buttonPane = new JPanel();

		// Lay out the buttons from left to right
		buttonPane.add(human_computer_button);
		buttonPane.add(computer_computer_button);
		return buttonPane;
	}
	
	private void addMoveLabelPane(
			String playerOneName,
			Move playerOneMove, 
			String playerTwoName,
			Move playerTwoMove,
			String winnerName) {
		JLabel move1 = getMoveLabel(playerOneName, playerOneMove);
		contentPane.add(move1, BorderLayout.WEST);
		
		JLabel move2 = getMoveLabel(playerTwoName, playerTwoMove);
		contentPane.add(move2, BorderLayout.EAST);
		
		JLabel result;
		if (winnerName == null) {
			result = new JLabel(" Tie!");
		} else {
			result = new JLabel(winnerName + " won!");
		}
		centrePane.add(result);
	}
	
	private JLabel getMoveLabel(String name, Move move) {
		return new JLabel("   " + name + " : " + move.toString() + "   ");
	}

	private void addNextRoundButton() {
		JButton nextRoundButton = new JButton("Start");
		nextRoundButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  controller.setPlayerOneMove(null);
			  }
		});
		centrePane.add(nextRoundButton, BorderLayout.CENTER);
	}
	
	@Override
	public void update(Observable object, Object arg) {
		Game game = (Game) object;
		updateView(game);
		applet.validate();
	}

	private void updateView(Game game) {
		contentPane.removeAll();
		createSelectModeGUI();
		String playerOneName = game.getPlayerOneName();
		String playerTwoName = game.getPlayerTwoName();
		addScorePane(playerOneName, 
				game.getPlayerOneScore(), 
				playerTwoName,
				game.getPlayerTwoScore(), 
				game.getTieScore());
		
		if (game.getTotalRounds() > 0) {
			addMoveLabelPane(
					playerOneName,
					game.getPlayerOneMove(),
					playerTwoName,
					game.getPlayerTwoMove(),
					game.getWinnerName());
		}

		GameMode gameMode = game.getGameMode();
		if (gameMode == GameMode.HumanVSComputer) {
			addMoveButtonPane();
		} else {
			addNextRoundButton();
		}
		contentPane.validate();
		contentPane.repaint();
	}

	// methods for tests
	public void press_human_VS_computer_button() {
		human_computer_button.doClick();
	}

	public void press_computer_VS_computer_button() {
		computer_computer_button.doClick();
	}

	public void press_scissors_button() {
		scissors_button.doClick();
	}

	public void press_rock_button() {
		rock_button.doClick();	
	}

	public void press_paper_button() {
		paper_button.doClick();
	}
}
