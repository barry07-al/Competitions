package speakers;

import java.util.Collection;
import java.util.HashSet;

import match.Match;

public abstract class MatchsObservable {

	public Collection<MatchObserver> matchObservers = new HashSet<>();

	// Attribute that represents the type of match for competition
	protected Match match;

	public MatchsObservable() {
	}

	/**
	 * This method allows you to add an observer
	 * 
	 * @param observer
	 */

	public void register(MatchObserver observer) {
		matchObservers.add(observer);
	}

	/**
	 * This method allows you to add an observer
	 * 
	 * @param observer
	 */
	public void unRegister(MatchObserver observer) {
		matchObservers.remove(observer);
	}

	/**
	 * This method allows you to notify all observers
	 */
	public abstract void notifyAllObservers();

}
