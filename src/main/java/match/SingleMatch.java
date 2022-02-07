package match;

import java.util.*;

import competitor.*;
import util.RandomU;

public class SingleMatch extends Match {

	/**
	 * the constructor
	 */
	public SingleMatch() {
		super();
	}

	@Override
	public void play(CompetitorInterface c1, CompetitorInterface c2) {
		int i;
		ArrayList<CompetitorInterface> competitors = new ArrayList<CompetitorInterface>();
		competitors.add(c1);
		competitors.add(c2);
		RandomU random = new RandomU();
		i = random.nbreAlea(2);
		if (c1.equals(competitors.get(i))) {
			c1.addPoints(1);
			this.setCompetitorNotWin(c2);
		} else {
			c2.addPoints(1);
			this.setCompetitorNotWin(c1);
		}

		this.winner = competitors.get(i);
	}

}
