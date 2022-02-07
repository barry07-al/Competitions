package Competition;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Map.Entry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import competitor.*;
import exception.CompetitorQuantityException;
import exception.NoCompetitorException;
import exception.RanksException;

/**
 * @author amevigbe
 *
 */
public abstract class CompetitionTest {

	private Competition competition;

	@BeforeEach
	public void before() {

		this.competition = this.createCompetitions();
	}

	@Test
	public void possibilityTest() {
		assertTrue(this.competition.getPossibility());
	}

	private int getMaxScore(Competition competition2) {
		int res = 0;
		for (Entry<CompetitorInterface, Integer> entry : competition2.getRanks().entrySet()) {
			if (res <= entry.getValue()) {
				res = entry.getValue();
			}
		}
		return res;
	}

	@Test
	public void playTest() throws NoCompetitorException, CompetitorQuantityException, RanksException {
		int res = 0;
		res = this.getMaxScore(this.competition);
		assertEquals(res, 0);
		this.competition.play(this.competition.getCompetitor());

		res = this.getMaxScore(this.competition);
		System.out.println(this.competition.getRanks());
		assertNotEquals(res, 0);

	}

	public abstract Competition createCompetitions();

}
