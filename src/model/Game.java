package model;

public class Game extends java.util.Observable {

  private Player playerOne;
  private Player playerTwo;
  private GameMode gameMode;
  private Player winner;

  private int playerOneScore;
  private int playerTwoScore;
  private int tieScore;
  private int totalRounds;

  public Game(Player player1, Player player2, GameMode mode) {
    this.playerOne = player1;
    this.playerTwo = player2;
    setGameMode(mode);
    resetScores();
    updateView();
  }

  private void resetScores() {
    this.playerOneScore = 0;
    this.playerTwoScore = 0;
    this.tieScore = 0;
    this.totalRounds = 0;
    this.winner = null;
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

  public void setGameMode(GameMode mode) {
    gameMode = mode;
  }

  public Move getPlayerOneMove() {
    return playerOne.getMove();
  }

  public Move getPlayerTwoMove() {
    return playerTwo.getMove();
  }

  public String getWinnerName() {
    if (winner != null) {
      return winner.getName();
    }
    return null;
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
    winner = playerOne;
  }

  private void playerTwoWins() {
    playerTwoScore++;
    winner = playerTwo;
  }

  private void tieRound() {
    tieScore++;
    winner = null;
  }

  public void updateView() {
    setChanged();
    try {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          notifyObservers(this);
        }
      });
    } catch (Exception e) {
      System.err.println("View update didn't "
            + "successfully complete");
    }
  }
}
