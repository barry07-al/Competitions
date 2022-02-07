package rule;

import java.util.ArrayList;
import java.util.Map;

import competitor.CompetitorInterface;
import exception.CompetitorQuantityException;
import exception.RanksException;

/**
 * @author barry
 *
 */
public class TwoAndTreeWinners implements Rule {

	// Attribute that represent the selected competitors
	private ArrayList<CompetitorInterface> competitors;

	/**
	 * the constructor of the class
	 */
	public TwoAndTreeWinners() {
		this.competitors = new ArrayList<>();
	}

	@Override
	public ArrayList<CompetitorInterface> getCompetitors() {
		return this.competitors;
	}

	@Override
	public ArrayList<CompetitorInterface> OrganizeWhoParticipateTournament(
			ArrayList<Map<CompetitorInterface, Integer>> ranks) throws RanksException {
		if (ranks.size() == 0) {
			throw new RanksException("La liste des rangs est vide");
		} else {

			ArrayList<ArrayList<CompetitorInterface>> tmp = new ArrayList<>();
			CompetitorInterface c1, c2, c3;

			for (Map<CompetitorInterface, Integer> c : ranks) {
				ArrayList<CompetitorInterface> t = new ArrayList<>();
				for (Map.Entry mp : c.entrySet()) {
					t.add((CompetitorInterface) mp.getKey());
				}
				tmp.add(t);
			}

			for (ArrayList<CompetitorInterface> k : tmp) {
				this.competitors.add(k.get(0));
				this.competitors.add(k.get(1));
			}

			c1 = tmp.get(0).get(2);
			c2 = tmp.get(1).get(2);
			c3 = tmp.get(2).get(2);

			if (c1.equals(c1.equalsCompetitorWithPoints(c3)) && c2.equals(c2.equalsCompetitorWithPoints(c3))
					&& (c2.equals(c2.equalsCompetitorWithPoints(c1)) || c1.equals(c1.equalsCompetitorWithPoints(c2)))) {
				this.competitors.add(c1);
				this.competitors.add(c2);
			} else if (c2.equals(c2.equalsCompetitorWithPoints(c1)) && c3.equals(c3.equalsCompetitorWithPoints(c1))
					&& (c3.equals(c3.equalsCompetitorWithPoints(c2)) || c2.equals(c2.equalsCompetitorWithPoints(c3)))) {
				this.competitors.add(c2);
				this.competitors.add(c3);
			} else if (c1.equals(c1.equalsCompetitorWithPoints(c2)) && c3.equals(c3.equalsCompetitorWithPoints(c2))
					&& (c3.equals(c3.equalsCompetitorWithPoints(c1)) || c1.equals(c1.equalsCompetitorWithPoints(c3)))) {
				this.competitors.add(c1);
				this.competitors.add(c3);
			}
			return this.competitors;
		}
	}

	@Override
	public boolean getPossible(ArrayList<CompetitorInterface> competitors, int Nb_of_Group)
			throws CompetitorQuantityException {
		int j = competitors.size() / Nb_of_Group;

		if ((competitors.size() % Nb_of_Group) == 0) {
			if (j > 3) {
				int k = 2 * Nb_of_Group + 2;
				double log = Math.log(k) / Math.log(2);
				double pow = Math.pow(2, Math.round(log));
				return k == pow;
			} else {
				throw new CompetitorQuantityException(
						"Le nombre de compétiteur ou le nombre de groupe ne correspond pas");
			}
		}
		return false;
	}

	public String toString() {
		return "TwoAndTreeFirstWinner";
	}

}
