package model;

public class Game extends java.util.Observable {
 
  private final int NumPlayer = 2;
  private final Player[] players;
  private final int[] scores;
  
  private final Move[] currentMoves;
  private final MoveComparator moveComparator;
  private final GameMode gameMode;
  
  private int tieScore;
  private int totalRounds;
  private String winnerName;

  public Game(final GameMode mode) {
    	gameMode = mode;
		players = new Player[NumPlayer];
		initPlayers();
		scores = new int[NumPlayer];
		resetScores();
		currentMoves = new Move[NumPlayer];
	  moveComparator = new MoveComparator();
  }
  
  private void initPlayers() {
  	  switch (gameMode) {
  	    case HumanVSComputer:
  	    	  players[0] = new PlayerHuman("You");
  	      players[1] = new PlayerComputer("Computer");
  	    	  break;
  	    case ComputerVSComputer:
  	    	  players[0] = new PlayerComputer("Computer 1");
  	    	  players[1] = new PlayerComputer("Computer 2");
  	    	  break;
  	  }
  }

  private void resetScores() {
		for (int i = 0; i < NumPlayer; i++) {
			scores[i] = 0;
		}
    tieScore = 0;
    totalRounds = 0;
    winnerName = "";
  }

  public Player getPlayer(int n) {
    return players[n];
  }

  public String getPlayerName(int n) {
    return getPlayer(n).getName();
  }

  public int getPlayerScore(int n) {
    return scores[n];
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

  public Move getPlayerMove(int n) {
    return currentMoves[n];
  }

  public String getWinnerName() {
    return winnerName;
  }
  
  private void playerWins(int n) {
    scores[n]++;
    winnerName = getPlayerName(n);
  }

  private void tieRound() {
    tieScore++;
    winnerName = "";
  }
  
  private void updateCurrentMove() {
    currentMoves[0] = getPlayer(0).getMove();
    currentMoves[1] = getPlayer(1).getMove();
  }

  public void computeScore() {
  		updateCurrentMove();
    switch (moveComparator.compare(currentMoves[0], currentMoves[1])) {
      case 0:
    	    tieRound();
    	    break;
      case 1:
    	    playerWins(0);
    	    break;
      case -1:
    	    playerWins(1);
    	    break;
    }
    totalRounds++;
    updateView();
  }

  public void updateView() {
	    setChanged();
	    notifyObservers(this);
  }

	public void setHumanMove(Move move) {
		if (gameMode == GameMode.HumanVSComputer) {
			((PlayerHuman) players[0]).setMove(move);
		}
  }
}
