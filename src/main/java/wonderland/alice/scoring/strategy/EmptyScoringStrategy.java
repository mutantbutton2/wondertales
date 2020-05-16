package wonderland.alice.scoring.strategy;

import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

public class EmptyScoringStrategy implements ScoringStrategy {

    @Override
    public int execute(Node node) {
        return 0;
    }
}
