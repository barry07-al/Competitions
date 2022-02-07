package speakers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import Competition.Competition;
import competitor.*;
import match.Matches;
import rule.*;
import util.Colors;
import util.StdDisplay;

public class Speaker implements Speakers {
	/**
	 * The class of Journalist
	 */

	private String name;

	public Speaker(String name) {
		this.name = name;

	}

	@Override
	public void reactToCompetition(Competition competition, Matches match) {

		String SndMsg = "";
		String msg = Colors.YELLOW_BOLD + this.getName() + Colors.RESET + "\n";
		msg += "** Ranking **\n";

		for (Entry<CompetitorInterface, Integer> entry : competition.getRanks().entrySet()) {
			SndMsg += entry.getKey() + " ---> " + entry.getValue() + "\n";
		}
		StdDisplay.displayMsg(msg += SndMsg);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String otherName) {
		this.name = otherName;
	}
}
