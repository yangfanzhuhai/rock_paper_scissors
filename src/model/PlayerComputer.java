package model;

public class PlayerComputer extends Player {
  private Move move;
  private String name;

  public PlayerComputer(String playername) {
    this.move = null;
    name = playername;
  }

  @Override
  public Move getMove() {
    return this.move;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setMove(Move m) {
    if (m == null) {
      move = generateNextMove();
    } else {
      move = m;
    }
  }

  private Move generateNextMove() {
    return Move.randomMove();
  }

}
