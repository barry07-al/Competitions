package rule;

import java.util.ArrayList;
import java.util.Map;

import competitor.CompetitorInterface;
import exception.CompetitorQuantityException;
import exception.RanksException;

/**
 * @author amevigbe
 *
 */
public interface Rule {

	/**
	 * method which returns the list of competitors selected for the second round
	 * 
	 * @return (ArrayList<CompetitorInterface>) the list of competitors selected
	 */
	public ArrayList<CompetitorInterface> getCompetitors();

	/**
	 * method which returns the list of competitors selected for the second round
	 * 
	 * @param ranks the list of the ranks of each pool played in the first round
	 * @return (ArrayList<CompetitorInterface>) the list of competitors selected
	 * @throws RanksException
	 */
	public ArrayList<CompetitorInterface> OrganizeWhoParticipateTournament(
			ArrayList<Map<CompetitorInterface, Integer>> ranks) throws RanksException;

	public boolean getPossible(ArrayList<CompetitorInterface> competitors, int Nb_of_Group)
			throws CompetitorQuantityException;

	public String toString();

}