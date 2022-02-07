package rule;

/**
 * @author barry
 *
 */
public class TwoFirstWinnerTest extends RuleTest {

	@Override
	public Rule createRule() {
		return new TwoFirstWinner();
	}

}
