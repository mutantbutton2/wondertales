package wonderland.alice.scoring.strategy;

import wonderland.alice.component.card.character.*;
import wonderland.alice.component.card.character.Character;
import wonderland.alice.matcher.CardMatcher;
import wonderland.alice.scoring.Node;
import wonderland.alice.scoring.ScoringStrategy;

import java.util.Set;

import static wonderland.alice.matcher.character.OneOfCharacters.oneOf;
import static wonderland.alice.matcher.colour.AnyColour.anyColour;

public class BabyBearScoringStrategy implements ScoringStrategy {

    private static final Set<Character> characterSet = Set.of(new BabyBear(), new PapaBear(), new MamaBear());

    @Override
    public int execute(Node node) {
        return allBearsConnected(node) ? 5 : 0;
    }

    private boolean allBearsConnected(Node node) {
        return node.furthest(new CardMatcher(oneOf(characterSet), anyColour())) == 3;
    }
}
