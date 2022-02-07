package Main;

import java.util.ArrayList;

import Competition.Competition;
import Competition.League;
import competitor.CompetitorInterface;
import exception.*;
import match.SingleMatch;
import speakers.*;
import util.*;

/**
 * @author amevigbe
 *
 */
public class LeagueMain {
    
	/**
	 * the method main that play competition league
	 * @param args
	 * @throws NoCompetitorException
	 */
	public static void main(String[] args) throws NoCompetitorException , CompetitorQuantityException, RanksException{
		if (args.length == 0) {
			StdDisplay.displayMsg("Veuillez donner en argument le nombre de compétiteurs\n");
		}
		else {
			makerListCompetitor competitors = new makerListCompetitor();
			ArrayList<CompetitorInterface> c = competitors.getCompetitor(Integer.parseInt(args[0]));
            SingleMatch m = new SingleMatch();
            m.register(new MatchSpeaker());
			League league = new League(c, m);
            
            BookMaker bookmaker = new BookMaker(league, "bookmaker");
            MatchBookmaker ma = new MatchBookmaker(bookmaker);
            m.register(ma);
            league.register(new Speaker("BBC"));
            league.register(bookmaker);
			StdDisplay.displayMsgnotLine("\n");
            //league.play(c);
            LeagueMain.playAndPrint(c, league);
            league.notifyAllObservers();
		    
			
		}
	}

   /**
    *
    *
    * */ 
    public static void playAndPrint(ArrayList<CompetitorInterface> competitor, Competition competition) throws CompetitorQuantityException, NoCompetitorException, RanksException{
        competition.play(competitor);
    }

}






