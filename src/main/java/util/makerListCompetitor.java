package util;

import java.util.ArrayList;
import java.util.Scanner;

import competitor.Competitor;
import competitor.CompetitorInterface;
import util.StdDisplay;

public class makerListCompetitor {

	// attribute competitors
	protected ArrayList<CompetitorInterface> competitor;

	Scanner input;

	/**
	 * the constructor
	 */
	public makerListCompetitor() {
		this.competitor = new ArrayList<>();
		this.input = new Scanner(System.in);
	}

	/**
	 * method that add the number (nb_competitor) in attribute competitors, and
	 * return this.
	 * 
	 * @param nb_competitor the number of competitors
	 * @return list of competitors
	 */
	public ArrayList<CompetitorInterface> getCompetitor(int nb_competitor) {
		int res = 0;
		while (res < nb_competitor) {
			StdDisplay.displayMsgnotLine("Saisissez le nom du compétiteur ");
			String name = this.input.next();
			this.competitor.add(new Competitor(name));
			res++;
		}
		return this.competitor;
	}
}