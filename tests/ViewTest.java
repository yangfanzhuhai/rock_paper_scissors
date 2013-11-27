import static org.junit.Assert.*;
import model.*;

import org.junit.Test;

public class ViewTest {

  @Test
  public void createNewHumanVSComputerGameTest() {
    final RPS rps = new RPS();
    final View view = rps.getView();
    view.pressHumanVSComputerButton();
    final Game game = rps.getGame();
    assertNotNull("New game is not created on button pressed.",
        game);
    assertTrue("PlayerOne is of wrong type.",
        game.getPlayerOne() instanceof PlayerHuman);
    assertTrue("PlayerTwo is of wrong type.",
        game.getPlayerTwo() instanceof PlayerComputer);
    assertTrue("Scores are not initialised for a new game.",
        game.getPlayerOneScore() == 0
        && game.getPlayerTwoScore() == 0
        && game.getTieScore() == 0
        && game.getTotalRounds() == 0);
  }

  @Test
  public void humanMoveTest() {
    final RPS rps = new RPS();
    final View view = rps.getView();
    view.pressHumanVSComputerButton();
    view.pressHumanVSComputerButton();
    final Game game = rps.getGame();
    view.pressRockButton();
    assertEquals("Human player move rock is not set correctly.",
         Move.ROCK, game.getPlayerOneMove());

    view.pressPaperButton();
    assertEquals("Human player move paper is not set correctly.",
        Move.PAPER, game.getPlayerOneMove());

    view.pressScissorsButton();
    assertEquals("Human player move scissors is not set correctly.",
        Move.SCISSORS, game.getPlayerOneMove());
  }

  @Test
  public void createNewComputerVSComputerGameTest() {
    final RPS rps = new RPS();
    final View view = rps.getView();
    view.pressComputerVSComputerButton();
    final Game game = rps.getGame();
    assertNotNull("New game is not created on button pressed.",
        game);
    assertTrue("PlayerOne is of wrong type.",
        game.getPlayerOne() instanceof PlayerComputer);
    assertTrue("PlayerTwo is of wrong type.",
        game.getPlayerTwo() instanceof PlayerComputer);
    assertTrue("Scores are not initialised for a new game.",
        game.getPlayerOneScore() == 0
        && game.getPlayerTwoScore() == 0
        && game.getTieScore() == 0
        && game.getTotalRounds() == 0);
  }

}
