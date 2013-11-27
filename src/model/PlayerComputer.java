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
  public void setMove(Move newMove) {
    if (newMove == null) {
      move = generateNextMove();
    } else {
      move = newMove;
    }
  }

  private Move generateNextMove() {
    return Move.randomMove();
  }

}
