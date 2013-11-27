package model;

public class Player {
	
  protected Move move;
  private String name;

  protected Player (String playerName) {
    name = playerName;
  }

  public String getName() {
    return name;
  }
  
  public Move getMove() {
    return move;
  }
}
