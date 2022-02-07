package speakers;

import match.Matches;

/**
 * Doc of MatchObserver class
 */
public interface MatchObserver {

	/**
	 * This method of reacting to a game played
	 * 
	 * @param matchs
	 */
	public void reactToMatch(Matches matchs);

}
