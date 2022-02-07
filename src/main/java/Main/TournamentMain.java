package Main;

import java.util.ArrayList;

import Competition.*;
import competitor.CompetitorInterface;
import exception.CompetitorQuantityException;
import exception.NoCompetitorException;
import exception.RanksException;
import match.SingleMatch;
import speakers.BookMaker;
import speakers.MatchBookmaker;
import speakers.MatchSpeaker;
import speakers.Speaker;
import util.*;

public class TournamentMain {

	/**
	 * the main method that play competition tournament
	 * @param args
	 * @throws NoCompetitorException
	 * @throws CompetitorQuantityException
	 */
	public static void main(String[] args) throws NoCompetitorException, CompetitorQuantityException, RanksException {
		if (args.length == 0) {
			StdDisplay.displayMsg("Veuillez donner en argument le nombre de compétiteurs qui est une puisance de 2\n");
		}
		else {
			makerListCompetitor competitors = new makerListCompetitor();
			ArrayList<CompetitorInterface> c = competitors.getCompetitor(Integer.parseInt(args[0]));
            SingleMatch match = new SingleMatch();
            match.register(new MatchSpeaker());
			Tournament tournament = new Tournament(c, match);
			
            BookMaker bookmaker = new BookMaker(tournament, "bookmaker");
            MatchBookmaker ma = new MatchBookmaker(bookmaker);
            match.register(ma);
			tournament.register(new Speaker("BBC"));
            tournament.register(bookmaker);
            StdDisplay.displayMsgnotLine("\n");
		    TournamentMain.playAndPrint(c, tournament);
            tournament.notifyAllObservers();
		}
	}


    public static void playAndPrint(ArrayList<CompetitorInterface> competitor, Competition competition) throws CompetitorQuantityException, NoCompetitorException, RanksException{
        competition.play(competitor);
    }
}
