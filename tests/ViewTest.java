import static org.junit.Assert.*;
import model.*;

import org.junit.Test;

public class ViewTest {
	
	@Test
	public void create_new_human_VS_computer_game_test() {
		Controller rps = new Controller();
		View view = rps.getView();
		view.press_human_VS_computer_button();
		assertNotNull("New game is not created on button pressed.", 
				rps.getGame());
		assertTrue("PlayerOne is of wrong type.", 
				rps.getPlayerOne() instanceof PlayerHuman);
		assertTrue("PlayerTwo is of wrong type.", 
				rps.getPlayerTwo() instanceof PlayerComputer);
		assertTrue("Scores are not initialised for a new game.", 
				rps.getPlayerOneScore() == 0 &&
				rps.getPlayerTwoScore() == 0 &&
				rps.getTieScore() == 0 &&
				rps.getTotalRounds() == 0);
	}
	
	@Test
	public void human_move_test() {
		Controller rps = new Controller();
		View view = rps.getView();
		view.press_human_VS_computer_button();
		view.press_rock_button();
		assertEquals("Human player move rock is not set correctly.", 
				rps.getPlayerOneMove(), Move.ROCK);
		
		view.press_paper_button();
		assertEquals("Human player move paper is not set correctly.", 
				rps.getPlayerOneMove(), Move.PAPER);
		
		view.press_scissors_button();
		assertEquals("Human player move scissors is not set correctly.", 
				rps.getPlayerOneMove(), Move.SCISSORS);
	}
	
	@Test
	public void create_new_computer_VS_computer_game_test() {
		Controller rps = new Controller();
		View view = rps.getView();
		view.press_computer_VS_computer_button();
		assertNotNull("New game is not created on button pressed.", 
				rps.getGame());
		assertTrue("PlayerOne is of wrong type.", 
				rps.getPlayerOne() instanceof PlayerComputer);
		assertTrue("PlayerTwo is of wrong type.", 
				rps.getPlayerTwo() instanceof PlayerComputer);
		assertTrue("Scores are not initialised for a new game.", 
				rps.getPlayerOneScore() == 0 && 
				rps.getPlayerTwoScore() == 0 && 
				rps.getTieScore() == 0 &&
				rps.getTotalRounds() == 0);
	}
	
	

}
