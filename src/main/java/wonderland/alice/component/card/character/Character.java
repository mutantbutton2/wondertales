package wonderland.alice.component.card.character;

import wonderland.alice.scoring.CardStrategyVisitor;
import wonderland.alice.scoring.ScoringStrategy;

public abstract class Character {

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

    public abstract ScoringStrategy accept(CardStrategyVisitor visitor);

    @Override
    public int hashCode() {
        //TODO: Wow what's this mate
        return -1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
