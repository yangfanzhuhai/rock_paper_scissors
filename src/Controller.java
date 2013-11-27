import javax.swing.JApplet;

import model.*;

public class Controller extends JApplet {

  private static final long serialVersionUID = 1L;
  private Game game;
  private View view;

  public Controller() {
    this.view = new View(this);
    game = null;
  }

  public View getView() {
    return view;
  }

  public Game getGame() {
    return game;
  }

  public void create_human_VS_computer_game() {
    Player player1 = new PlayerHuman("You");
    Player player2 = new PlayerComputer("Computer");
    game = new Game(player1, player2, GameMode.HumanVSComputer);
    game.addObserver(view);
    //game.updateView();
  }

  public void create_computer_VS_computer_game() {
    Player player1 = new PlayerComputer("Computer 1");
    Player player2 = new PlayerComputer("Computer 2");
    game = new Game(player1, player2,
        GameMode.ComputerVSComputer);
    game.addObserver(view);
    //game.updateView();
  }

  public void setPlayerOneMove(Move move) {
    if (game != null) {
      Player player = game.getPlayerOne();
      player.setMove(move);

      setPlayerTwoMove(null);
      computeScore();
    }
  }

  private void setPlayerTwoMove(Move move) {
    Player player = game.getPlayerTwo();
    player.setMove(move);
  }

  private void computeScore() {
    game.computeScore();
  }

}
