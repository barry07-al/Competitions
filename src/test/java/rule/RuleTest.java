/**
 * 
 */
package rule;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import competitor.Competitor;
import competitor.CompetitorInterface;
import exception.*;

/**
 * @author amevigbe
 *
 */
public abstract class RuleTest {

	private Rule rule;
	private ArrayList<Map<CompetitorInterface, Integer>> ranks;
	private CompetitorInterface comp1;

	/**
	 * 
	 */
	@BeforeEach
	void before() {
		this.rule = this.createRule();
		int i = 0;
		this.ranks = new ArrayList<>();
		int j = 0;
		for (j = 0; j < 5; j++) {
			Map<CompetitorInterface, Integer> t = new HashMap<>();
			for (i = 0; i < 5; i++) {
				this.comp1 = new Competitor("a" + i + j, 0);
				t.put(this.comp1, i + j);
			}
			this.ranks.add(t);
		}
		System.out.println(this.rule);

	}

	@Test
	public void testOrganizeWhoParticipateTournamentOk() throws RanksException {

		ArrayList<CompetitorInterface> participants = this.rule.OrganizeWhoParticipateTournament(this.ranks);

		assertNotNull(participants);
		assertNotEquals(participants.size(), 0);

	}

	@Test
	public void testOrganizeWhoParticipateTournamentNOk() {
		this.ranks = new ArrayList<>();
		assertThrows(RanksException.class, () -> {
			ArrayList<CompetitorInterface> participants = this.rule.OrganizeWhoParticipateTournament(this.ranks);
		});

	}

	public abstract Rule createRule();
}
