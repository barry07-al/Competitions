package Competition;

import java.util.ArrayList;

import competitor.Competitor;
import competitor.CompetitorInterface;
import match.SingleMatch;

public class LeagueTest extends CompetitionTest {

	private Competitor comp1;

	private Competitor comp2;

	private Competitor comp3;

	private ArrayList<CompetitorInterface> competitors;

	public LeagueTest() {
		this.comp1 = new Competitor("BARRY", 0);
		this.comp3 = new Competitor("Hichem", 0);
		this.comp2 = new Competitor("Yao", 0);
		this.competitors = new ArrayList<>();
		this.competitors.add(this.comp1);
		this.competitors.add(this.comp2);
		this.competitors.add(this.comp3);

	}

	@Override
	public Competition createCompetitions() {
		return new League(this.competitors, new SingleMatch());
	}

}
