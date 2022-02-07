package Competition;

import java.util.*;

import competitor.*;
import exception.NoCompetitorException;
import match.*;
import util.adderForLeague;
import util.adderMatch;

public class MockCompetition extends Competition {

	private CompetitorInterface winner;
	public static int MockNb_Round;

	public MockCompetition(ArrayList<CompetitorInterface> competitors) {

		super(competitors);
		this.match = new SingleMatch();
		this.addmatch = new adderForLeague(matchs);

	}

	public void setWinner1(Competitor c) {

		this.winner = c;
	}
	@Override
	public boolean isFinish() {
		return MockNb_Round == this.competitors.size();
	}
	@Override
	public boolean getPossibility() {
		return true;
	}

	@Override
	public void setWinner(CompetitorInterface competitor) {
		this.winner = competitor;

	}

	@Override
	public CompetitorInterface getWinner() {
		return this.winner;
	}

	@Override
	public void consequences() {
		CompetitorInterface winCompetitor = this.match.getWinner();
		CompetitorInterface competitorNotWin = this.match.getCompetitorNotWin();
		this.ranks.put(winCompetitor, winCompetitor.getPoints());
		this.ranks.put(competitorNotWin, competitorNotWin.getPoints());

	}

	@Override
	public void play(ArrayList<CompetitorInterface> competitors) throws NoCompetitorException {
		this.addmatch.addAllMatch(competitors);
		this.play();
	}

	public adderMatch getAddMatch() {
		return this.addmatch;
	}

	@Override
	public void incrementNbround() {
		MockNb_Round++;

	}
	@Override
	public String toString() {
		return "Competition";
	}

}