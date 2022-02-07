package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import competitor.CompetitorInterface;
import exception.NoCompetitorException;

/**
 * @author amevigbe
 *
 */
public class addMatchForTournament implements adderMatch {

	// protected ArrayList<CompetitorInterface> competitors;
	protected Map<CompetitorInterface, ArrayList<CompetitorInterface>> matchs;

	/**
	 * the constructor
	 * 
	 * @param matchs the matches of competition
	 */
	public addMatchForTournament(Map<CompetitorInterface, ArrayList<CompetitorInterface>> matchs) {
		this.matchs = matchs;
	}

	@Override
	public void addMatch(CompetitorInterface competitor, ArrayList<CompetitorInterface> competitors)
			throws NoCompetitorException {
		if (!competitors.contains(competitor)) {
			throw new NoCompetitorException();
		}
		ArrayList<CompetitorInterface> c = new ArrayList<>();
		ListIterator<CompetitorInterface> li = competitors.listIterator();
		CompetitorInterface co;
		// This part is used to organize the matches of a player and his opponent
		if (li.hasNext()) {
			co = li.next();
			while (!co.equals(competitor)) {
				co = li.next();
			}
			co = li.next();
			c.add(co);
		}
		this.matchs.put(competitor, c);
	}

	@Override
	public Map<CompetitorInterface, ArrayList<CompetitorInterface>> addAllMatch(
			ArrayList<CompetitorInterface> competitors) throws NoCompetitorException {
		if (this.matchs.size() != 0) {
			this.matchs = new HashMap<>();
		}
		ListIterator<CompetitorInterface> li = competitors.listIterator();
		while (li.hasNext() && competitors.size() != 0) {
			this.addMatch(li.next(), competitors);
			if (li.hasNext()) {
				li.next();
			}
		}
		return this.matchs;
	}

}