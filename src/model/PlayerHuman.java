package model;

public class PlayerHuman extends Player {

  private Move move;
  private String name;

  public PlayerHuman(String playerName) {
    this.move = null;
    name = playerName;
  }

  @Override
  public Move getMove() {
    return this.move;
  }

  @Override
  public void setMove(Move newMove) {
    move = newMove;
  }

  @Override
  public String getName() {
    return name;
  }

}
