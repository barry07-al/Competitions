/**
 * 
 */
package match;

import java.util.ArrayList;

import competitor.CompetitorInterface;
import util.RandomU;

/**
 * @author amevigbe
 *
 */
public class MockMatchs extends Match {

	public MockMatchs() {
	}

	@Override
	public void play(CompetitorInterface c1, CompetitorInterface c2) {
		int i, res;
		ArrayList<CompetitorInterface> competitors = new ArrayList<>();
		competitors.add(c1);
		competitors.add(c2);
		RandomU random = new RandomU();
		i = random.nbreAlea(2);
		if (i == 0) {
			res = 1;
		} else {
			res = 0;
		}
		this.winner = competitors.get(i);
		this.setCompetitorNotWin(competitors.get(res));
	}

}
