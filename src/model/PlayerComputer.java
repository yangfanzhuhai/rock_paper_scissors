package model;

public class PlayerComputer extends Player {

  public PlayerComputer(String playername) {
    super(playername);
  }

  @Override
  public Move getMove() {
    return Move.randomMove();
  }
}
