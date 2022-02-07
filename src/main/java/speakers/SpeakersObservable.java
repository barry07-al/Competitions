package speakers;

import java.util.Collection;
import java.util.HashSet;

import match.Match;

public abstract class SpeakersObservable {

	public Collection<Speakers> speakObservers = new HashSet<Speakers>();

	// Attribute that represents the type of match for competition
	protected Match match;

	public SpeakersObservable() {
	}

	/**
	 * This method allows you to record an Observer
	 * 
	 * @param observer
	 */
	public void register(Speakers observer) {
		speakObservers.add(observer);
	}

	/**
	 * This method allows you to delete an Observer
	 * 
	 * @param observer
	 */
	public void unRegister(Speakers observer) {
		speakObservers.remove(observer);
	}

	/**
	 * This method allows you to notify all Observer
	 */
	public abstract void notifyAllObservers();

}
