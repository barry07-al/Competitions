package speakers;

import competitor.CompetitorInterface;
import match.*;
import util.Colors;
import util.StdDisplay;

public class MatchBookmaker implements MatchObserver {

	private BookMaker bookmaker;

	public MatchBookmaker(BookMaker bookmaker) {
		this.bookmaker = bookmaker;

	}

	@Override
	public void reactToMatch(Matches match) {
		String msg = "";
		CompetitorInterface winner = match.getWinner();
		CompetitorInterface loser = match.getCompetitorNotWin();
		if (this.bookmaker.getCompetitorOdds().get(winner) > 1) {
			this.bookmaker.getCompetitorOdds().put(winner, this.bookmaker.getCompetitorOdds().get(winner) - 1);
		}

		this.bookmaker.getCompetitorOdds().put(loser, this.bookmaker.getCompetitorOdds().get(loser) + 1);

		msg += Colors.BLUE_BOLD + winner + "(Odds :" + this.bookmaker.getCompetitorOdds().get(winner) + ")"
				+ Colors.RESET + " vs  " + Colors.RED_BOLD + match.getCompetitorNotWin() + "(Odds :"
				+ this.bookmaker.getCompetitorOdds().get(loser) + ")" + Colors.RESET;
		StdDisplay.displayMsg(msg);
	}

}
