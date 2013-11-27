import static org.junit.Assert.*;
import model.Move;
import model.MoveComparator;

import org.junit.Test;


public class MoveTest {

	@Test
	public void tieTest() {
		MoveComparator moveComparator = new MoveComparator();
		assertEquals("Comparator does not know tie.",
				0, moveComparator.compare(Move.PAPER, Move.PAPER));
	}
	
	
	@Test
	public void PaperBeatsRockTest() {
		MoveComparator moveComparator = new MoveComparator();
		assertEquals("Paper does not beat Rock",
				1, moveComparator.compare(Move.PAPER, Move.ROCK));
	}
	
	@Test
	public void ScissorsCutPaperTest() {
		MoveComparator moveComparator = new MoveComparator();
		assertEquals("Scissors does not beat Paper",
				1, moveComparator.compare(Move.SCISSORS, Move.PAPER));
	}
	
	@Test
	public void RockBeatsScissorsTest() {
		MoveComparator moveComparator = new MoveComparator();
		assertEquals("Rock does not beat Scissors",
				1, moveComparator.compare(Move.ROCK, Move.SCISSORS));
	}

}
