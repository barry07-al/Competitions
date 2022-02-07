package Competition;

import java.util.ArrayList;
import java.util.Map.Entry;

import competitor.CompetitorInterface;
import exception.NoCompetitorException;
import match.Match;
import util.*;

public class League extends Competition {

	protected int Nb_Round = 0;

	/**
	 * the constructor
	 * 
	 * @param competitors (ArrayList<CompetitorInterface>) the competitors of
	 *                    competitions
	 * @param match       (Matches) the type of match
	 */
	public League(ArrayList<CompetitorInterface> competitors, Match match) {
		super(competitors);
		this.match = match;
		this.addmatch = new adderForLeague(this.matchs);
	}

	@Override
	public boolean getPossibility() {
		return this.competitors.size() != 0;
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
		this.matchs = this.addmatch.addAllMatch(competitors);
		this.play();
		this.ranks = MapUtil.sortByDescendingValue(this.ranks);
		StdDisplay.displayMsg("");
		// StdDisplay.displayMsg(this.toString());

	}

	@Override
	public boolean isFinish() {
		return this.Nb_Round == this.competitors.size();
	}

	@Override
	public void incrementNbround() {
		this.Nb_Round++;
	}

	@Override
	public String toString() {

		String msg = "** Ranking **\n";
		String SndMsg = "";
		for (Entry<CompetitorInterface, Integer> entry : this.ranks.entrySet()) {
			SndMsg += entry.getKey() + " ---> " + entry.getValue() + "\n";
		}
		msg += SndMsg;
		return msg;
	}
}
