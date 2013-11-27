package model;

public class Game extends java.util.Observable {

  private final Player playerOne;
  private final Player playerTwo;
  private final GameMode gameMode;
  private String winnerName;

  private int playerOneScore;
  private int playerTwoScore;
  private int tieScore;
  private int totalRounds;

  public Game(final Player player1, final Player player2, 
		  final GameMode mode) {
    playerOne = player1;
    playerTwo = player2;
    gameMode = mode;
    resetScores();
  }

  private void resetScores() {
    playerOneScore = 0;
    playerTwoScore = 0;
    tieScore = 0;
    totalRounds = 0;
    winnerName = "";
  }

  public Player getPlayerOne() {
    return playerOne;
  }

  public Player getPlayerTwo() {
    return playerTwo;
  }

  public String getPlayerOneName() {
    return playerOne.getName();
  }

  public String getPlayerTwoName() {
    return playerTwo.getName();
  }

  public int getPlayerOneScore() {
    return playerOneScore;
  }

  public int getPlayerTwoScore() {
    return playerTwoScore;
  }

  public int getTieScore() {
    return tieScore;
  }

  public int getTotalRounds() {
    return totalRounds;
  }

  public GameMode getGameMode() {
    return gameMode;
  }

  public Move getPlayerOneMove() {
    return playerOne.getMove();
  }

  public Move getPlayerTwoMove() {
    return playerTwo.getMove();
  }

  public String getWinnerName() {
    return winnerName;
  }

  public void computeScore() {
    Move move1 = getPlayerOneMove();
    Move move2 = getPlayerTwoMove();
    if (move1 == move2) {
      tieRound();
    } else {
      switch (move1) {
        case ROCK:
          if (move2 == Move.PAPER) {
            playerTwoWins();
          } else if (move2 == Move.SCISSORS) {
            playerOneWins();
          }
          break;
        case PAPER:
          if (move2 == Move.ROCK) {
            playerOneWins();
          } else if (move2 == Move.SCISSORS) {
            playerTwoWins();
          }
          break;
        case SCISSORS:
          if (move2 == Move.ROCK) {
            playerTwoWins();
          } else if (move2 == Move.PAPER) {
            playerOneWins();
          }
          break;
      }
    }
    totalRounds++;
    updateView();
  }

  private void playerOneWins() {
    playerOneScore++;
    winnerName = getPlayerOneName();
  }

  private void playerTwoWins() {
    playerTwoScore++;
    winnerName = getPlayerTwoName();
  }

  private void tieRound() {
    tieScore++;
    winnerName = "";
  }

  public void updateView() {
	    setChanged();
	    notifyObservers(this);
  }
}
