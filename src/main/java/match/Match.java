package match;

import java.util.Collection;
import java.util.HashSet;

import competitor.*;
import speakers.*;

public abstract class Match extends MatchsObservable implements Matches {

	// Attribute that represents a competitor1
	protected CompetitorInterface c1;

	// Attribute that represents a competitor1
	protected CompetitorInterface c2;

	// Attribute that represents a winner of the match
	protected CompetitorInterface winner;

	// Attribute that represents a competitor that not win.
	protected CompetitorInterface competitorNotWin;

	/**
	 * the constructor which takes the type of match as a parameter
	 */
	public Match() {
		super();
		this.winner = null;
	}

	@Override
	public CompetitorInterface getCompetitor1() {
		return this.c1;
	}

	@Override
	public CompetitorInterface getCompetitor2() {
		return this.c2;
	}

	@Override
	public CompetitorInterface getWinner() {
		return this.winner;
	}

	@Override
	public void setWinner(CompetitorInterface c) {
		this.winner = c;
	}

	@Override
	public CompetitorInterface getCompetitorNotWin() {
		return this.competitorNotWin;
	}

	@Override
	public void setCompetitorNotWin(CompetitorInterface c) {
		this.competitorNotWin = c;
	}

	public void notifyAllObservers() {
		for (MatchObserver matchObserver : this.matchObservers) {
			matchObserver.reactToMatch(this);
		}
	}

	@Override
	public void replaceCompetitor(CompetitorInterface c, CompetitorInterface c1) {
		c1 = c;
	}

	@Override
	public String toString(CompetitorInterface c1, CompetitorInterface c2) {
		return c1.toString() + " vs " + c2.toString() + " --> " + this.getWinner() + " wins";
	}

	@Override
	public abstract void play(CompetitorInterface c1, CompetitorInterface c2);
}
