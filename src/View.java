import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Game;
import model.GameMode;
import model.Move;

public class View implements java.util.Observer {

  private JFrame jframe;
  private RPS controller;
  private Container contentPane;
  private JPanel centrePane;

  private JButton humanComputerButton;
  private JButton computerComputerButton;
  private JPanel modeButtonPane;

  private JButton rockButton;
  private JButton paperButton;
  private JButton scissorsButton;
  private JPanel moveButtonPane;

  private JLabel playerOneScoreLabel;
  private JLabel playerTwoScoreLabel;
  private JLabel tieLabel;
  private JPanel scorePane;
  
  public View(RPS control) {
	jframe = new JFrame("Rock Paper Scissors");
	contentPane = jframe.getContentPane();
	contentPane.setPreferredSize(new Dimension(700, 300));
	controller = control;
	initFrame();
	createSelectModeGUI();
  }
  
  private void initFrame() {
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.pack();
	jframe.setResizable(false);
	jframe.setVisible(true);
  }

  private void createSelectModeGUI() {
    modeButtonPane = initModeButtonPane();
    contentPane.add(modeButtonPane, BorderLayout.SOUTH);
    centrePane = new JPanel();
    centrePane.setLayout(new BorderLayout());
    contentPane.add(centrePane, BorderLayout.CENTER);
  }

  private void addScorePane(String player1, int score1,
      String player2, int score2, int tieScore) {
    String playerOneScore = player1 + " Wins: "
              + score1 + "       ";
    String playerTwoScore = player2 + " Wins: "
              + score2 + "       ";
    String tie = "Ties: " + tieScore + "       ";
    playerOneScoreLabel = new JLabel(playerOneScore);
    playerTwoScoreLabel = new JLabel(playerTwoScore);
    tieLabel = new JLabel(tie);
    scorePane = new JPanel();
    scorePane.add(playerOneScoreLabel);
    scorePane.add(tieLabel);
    scorePane.add(playerTwoScoreLabel);
    contentPane.add(scorePane, BorderLayout.NORTH);
  }

  private JButton createMoveButton(String buttonName, final Move move) {
    JButton moveButton = new JButton(buttonName);

    moveButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          controller.setPlayerOneMove(move);
        }
    });
    return moveButton;
  }

  private void addMoveButtonPane() {
    rockButton = createMoveButton("Rock", Move.ROCK);
    paperButton = createMoveButton("Paper", Move.PAPER);
    scissorsButton = createMoveButton("Scissors", Move.SCISSORS);

    moveButtonPane = new JPanel();

    // Lay out the buttons from left to right
    moveButtonPane.add(rockButton);
    moveButtonPane.add(paperButton);
    moveButtonPane.add(scissorsButton);
    centrePane.add(moveButtonPane, BorderLayout.SOUTH);
  }

  private JPanel initModeButtonPane() {
    // create a button for human v.s. computer
    humanComputerButton =
        new JButton("Human VS Computer");

    humanComputerButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          controller.createHumanVSComputerGame();
        }
    });

    // create a button for computer v.s. computer
    computerComputerButton =
        new JButton("Computer VS Computer");

    computerComputerButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          controller.createComputerVSComputerGame();
        }
    });

    // create button panel for the two game mode buttons
    JPanel buttonPane = new JPanel();
    // Lay out the buttons from left to right
    buttonPane.add(humanComputerButton);
    buttonPane.add(computerComputerButton);
    return buttonPane;
  }

  private void addMoveLabelPane(
      String playerOneName,
      Move playerOneMove,
      String playerTwoName,
      Move playerTwoMove) {
    JLabel move1 = getMoveLabel(playerOneName, playerOneMove);
    contentPane.add(move1, BorderLayout.WEST);

    JLabel move2 = getMoveLabel(playerTwoName, playerTwoMove);
    contentPane.add(move2, BorderLayout.EAST);
  }

  private JLabel getMoveLabel(String name, Move move) {
    JLabel moveLabel = new JLabel("   " + name + " : " 
                         + move.toString() + "   ");
    moveLabel.setFont(moveLabel.getFont().deriveFont(16.0f));
    return moveLabel;
  }

  private void addResultLabelPane(String winnerName) {
    JLabel result;
    if (winnerName == "") {
      result = new JLabel(" Tie!");
    } else {
      result = new JLabel(winnerName + " won!");
    }
    result.setFont(result.getFont().deriveFont(32.0f));
    JPanel resultPane = new JPanel();
    resultPane.add(result);
    centrePane.add(resultPane, BorderLayout.CENTER);
  }

  private void addNextRoundButton() {
    JButton nextRoundButton = new JButton("Start");
    nextRoundButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          controller.setPlayerOneMove(null);
        }
    });
    JPanel startButtonPane = new JPanel();
    startButtonPane.add(nextRoundButton);
    centrePane.add(startButtonPane, BorderLayout.SOUTH);
  }

  @Override
  public void update(Observable object, Object arg) {
	Game game = (Game) object;
	updateView(game);
	jframe.validate();
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
          game.getPlayerTwoMove());
      addResultLabelPane(game.getWinnerName());
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
  public void pressHumanVSComputerButton() {
    humanComputerButton.doClick();
  }

  public void pressComputerVSComputerButton() {
    computerComputerButton.doClick();
  }

  public void pressRockButton() {
    rockButton.doClick();
  }

  public void pressPaperButton() {
    paperButton.doClick();
  }

  public void pressScissorsButton() {
    scissorsButton.doClick();
  }
}
