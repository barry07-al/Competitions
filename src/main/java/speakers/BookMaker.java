package speakers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Competition.Competition;
import competitor.*;
import match.Matches;
import rule.*;
import util.Colors;
import util.StdDisplay;

public class BookMaker implements Speakers {
	/**
	 * BookMaker Class
	 */

	// CompetitorOdds Attribute
	private Map<CompetitorInterface, Integer> competitorOdds;
	// Attribute that represents the type of Competition
	private Competition competition;
	// Attribute that represents the type of name for BookMaakers
	//
	private String name;

	public BookMaker(Competition competition, String name) {
		this.competitorOdds = new HashMap<>();
		this.competition = competition;
		for (CompetitorInterface c : this.competition.getCompetitor()) {
			this.competitorOdds.put(c, 1);

		}
		this.name = name;

	}

	@Override
	public void reactToCompetition(Competition competition, Matches match) {

		String msg = Colors.YELLOW_BOLD + this.getName() + Colors.RESET + "\n";
		String SndMsg = "";
		msg += "** Odds **\n";

		for (Entry<CompetitorInterface, Integer> entry : this.getCompetitorOdds().entrySet()) {
			SndMsg += entry.getKey() + " ---> " + entry.getValue() + "\n";
		}
		StdDisplay.displayMsg(msg += SndMsg);
	}

	/**
	 * setter of competitorsOdds
	 * 
	 * @param competitorOdds
	 */
	public void setCompetitorOdds(Map<CompetitorInterface, Integer> competitorOdds) {
		this.competitorOdds = competitorOdds;
	}

	/**
	 * getter of competitorsOdds
	 * 
	 * @return competitorOdds
	 */
	public Map<CompetitorInterface, Integer> getCompetitorOdds() {
		return competitorOdds;
	}

	/**
	 * setter of Name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter of name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
}
