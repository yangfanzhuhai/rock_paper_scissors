package model;

public class PlayerHuman extends Player {

	private Move move;
	private String name;
	
	public PlayerHuman(String name) {
		this.move = null;
		this.name = name;
	}
	
	@Override
	public Move getMove() {
		return this.move;
	}

	@Override
	public void setMove(Move move) {
		this.move = move;
	}

	@Override
	public String getName() {
		return name;
	}

}
