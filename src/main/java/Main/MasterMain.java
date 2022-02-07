/**
 * 
 */
package Main;

import java.util.ArrayList;

import Competition.*;
import competitor.CompetitorInterface;
import exception.CompetitorQuantityException;
import exception.NoCompetitorException;
import exception.RanksException;
import match.SingleMatch;
import rule.Rule;
import rule.TwoAndTreeWinners;
import rule.TwoFirstWinner;
import speakers.BookMaker;
import speakers.MatchBookmaker;
import speakers.MatchSpeaker;
import speakers.Speaker;
import util.StdDisplay;
import util.makerListCompetitor;

/**
 * @author amevigbe
 *
 */
public class MasterMain {

	/**
	 * the method main that play competition master
	 * 
	 * @param args
	 * @throws CompetitorQuantityException
	 * @throws NoCompetitorException
	 * @throws RanksException
	 */
	public static void main(String[] args) throws NoCompetitorException, CompetitorQuantityException, RanksException {
		makerListCompetitor competitors = new makerListCompetitor();
		if (args.length == 0) {
			StdDisplay.displayMsg("Veuillez donner en argument le nombre de compétiteurs\n");
		}

		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		ArrayList<CompetitorInterface> c = competitors.getCompetitor(i);
		Rule rule = new TwoFirstWinner();
		if (rule.getPossible(c, j)) {
            SingleMatch match = new SingleMatch();
            match.register(new MatchSpeaker());
			Master master = new Master(c, rule, j, match);
            BookMaker bookmaker = new BookMaker(master, "bookmaker");
            MatchBookmaker ma = new MatchBookmaker(bookmaker);
            match.register(ma);
			master.register(new Speaker("BBC"));
            master.register(bookmaker);
            StdDisplay.displayMsgnotLine("\n");
			MasterMain.playAndPrint(c, master);
            master.notifyAllObservers();
		} else {
			System.out.println("Veuillez rééxécuter le programme et entrer des bonnes valeurs");
		}

	}

    
    public static void playAndPrint(ArrayList<CompetitorInterface> competitor, Competition competition) throws CompetitorQuantityException, NoCompetitorException, RanksException{
        competition.play(competitor);
    }


}
