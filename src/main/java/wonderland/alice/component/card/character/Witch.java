package wonderland.alice.component.card.character;

import wonderland.alice.scoring.CardStrategyVisitor;
import wonderland.alice.scoring.ScoringStrategy;

public class Witch extends Character {
    @Override
    public ScoringStrategy accept(CardStrategyVisitor visitor) {
        return visitor.visit(this);
    }
}
