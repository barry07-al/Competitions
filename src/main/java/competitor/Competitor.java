package competitor;

import exception.NoPointException;

/**
 * @author BARRY Alpha Oumar
 */
public class Competitor implements CompetitorInterface {

	/* Attribute that represents the name of competitor */
	public String name;

	/* Attribute that represents the number points of competitor */
	public int point;

	/**
	 * the constructor
	 * @param name (String) the name of competitor
	*/
	public Competitor(String name) {
		this.name = name;
		this.point = 0;
	}

	/**
	 * The constructor
	 * @param name  (String) the name of competitor
	 * @param point (Int) the number of point the competitor
	*/
	public Competitor(String name, int point) {
		this.name = name;
		this.point = point;
	}

	@Override
	public int getPoints() {
		return this.point;
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
		this.point = this.point + point;
	}

	@Override
	public void reducePoint(int point) throws NoPointException {
		if (this.point - point < 0) {
			throw new NoPointException("Not enough point");
		}
		this.point = this.point - point;
	}
	
	@Override
	public CompetitorInterface equalsCompetitorWithPoints (CompetitorInterface c1) {
		return (this.getPoints() > c1.getPoints()) ? this : c1 ;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Competitor)) {
			return false;
		}
		Competitor other = (Competitor) o;
		return (this.getName() == other.getName()) && (this.getPoints() == other.getPoints());
	}

	@Override
	public String toString() {
		return this.getName();
	}
}