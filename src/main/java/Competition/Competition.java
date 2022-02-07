package Competition;

import competitor.CompetitorInterface;

import speakers.*;
import exception.CompetitorQuantityException;
import exception.NoCompetitorException;
import exception.RanksException;
import java.util.*;
import match.Match;
import util.StdDisplay;
import util.adderMatch;

public abstract class Competition extends SpeakersObservable {

	// Attribute that represents the lists of the competitors
	protected final ArrayList<CompetitorInterface> competitors;

	// Attribute that represents the rank of competition
	protected Map<CompetitorInterface, Integer> ranks;

	// Attribute informing us of the state of the competition
	protected boolean isFinish;

	// Attribute informing us if it's possible the start of the competition
	protected boolean isPossible;

	// Attribute that represents the matchs list of competition
	protected Map<CompetitorInterface, ArrayList<CompetitorInterface>> matchs;

	// Attribute that represents the winner of competition
	protected CompetitorInterface winner;

	// attribute that represents the match
	protected adderMatch addmatch;

	/**
	 * Competition class constructor
	 * 
	 * @param competitors
	 */
	public Competition(ArrayList<CompetitorInterface> competitors) {
		super();
		this.competitors = competitors;
		this.ranks = new HashMap<>();
		this.initRanks();
		this.isFinish = false;
		this.winner = null;
		this.matchs = new HashMap<>();
	}

	/**
	 * This method allows to initialize the ranks of the players
	 */
	private void initRanks() {
		for (CompetitorInterface competitor : this.competitors) {
			this.ranks.put(competitor, 0);
		}
	}

	/**
	 * method that return the list of competitors of competition
	 * 
	 * @return the competitors
	 */
	public ArrayList<CompetitorInterface> getCompetitor() {
		return this.competitors;
	}

	/**
	 * method that return the map, which contain the matches of competition
	 * 
	 * @return the map of matches
	 */
	public Map<CompetitorInterface, ArrayList<CompetitorInterface>> getMatch() {
		return this.matchs;
	}

	/**
	 * method that return the list of ranks after play competition
	 * 
	 * @return the map of ranks
	 */
	public Map<CompetitorInterface, Integer> getRanks() {
		return this.ranks;
	}

	/**
	 * This method allows us to delete a match corresponding to a player
	 * 
	 * @param competitor
	 * @throws NoCompetitorException
	 */
	public void removeMatch(CompetitorInterface competitor) throws NoCompetitorException {
		if (!this.competitors.contains(competitor)) {
			throw new NoCompetitorException();
		}
		this.matchs.remove(competitor);
	}

	/**
	 * This method allows us to return the winner of the competition
	 * 
	 * @return winner (CompetitorInterface) the competitor
	 */
	public CompetitorInterface getWinner() {
		return this.winner;
	}

	/**
	 * This method allows you to modify the attribute winner
	 * 
	 * @param competitor
	 */
	public void setWinner(CompetitorInterface competitor) {
		this.winner = competitor;
	}

	/**
	 * This method allows a match to be played and applies the consequence to that
	 * match
	 * 
	 * @param (competitorInterface) the competitor one
	 * @param (competitorInterface) the competitor two
	 */
	protected void playMatch(CompetitorInterface competitor1, CompetitorInterface competitor2) {
		this.match.play(competitor1, competitor2);
		this.consequences();
		this.match.notifyAllObservers();
	}

	/**
	 * This method organizes all the matches and also allows them to be played
	 */
	public void play() {
		Map<CompetitorInterface, ArrayList<CompetitorInterface>> competitors = this.getMatch();
		for (Map.Entry<CompetitorInterface, ArrayList<CompetitorInterface>> entry : competitors.entrySet()) {
			for (CompetitorInterface competitor : entry.getValue()) {
				this.playMatch(entry.getKey(), competitor);
			}
			this.incrementNbround();
		}
	}

	/**
	 * This method is the consequence applied to a match
	 */
	public abstract void consequences();

	/**
	 * This method adds all matches to the match list
	 * 
	 * @return (Boolean) true or false
	 */
	public abstract boolean isFinish();

	/**
	 * This method allows to know if the fact of organizing the competition is
	 * possible
	 * 
	 * @return (boolean) true or false
	 */
	public abstract boolean getPossibility();

	/**
	 * This method takes the list of competitors and allows you to organize the
	 * different matches and play them
	 * 
	 * @param competitors the list of competitor that play competition
	 * @throws NoCompetitorException
	 * @throws CompetitorQuantityException
	 * @throws RanksException
	 */
	public abstract void play(ArrayList<CompetitorInterface> competitors)
			throws NoCompetitorException, CompetitorQuantityException, RanksException;

	/**
	 * This allows you to increase the number of laps of a competition
	 */
	public abstract void incrementNbround();

	/**
	 * This method allows the display of a competition
	 */
	public abstract String toString();

	public void notifyAllObservers() {

		for (Speakers speakObserver : speakObservers) {
			speakObserver.reactToCompetition(this, this.match);
		}
	}
}
