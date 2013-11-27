package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public enum Move {
  ROCK, PAPER, SCISSORS;

  private static final List<Move> VALUES =
        Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();

  public static Move randomMove()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }
}
