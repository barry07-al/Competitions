package match;

/**
 * @author amevigbe
 *
 */
public class SingleMatchTest extends MatchTest {

	@Override
	public Match createMatch() {
		return new SingleMatch();
	}

}
