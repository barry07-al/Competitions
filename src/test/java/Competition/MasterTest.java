/**
 * 
 */
package Competition;

import java.util.ArrayList;
import competitor.Competitor;
import competitor.CompetitorInterface;
import match.SingleMatch;
import rule.TwoFirstWinner;

/**
 * @author barry
 *
 */
class MasterTest extends CompetitionTest {
	// competitor attributes
	private Competitor comp1;

	private ArrayList<CompetitorInterface> competitors;

	public MasterTest() {

		int i = 0;
		this.competitors = new ArrayList<>();

		for (i = 0; i < 16; i++) {
			this.comp1 = new Competitor("a" + i, 0);
			this.competitors.add(this.comp1);
		}

	}

	@Override
	public Competition createCompetitions() {

		return new Master(this.competitors, new TwoFirstWinner(), 4, new SingleMatch());
	}

}
