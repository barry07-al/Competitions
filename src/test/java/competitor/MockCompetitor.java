/**
 * 
 */
package competitor;

/**
 * @author amevigbe
 *
 */
public class MockCompetitor implements CompetitorInterface {

	private String name;

	private int points;

	public MockCompetitor(String name, int points) {
		this.name = name;
		this.points = points;
	}

	@Override
	public int getPoints() {
		return this.points;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void addPoints(int point) {
		this.points += point;

	}

	@Override
	public void reducePoint(int point) {
		this.points -= point;
	}

	@Override
	public CompetitorInterface equalsCompetitorWithPoints(CompetitorInterface c1) {
		return (this.getPoints() > c1.getPoints()) ? c1 : this ;
	}

}
