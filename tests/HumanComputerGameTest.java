
import static org.junit.Assert.assertTrue;
import model.Game;
import model.GameMode;
import model.Move;
import model.PlayerComputer;
import model.PlayerHuman;

import org.junit.Test;

public class HumanComputerGameTest {
  private  int n = 30;

  @Test
  public void createAHumanVSComputerGameTest() {
    Game game = new Game(GameMode.HumanVSComputer);
    assertTrue("PlayerOne is of wrong type.",
        game.getPlayer(0) instanceof PlayerHuman);
    assertTrue("PlayerTwo is of wrong type.",
        game.getPlayer(1) instanceof PlayerComputer);
    assertTrue("Game data is not initialised for a new game.",
        game.getPlayerScore(0) == 0
        && game.getPlayerScore(1) == 0
        && game.getTieScore() == 0
        && game.getTotalRounds() == 0);
  }

  @Test
  public final void checkTotalRoundsTest() {
    Game game = new Game(GameMode.HumanVSComputer);
    for (int i = 0; i < n; i++) {
      game.setHumanMove(Move.ROCK);
      game.computeScore();
    }
    assertTrue("Game data is not correctly computed.",
        game.getPlayerScore(0)
        + game.getPlayerScore(1)
        + game.getTieScore() == game.getTotalRounds());
  }

}
