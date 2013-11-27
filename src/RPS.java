
import model.Game;
import model.GameMode;
import model.Move;

public class RPS {

  private Game game;
  final private View view;
  
  public static void main(String[] args) {
    new RPS();
  }
  
  public RPS() {
    view = new View(this);
  }

  public View getView() {
    return view;
  }

  public Game getGame() {
    return game;
  }

  private void addViewToGame() {
		game.addObserver(view);
		game.updateView();
  }
  
  public void createGame(GameMode mode) {
    game = new Game(mode);
    addViewToGame();
  }
  
  public void setMove(Move move) {
    game.setHumanMove(move);
  }

  public void runNextRound() {
  		game.computeScore();
  }
  
}
