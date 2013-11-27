
import model.Game;
import model.GameMode;
import model.Move;
import model.Player;
import model.PlayerComputer;
import model.PlayerHuman;

public class RPS {

  private Game game;
  final private View view;
  
  public static void main(String[] args) {
	  new RPS();
  }
  
  public RPS() {
    this.view = new View(this);
  }

  public View getView() {
    return view;
  }

  public Game getGame() {
    return game;
  }

  public void createHumanVSComputerGame() {
	final Player player1 = new PlayerHuman("You");
    final Player player2 = new PlayerComputer("Computer");
    game = new Game(player1, player2, GameMode.HumanVSComputer);
    addView();
  }

private void addView() {
	game.addObserver(view);
    game.updateView();
}

  public void createComputerVSComputerGame() {
    final Player player1 = new PlayerComputer("Computer 1");
    final Player player2 = new PlayerComputer("Computer 2");
    game = new Game(player1, player2,
        GameMode.ComputerVSComputer);
    addView();
  }

  public void setPlayerOneMove(Move move) {
    if (game != null) {
      final Player player = game.getPlayerOne();
      player.setMove(move);

      setPlayerTwoMove(null);
      computeScore();
    }
  }

  private void setPlayerTwoMove(Move move) {
    final Player player = game.getPlayerTwo();
    player.setMove(move);
  }

  private void computeScore() {
    game.computeScore();
  }

}
