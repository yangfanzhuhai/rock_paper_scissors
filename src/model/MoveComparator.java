package model;

import java.util.Comparator;

public class MoveComparator implements Comparator<Move>{

  @Override
  public int compare(Move move1, Move move2) {
    
    if (move1 == move2)
      return 0;
      
    int result = 0;
	  switch (move1) {
	    case ROCK:
	    	  result = (move2 == Move.PAPER) ? -1 : 1;
	    	  break;
	    case PAPER:
	      result = (move2 == Move.SCISSORS) ? -1 : 1;
	      break;
	    case SCISSORS:
	      result = (move2 == Move.ROCK) ? -1 : 1;
	      break;
	  }
    return result;
  }
}
