package wonderland.alice.component.card.character;

import wonderland.alice.scoring.CardStrategyVisitor;
import wonderland.alice.scoring.ScoringStrategy;

public class FrogPrince extends Character {
    @Override
    public ScoringStrategy accept(CardStrategyVisitor visitor) {
        return visitor.visit(this);
    }
}
