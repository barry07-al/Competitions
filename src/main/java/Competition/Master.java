/**
 * 
 */
package Competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import competitor.CompetitorInterface;
import exception.CompetitorQuantityException;
import exception.NoCompetitorException;
import exception.RanksException;
import match.Match;
import rule.Rule;
import util.StdDisplay;

/**
 * @author amevigbe
 *
 */
public class Master extends Competition {

	private int Nb_Round = 0;

	// attribute that represents the poule of competion
	private ArrayList<ArrayList<CompetitorInterface>> poules;

	// attribute that represents the competitor that play the second round
	private ArrayList<CompetitorInterface> tournois;

	// attribute thet represents the number of competitors
	private int Nb_of_Group;

	// attribute that represents the ranks of poules
	private ArrayList<Map<CompetitorInterface, Integer>> ranksOfpoules;

	// attribute that represents the type of selection
	private Rule rule;

	// attribute that represents the tournament
	private Tournament t;

	/**
	 * the constructor
	 * 
	 * @param competitors (ArrayList<CompetitorInterface>) the list of competitors
	 * @param rule        (Rule) the type of selection
	 * @param Nb_of_Group (Integer) the number of competitors
	 * @param match       (Matches) the type match
	 */
	public Master(ArrayList<CompetitorInterface> competitors, Rule rule, int Nb_of_Group, Match match) {
		super(competitors);
		this.rule = rule;
		this.Nb_of_Group = Nb_of_Group;
		this.poules = new ArrayList<>();
		this.ranksOfpoules = new ArrayList<>();
		this.match = match;
	}

	@Override
	public void consequences() {
		this.t.consequences();
	}

	/**
	 * the method that organize the poule of master competition
	 */
	public void organizePoules() {
		int i = 0;
		int nb = (this.competitors.size() / this.Nb_of_Group);
		ArrayList<CompetitorInterface> tmp;
		while (i < this.Nb_of_Group) {
			tmp = new ArrayList<>();
			int j = i * nb;
			while (j < (i * nb + nb)) {

				tmp.add(this.competitors.get(j));
				j++;
			}
			i++;
			this.poules.add(tmp);
		}
	}

	/**
	 * the method that playing the first round of master competition
	 * 
	 * @param poules the list of poules
	 * @param match  (Matches) the type of match
	 * @throws NoCompetitorException
	 */
	public void playPoule(ArrayList<ArrayList<CompetitorInterface>> poules, Match match) throws NoCompetitorException {
		for (ArrayList<CompetitorInterface> p : poules) {
			League l = new League(p, match);
			StdDisplay.displayMsg("***************Affichage d'une poule****************\n");
			System.out.println(p);
			l.play(p);
			this.ranksOfpoules.add(l.getRanks());
		}
	}

	/**
	 * the method that organize the tournament
	 * 
	 * @throws RanksException
	 */
	public void organizeTournament() throws RanksException {
		this.tournois = this.rule.OrganizeWhoParticipateTournament(this.ranksOfpoules);
	}

	@Override
	public boolean isFinish() {
		return this.winner != null;
	}

	@Override
	public boolean getPossibility() {
		boolean tmp = this.competitors.size() != 0;
		if (this.t != null) {
			return this.t.getPossibility();
		}
		return tmp;
	}

	@Override
	public void play(ArrayList<CompetitorInterface> competitors)
			throws NoCompetitorException, CompetitorQuantityException, RanksException {
		StdDisplay.displayMsg("***************play Master **************\n");
		this.organizePoules();
		this.playPoule(this.poules, this.match);
		this.organizeTournament();
		StdDisplay.displayMsg("****Voici les joueurs qualifiés pour la phase finale****\n");
		System.out.println(this.tournois);
		StdDisplay.displayMsg("");
		StdDisplay.displayMsg("");
		this.playTournament(this.tournois, match);
		StdDisplay.displayMsg("***************Fin du Master**********************");
	}

	@Override
	public void incrementNbround() {
		this.Nb_Round++;
	}

	/**
	 * the method which plays a tournament between the competitors of the list
	 * passed in parameter
	 * 
	 * @param tournois ArrayList<CompetitorInterface> the list of competitors who
	 *                 must play the tournament
	 * @param match    (Matches) the type of match
	 * @throws NoCompetitorException
	 * @throws CompetitorQuantityException
	 */
	public void playTournament(ArrayList<CompetitorInterface> tournois, Match match)
			throws NoCompetitorException, CompetitorQuantityException {
		this.t = new Tournament(tournois, match);
		this.t.play(tournois);
		this.ranks = this.t.getRanks();
	}

	@Override
	public String toString() {

		String msg = "******************** Jeu Tournois ***********";
		return msg;
	}

}
