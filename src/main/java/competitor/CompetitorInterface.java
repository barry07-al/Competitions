package competitor;

import exception.NoPointException;

/**
 * @author barry
 *
 */
public interface CompetitorInterface {

	/**
	 * method allowing to know the number of points of a competitor
	 * 
	 * @return (int) the number of points
	 */
	public int getPoints();

	/**
	 * method allowing to know the name of a competitor
	 * 
	 * @return (String) the name of competitor
	 */
	public String getName();

	/**
	 * method allowing to modify the name of a competitor
	 * 
	 * @param (String) : the name
	 */
	public void setName(String name);

	/**
	 * method allowing to add a number of points given in parameter to a competitor
	 * 
	 * @param point : (int) the value we will add
	 */
	public void addPoints(int point);

	/**
	 * method allowing to reduce a number of points given in parameter to a
	 * competitor
	 * 
	 * @param point : (int) the number of point
	 * @throws NoPointException
	 */
	public void reducePoint(int point) throws NoPointException;

	/**
	 * method that compare the points of the two competitors
	 * 
	 * @param c1 (CompetitorInterface) the competitor one
	 * @return (CompetitorInterface) the competitor that have a lot points
	 */
	public CompetitorInterface equalsCompetitorWithPoints(CompetitorInterface c1);

	@Override
	public boolean equals(Object o);

	@Override
	public String toString();
}
