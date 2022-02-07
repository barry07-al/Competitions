package match;

import competitor.*;
import speakers.*;

/**
 * @author BARRY Alpha Oumar
 *
 */
public interface Matches {

	/**
	 * method allowing to know the competitor1 of a match
	 * 
	 * @return (Competitor) the competitor1
	 */
	public CompetitorInterface getCompetitor1();

	/**
	 * method allowing to know the competitor2 of a match
	 * 
	 * @return (Competitor) the competitor2
	 */
	public CompetitorInterface getCompetitor2();

	/**
	 * method allowing to know the winner of a match
	 * 
	 * @return (Competitor) the winner
	 */
	public CompetitorInterface getWinner();

	/**
	 * method allowing to know the competitor that not win the match
	 * 
	 * @return
	 */
	public CompetitorInterface getCompetitorNotWin();

	/**
	 * method allowing to modify a competitor
	 * 
	 * @param c : the competitor
	 */
	public void setWinner(CompetitorInterface c);

	/**
	 * method allowing to replace the competitor c1 by the competitor c
	 * 
	 * @param c  : the competitor
	 * @param c1 : the competitor
	 */
	public void replaceCompetitor(CompetitorInterface c, CompetitorInterface c1);

	/**
	 * method allowing us to modify the attribute competitorNotWin
	 * 
	 * @param c: the competitor
	 */
	public void setCompetitorNotWin(CompetitorInterface c);

	/**
	 * method allowing to play a one match
	 * 
	 * 
	 */
	public void play(CompetitorInterface competitorInterface, CompetitorInterface competitor);

	public String toString(CompetitorInterface competitorInterface, CompetitorInterface competitor);

}
