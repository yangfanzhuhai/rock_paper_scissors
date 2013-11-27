import static org.junit.Assert.*;

import model.Game;
import model.GameMode;
import model.Player;
import model.PlayerComputer;

import org.junit.Test;


public class Computer_Computer_Game_Test {

	@Test
	public void create_a_computer_vs_computer_game_test() {
		Player player1 = new PlayerComputer("");
		Player player2 = new PlayerComputer("");
		Game game = new Game(player1, player2, 
				GameMode.ComputerVSComputer);

		assertTrue("PlayerOne is of wrong type.", 
				game.getPlayerOne() instanceof PlayerComputer);
		assertTrue("PlayerTwo is of wrong type.", 
				game.getPlayerTwo() instanceof PlayerComputer);
		assertTrue("Game data is not initialised for a new game.", 
				game.getPlayerOneScore() == 0 && 
				game.getPlayerTwoScore() == 0 && 
				game.getTieScore() == 0 &&
				game.getTotalRounds() == 0);
	}
	
	@Test
	public void check_totalRounds_test() {
		Player player1 = new PlayerComputer("");
		Player player2 = new PlayerComputer("");
		Game game = new Game(player1, player2, 
				GameMode.ComputerVSComputer);
		int n = 30;
		for (int i = 0; i < n; i++) {
			player1.setMove(null);
			player2.setMove(null);
			game.computeScore();
		}
		assertTrue("Game data is not correctly computed.", 
				game.getPlayerOneScore() + 
				game.getPlayerTwoScore() +
				game.getTieScore() ==
				game.getTotalRounds());
	}

}
