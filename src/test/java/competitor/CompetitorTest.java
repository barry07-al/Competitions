package competitor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

/**
 * @author amevigbe
 *
 */
public class CompetitorTest {

	private MockCompetitor competitor;

	private int pointBefore;

	@BeforeEach
	public void before() {
		this.competitor = new MockCompetitor("Drift", 12);
		this.pointBefore = 0;
	}

	@Test
	public void addPointTest() {
		this.pointBefore = competitor.getPoints();
		competitor.addPoints(2 * pointBefore);
		assertEquals(pointBefore + 2 * pointBefore, competitor.getPoints());
	}

	@Test
	public void reducePointTest() {
		this.pointBefore = this.competitor.getPoints();
		this.competitor.reducePoint(this.competitor.getPoints() / 2);
		assertEquals(competitor.getPoints(), pointBefore / 2);
	}

	@Test
	public void setNameTest() {
		String name = competitor.getName();
		competitor.setName("BARRY");
		assertNotEquals(competitor.getName(), name);
	}

}
