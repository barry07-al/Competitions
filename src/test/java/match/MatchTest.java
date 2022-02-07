package match;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import competitor.*;

/**
 * @author amevigbe
 *
 */
public abstract class MatchTest {

	private CompetitorInterface competitor1;

	private CompetitorInterface competitor2;

	private MockMatchs match;

	@BeforeEach
	public void before() {
		this.match = new MockMatchs();

		this.competitor1 = new Competitor("Drift");
		this.competitor2 = new Competitor("Lamborghini");
	}

	@Test
	public void setWinnerTest() {
		Competitor competitor3 = new Competitor("Lamborghini");
		this.match.setWinner(competitor3);
		assertNotNull(match.getWinner());
	}

	@Test
	public void playTest() {
		Match NewMatch = this.createMatch();
		assertNull(NewMatch.getWinner());

		ArrayList<CompetitorInterface> competitors = new ArrayList<>();

		NewMatch.play(this.competitor1, this.competitor2);
		assertNotNull(NewMatch.getWinner());
		CompetitorInterface winner = NewMatch.getWinner();
		competitors.add(this.competitor1);
		competitors.add(this.competitor2);
		assertTrue(competitors.contains(winner));
		assertNotEquals(winner.getPoints(), 0);
		CompetitorInterface competitorNotWin = null;

		for (CompetitorInterface c : competitors) {
			if (!c.equals(winner)) {
				competitorNotWin = c;
			}
		}
		assertEquals(competitorNotWin.getPoints(), 0);
	}

	public abstract Match createMatch();
}
