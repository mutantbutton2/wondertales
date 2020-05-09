package wonderland.alice.component.card.character;

import wonderland.alice.scoring.CardStrategyVisitor;
import wonderland.alice.scoring.ScoringStrategy;

public class Princess extends Character {
    @Override
    public ScoringStrategy accept(CardStrategyVisitor visitor) {
        return visitor.visit(this);
    }
}
