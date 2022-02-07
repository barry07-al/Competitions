package Competition;

import java.util.ArrayList;
import competitor.*;
import match.*;

public class TournamentTest extends CompetitionTest {

	private Competitor comp1;

	private Competitor comp2;

	private Competitor comp3;

	private Competitor comp4;

	private ArrayList<CompetitorInterface> competitors;

	public TournamentTest() {
		this.comp1 = new Competitor("BARRY", 0);
		this.comp2 = new Competitor("Hichem", 0);
		this.comp3 = new Competitor("Haik", 0);
		this.comp4 = new Competitor("Youcef", 0);

		this.competitors = new ArrayList<>();
		this.competitors.add(this.comp1);
		this.competitors.add(this.comp2);
		this.competitors.add(this.comp3);
		this.competitors.add(this.comp4);
	}

	@Override
	public Competition createCompetitions() {
		return new Tournament(this.competitors, new SingleMatch());
	}

}
