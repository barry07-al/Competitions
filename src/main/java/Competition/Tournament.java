package Competition;

import java.util.*;
import competitor.CompetitorInterface;
import exception.CompetitorQuantityException;
import exception.NoCompetitorException;
import match.Match;
import util.*;

/**
 * @author BARRY Alpha Oumar
 */
public class Tournament extends Competition {

	// Attribute that represents the number of round
	protected int nb_Round;

	// attribute increment
	protected int increment;

	// attribute tmp
	private ArrayList<CompetitorInterface> tmp;

	// attribute competitors_tmp
	private ArrayList<CompetitorInterface> competitors_tmp;

	/**
	 * the constructor
	 * 
	 * @param competitors (ArrayList<CompetitorInterface>) the competitors of
	 *                    competition
	 */
	public Tournament(ArrayList<CompetitorInterface> competitors, Match match) {
		super(competitors);
		this.match = match;
		this.nb_Round = (int) Math.log10(competitors.size());
		this.tmp = new ArrayList<CompetitorInterface>();
		this.competitors_tmp = competitors; // This attribute allows you to have control over the competitors
		this.addmatch = new addMatchForTournament(this.matchs);
	}

	@Override
	public boolean isFinish() {
		return this.competitors_tmp.size() == 1;
	}

	@Override
	public boolean getPossibility() {
		double log = Math.log(this.competitors.size()) / Math.log(2);
		double pow = Math.pow(2, Math.round(log));
		return pow == this.competitors.size();
	}

	@Override
	public void play(ArrayList<CompetitorInterface> competitors)
			throws NoCompetitorException, CompetitorQuantityException {

		if (!this.getPossibility()) {
			throw new CompetitorQuantityException("Le nombre de compétiteur doit être une puissance de deux");
		}
		this.matchs = this.addmatch.addAllMatch(competitors);
		// this.notifyAllObservers();
		while (!this.isFinish()) {
			this.play();
			if (competitors.size() / 2 == this.tmp.size()) {
				competitors = this.tmp;
				this.competitors_tmp = competitors;
				if (!this.isFinish()) {
					this.matchs = this.addmatch.addAllMatch(competitors);
					// this.notifyAllObservers();
				}
				this.tmp = new ArrayList<>();
			}
		}
		this.ranks = MapUtil.sortByDescendingValue(this.ranks);
		this.setWinner(competitors.get(0));
		// StdDisplay.displayMsg(this.toString());
	}

	@Override
	public void incrementNbround() {
		this.increment++;
		if (this.increment == this.competitors.size() / 2) {
			this.nb_Round--;
		}
	}

	@Override
	public String toString() {
		String res = this.getWinner().toString();
		return "************************* " + res + " Wins" + " ****************";
	}

	@Override
	public void consequences() {
		CompetitorInterface winCompetitor = this.match.getWinner();
		CompetitorInterface competitorNotWin = this.match.getCompetitorNotWin();
		this.tmp.add(winCompetitor);
		this.ranks.put(winCompetitor, winCompetitor.getPoints());
		this.ranks.put(competitorNotWin, competitorNotWin.getPoints());
	}
}
