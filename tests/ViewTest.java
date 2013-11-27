import static org.junit.Assert.*;
import model.*;

import org.junit.Test;

public class ViewTest {

  @Test
  public void create_new_human_VS_computer_game_test() {
    Controller rps = new Controller();
    View view = rps.getView();
    view.press_human_VS_computer_button();
    Game game = rps.getGame();
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
  public void human_move_test() {
    Controller rps = new Controller();
    View view = rps.getView();
    view.press_human_VS_computer_button();
    view.press_human_VS_computer_button();
    Game game = rps.getGame();
    view.press_rock_button();
    assertEquals("Human player move rock is not set correctly.",
         Move.ROCK, game.getPlayerOneMove());

    view.press_paper_button();
    assertEquals("Human player move paper is not set correctly.",
        Move.PAPER, game.getPlayerOneMove());

    view.press_scissors_button();
    assertEquals("Human player move scissors is not set correctly.",
        Move.SCISSORS, game.getPlayerOneMove());
  }

  @Test
  public void createNewComputerVSComputerGameTest() {
    Controller rps = new Controller();
    View view = rps.getView();
    view.press_computer_VS_computer_button();
    Game game = rps.getGame();
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
