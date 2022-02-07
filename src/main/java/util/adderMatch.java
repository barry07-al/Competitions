/**
 * 
 */
package util;

import java.util.ArrayList;
import java.util.Map;

import competitor.CompetitorInterface;
import exception.NoCompetitorException;

/**
 * @author amevigbe
 *
 */
public interface adderMatch {

	/**
	 * This method organizes a match and adds it to the match list
	 * 
	 * @param c The competitor
	 * @param competitors the competitors of Competitions
	 */
	public void addMatch(CompetitorInterface c, ArrayList<CompetitorInterface> competitors)
			throws NoCompetitorException;

	/**
	 * This method adds all matches to the match list
	 * 
	 * @param competitors the competitors of competition
	 * @return (Map) the map of matches
	 * @throws NoCompetitorException
	 */
	public Map<CompetitorInterface, ArrayList<CompetitorInterface>> addAllMatch(
			ArrayList<CompetitorInterface> competitors) throws NoCompetitorException;

}
