package util;

import java.util.ArrayList;
import java.util.Map;

import competitor.CompetitorInterface;
import exception.NoCompetitorException;

/**
 * @author amevigbe
 *
 */
public class adderForLeague implements adderMatch {

	// attribute matchs
	protected Map<CompetitorInterface, ArrayList<CompetitorInterface>> matchs;

	/**
	 * the constructor
	 * 
	 * @param matchs (Map) the map of match
	 */
	public adderForLeague(Map<CompetitorInterface, ArrayList<CompetitorInterface>> matchs) {
		this.matchs = matchs;
	}

	@Override
	public void addMatch(CompetitorInterface c, ArrayList<CompetitorInterface> competitors)
			throws NoCompetitorException {
		if (!competitors.contains(c)) {
			throw new NoCompetitorException();
		}
		ArrayList<CompetitorInterface> co = new ArrayList<>();
		for (CompetitorInterface competitor : competitors) {
			if (!c.equals(competitor)) {
				co.add(competitor);
			}
		}
		this.matchs.put(c, co);
	}

	@Override
	public Map<CompetitorInterface, ArrayList<CompetitorInterface>> addAllMatch(
			ArrayList<CompetitorInterface> competitors) throws NoCompetitorException {
		for (CompetitorInterface c : competitors) {
			this.addMatch(c, competitors);
		}
		return this.matchs;
	}

}