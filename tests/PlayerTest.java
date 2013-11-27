import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import model.*;


import org.junit.Test;


public class PlayerTest {

	@Test
	public void create_a_HumanPlayer_test() {
		Player player = new PlayerHuman("");
		assertTrue("PlayerOne is of wrong type.", 
				player instanceof PlayerHuman);
	}

	@Test
	public void create_a_ComputerPlayer_test() {
		Player player = new PlayerComputer("");
		assertTrue("PlayerTwo is of wrong type.", 
				player instanceof PlayerComputer);
	}
	
	@Test
	public void set_and_get_move_for_HumanPlayer_test() {
		Player player = new PlayerHuman("");
		player.setMove(Move.PAPER);
		assertTrue("The move from humanplayer is of wrong type.", 
				player.getMove() instanceof Move);
		assertEquals("The move for the humanplayer is not " +
				"correctly stored.", Move.PAPER, player.getMove());
	}
	
	@Test
	public void set_and_get_move_for_ComputerPlayer_test() {
		Player player = new PlayerComputer("");
		player.setMove(null);
		assertTrue("The move from humanplayer is of wrong type.", 
				player.getMove() instanceof Move);
	}
}
