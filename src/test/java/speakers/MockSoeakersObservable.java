package speakers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Competition.League;
import competitor.Competitor;
import competitor.CompetitorInterface;

class MockSpeakersObservable extends SpeakersObservable {
	
	
	@BeforeEach
	void before() {
		speakObservers.add(new Speaker("BARRY")) ;	
	}
	
	@Test
	public void registerTest() {
		ArrayList<CompetitorInterface> c = new ArrayList<>();
		assertEquals(speakObservers.size(), 1) ;
		this.register(new Speaker("Yao"));
		this.register(new Speaker("Barry"));
		this.register(new Speaker("Hichem"));
		this.register(new BookMaker(new League(c, match), "bookmaker"));
		assertNotEquals(this.speakObservers.size(), 2) ;
	}
	
	
	@Test
	public void unRegisterTest() {
		assertEquals(speakObservers.size(), 1) ;
		this.unRegister(new Speaker("BARRY"));
		assertEquals(speakObservers.size(),1) ;
	}
	
	@Override
	public void notifyAllObservers() {}

}
