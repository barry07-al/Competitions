package speakers;

import Competition.*;
import match.Matches;

public interface Speakers {
	// docs of speakers
	/**
	 * This method allows you to react to competition
	 * 
	 * @param competition
	 * @param matchs
	 */
	public void reactToCompetition(Competition competition, Matches matchs);

	/**
	 * @param name the name of journalist or bookmakers
	 */
	public void setName(String name);

	public String getName();

}
