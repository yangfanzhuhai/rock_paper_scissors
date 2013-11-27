import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import model.Move;
import model.Player;
import model.PlayerComputer;
import model.PlayerHuman;

import org.junit.Test;

public class PlayerTest {

  @Test
  public void createAHumanPlayerTest() {
    Player player = new PlayerHuman("");
    assertTrue("PlayerOne is of wrong type.",
        player instanceof Player);
  }

  @Test
  public void createAComputerPlayerTest() {
    Player player = new PlayerComputer("");
    assertTrue("PlayerTwo is of wrong type.",
        player instanceof PlayerComputer);
  }

  @Test
  public void setAndGetMoveForHumanPlayerTest() {
    PlayerHuman player = new PlayerHuman("");
    player.setMove(Move.PAPER);
    assertTrue("The move from humanplayer is of wrong type.",
        player.getMove() instanceof Move);
    assertEquals("The move for the humanplayer is not correctly "
        + "stored.", Move.PAPER, player.getMove());
  }

  @Test
  public void setAndGetMoveForComputerPlayerTest() {
    Player player = new PlayerComputer("");
    assertTrue("The move from humanplayer is of wrong type.",
        player.getMove() instanceof Move);
  }
}
