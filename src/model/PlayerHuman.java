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
  public void setMove(Move m) {
    move = m;
  }

  @Override
  public String getName() {
    return name;
  }

}
