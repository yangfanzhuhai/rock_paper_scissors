import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.*;

public class Human_Computer_Game_Test {

	@Test
	public void create_a_human_vs_computer_game_test() {
		Player player1 = new PlayerHuman("");
		Player player2 = new PlayerComputer("");
		Game game = new Game(player1, player2, GameMode.HumanVSComputer);

		assertTrue("PlayerOne is of wrong type.", 
				game.getPlayerOne() instanceof PlayerHuman);
		assertTrue("PlayerTwo is of wrong type.", 
				game.getPlayerTwo() instanceof PlayerComputer);
		assertTrue("Game data is not initialised for a new game.", 
				game.getPlayerOneScore() == 0 && 
				game.getPlayerTwoScore() == 0 && 
				game.getTieScore() == 0 &&
				game.getTotalRounds() == 0);
	}
	
	@Test
	public void human_comp_rock_breaks_scissors_test() {
		Player player1 = new PlayerHuman("");
		Player player2 = new PlayerComputer("");
		Game game = new Game(player1, player2, 
				GameMode.ComputerVSComputer);
		player1.setMove(Move.ROCK);
		player2.setMove(Move.SCISSORS);
		game.computeScore();
		assertTrue("Game data is not correctly computed.", 
				game.getPlayerOneScore() == 1 && 
				game.getPlayerTwoScore() == 0 && 
				game.getTieScore() == 0 &&
				game.getTotalRounds() == 1);
	}
	
	@Test
	public void human_comp_rock_breaks_scissors_twice_test() {
		Player player1 = new PlayerHuman("");
		Player player2 = new PlayerComputer("");
		Game game = new Game(player1, player2, GameMode.HumanVSComputer);
		player1.setMove(Move.ROCK);
		player2.setMove(Move.SCISSORS);
		game.computeScore();
		player1.setMove(Move.ROCK);
		player2.setMove(Move.SCISSORS);
		game.computeScore();
		assertTrue("Game data is not correctly computed.", 
				game.getPlayerOneScore() == 2 && 
				game.getPlayerTwoScore() == 0 && 
				game.getTieScore() == 0 &&
				game.getTotalRounds() == 2);
	}
	
	@Test
	public void human_comp_scissors_cut_paper_test() {
		Player player1 = new PlayerHuman("");
		Player player2 = new PlayerComputer("");
		Game game = new Game(player1, player2, GameMode.HumanVSComputer);
		player1.setMove(Move.SCISSORS);
		player2.setMove(Move.PAPER);
		game.computeScore();
		assertTrue("Game data is not correctly computed.", 
				game.getPlayerOneScore() == 1 && 
				game.getPlayerTwoScore() == 0 && 
				game.getTieScore() == 0 &&
				game.getTotalRounds() == 1);
	}
	
	@Test
	public void human_comp_paper_beats_rock_test() {
		Player player1 = new PlayerHuman("");
		Player player2 = new PlayerComputer("");
		Game game = new Game(player1, player2, GameMode.HumanVSComputer);
		player1.setMove(Move.ROCK);
		player2.setMove(Move.PAPER);
		game.computeScore();
		assertTrue("Game data is not correctly computed.", 
				game.getPlayerOneScore() == 0 && 
				game.getPlayerTwoScore() == 1 && 
				game.getTieScore() == 0 &&
				game.getTotalRounds() == 1);
	}
	
	@Test
	public void check_totalRounds_test() {
		Player player1 = new PlayerHuman("");
		Player player2 = new PlayerComputer("");
		Game game = new Game(player1, player2, GameMode.HumanVSComputer);
		int n = 30;
		for (int i = 0; i < n; i++) {
			player1.setMove(Move.ROCK);
			player2.setMove(Move.PAPER);
			game.computeScore();
		}
		assertTrue("Game data is not correctly computed.", 
				game.getPlayerOneScore() == 0 && 
				game.getPlayerTwoScore() == n && 
				game.getTieScore() == 0 &&
				game.getTotalRounds() == n);
	}
	
	@Test
	public void check_totalRounds_with_random_test() {
		Player player1 = new PlayerHuman("");
		Player player2 = new PlayerComputer("");
		Game game = new Game(player1, player2, GameMode.HumanVSComputer);
		int n = 30;
		for (int i = 0; i < n; i++) {
			player1.setMove(Move.ROCK);
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
