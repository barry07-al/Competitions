/**
 * 
 */
package rule;

import java.util.ArrayList;
import java.util.Map;

import competitor.CompetitorInterface;
import exception.CompetitorQuantityException;
import exception.RanksException;

/**
 * @author amevigbe
 */
public class TwoFirstWinner implements Rule {

	// attribute that represents
	protected ArrayList<CompetitorInterface> competitors;

	/**
	 * the constructor
	 */
	public TwoFirstWinner() {
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
			return this.competitors;
		}
	}

	@Override
	public boolean getPossible(ArrayList<CompetitorInterface> competitors, int Nb_of_Group)
			throws CompetitorQuantityException {

		int j = competitors.size() / Nb_of_Group;

		if ((competitors.size() % Nb_of_Group) == 0) {
			if (j > 2) {
				int k = 2 * Nb_of_Group;
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
		return "TwoFirstWinner";
	}

}