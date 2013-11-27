import static org.junit.Assert.*;
import model.Game;
import model.GameMode;
import model.PlayerComputer;

import org.junit.Test;


public class ComputerVSComputerGameTest {

  private final int n = 30;
  @Test
  public void createAComputerVSComputerGameTest() {
    Game game = new Game(GameMode.ComputerVSComputer);
    assertTrue("PlayerOne is of wrong type.",
        game.getPlayer(0) instanceof PlayerComputer);
    assertTrue("PlayerTwo is of wrong type.",
        game.getPlayer(1) instanceof PlayerComputer);
    assertTrue("Game data is not initialised for a new game.",
        game.getPlayerScore(0) == 0
        && game.getPlayerScore(1) == 0
        && game.getTieScore() == 0
        && game.getTotalRounds() == 0);
  }

  @Test
  public void checkTotalRoundsTest() {
    Game game = new Game(GameMode.ComputerVSComputer);
    for (int i = 0; i < n; i++) {
      game.computeScore();
    }
    assertTrue("Game data is not correctly computed.",
        game.getPlayerScore(0)
        + game.getPlayerScore(1)
        + game.getTieScore() == game.getTotalRounds());
  }

}
