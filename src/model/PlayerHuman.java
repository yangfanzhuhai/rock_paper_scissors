package model;

public class PlayerHuman extends Player {

  public PlayerHuman (String playerName) {
    super(playerName);
  }

  public void setMove(Move newMove) {
    super.move = newMove;
  }

}
