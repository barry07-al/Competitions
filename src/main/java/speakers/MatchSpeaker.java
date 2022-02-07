package speakers;

import match.Matches;
import util.StdDisplay;
import util.*;

public class MatchSpeaker implements MatchObserver {

	@Override
	public void reactToMatch(Matches match) {

		String msg = "";
		msg += Colors.BLUE_BOLD + match.getWinner() + Colors.RESET + " vs  " + Colors.RED_BOLD
				+ match.getCompetitorNotWin() + Colors.RESET + " --> " + Colors.BLUE_BOLD + match.getWinner()
				+ Colors.RESET;
		StdDisplay.displayMsg(msg);
	}

}
