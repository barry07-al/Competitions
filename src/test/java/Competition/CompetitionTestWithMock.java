package Competition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competitor.*;
import exception.NoCompetitorException;
import match.*;

public class CompetitionTestWithMock {

	private MockCompetition competition;

	private Competitor comp1;

	private Competitor comp2;

	private Competitor comp3;

	private ArrayList<CompetitorInterface> competitors;
	
	private Match match ;

	@BeforeEach
	public void init() {

		this.comp1 = new Competitor("BARRY", 0);
		this.comp3 = new Competitor("Hichem", 0);
		this.comp2 = new Competitor("Yao", 0);

		this.competitors = new ArrayList<>();
		this.competitors.add(this.comp1);
		this.competitors.add(this.comp2);
		this.competitors.add(this.comp3);
		this.competition = new MockCompetition(this.competitors);
		this.match = new SingleMatch();

	}

	@Test
	public void removeMatchTest() throws NoCompetitorException {
		assertTrue(this.competition.getMatch().size() == 0);
		this.competition.getAddMatch().addMatch(this.comp1, this.competitors);
		assertTrue(this.competition.getMatch().size() == 1);
		this.competition.removeMatch(this.comp1);
		assertTrue(this.competition.getMatch().size() == 0);
	}

	@Test
	public void setWinnerTest() {
		assertNull(this.competition.getWinner());
		this.competition.setWinner(this.comp2);

		assertEquals(this.competition.getWinner(), this.comp2);
	}

	private int getMaxScore(MockCompetition competition) {
		int res = 0;
		for (Entry<CompetitorInterface, Integer> entry : competition.getRanks().entrySet()) {
			if (res <= entry.getValue()) {
				res = entry.getValue();
			}
		}
		return res;
	}

	@Test
	public void playTest() throws NoCompetitorException {
		int res = 0;
		res = this.getMaxScore(this.competition);
		for (CompetitorInterface c : this.competitors) {
			this.competition.getAddMatch().addMatch(c, this.competitors);
		}
		assertEquals(res, 0);
		this.competition.play(competitors);
		res = this.getMaxScore(this.competition);
		assertNotEquals(res, 0);

		assertTrue(res <= this.competitors.size() * 2);

		assertTrue(this.competition.isFinish());
	}

}
