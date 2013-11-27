package model;

public class PlayerComputer extends Player {
	private Move move;
	private String name;
	
	public PlayerComputer(String name) {
		this.move = null;
		this.name = name;
	}
	
	@Override
	public Move getMove() {
		return this.move;
	}

	public void setMove(Move move) {
		if (move == null) {
			this.move = generateNextMove();
		} else {
			this.move = move;
		}
	}

	private Move generateNextMove() {
		return Move.randomMove();
	}

	@Override
	public String getName() {
		return name;
	}
}
