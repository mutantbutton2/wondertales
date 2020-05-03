package wonderland.alice.component.deck;

import wonderland.alice.component.card.character.Character;
import wonderland.alice.component.card.character.*;
import wonderland.alice.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Draw implements Deck {

    private final Character character;
    private final Deck nextDeck;

    public Draw(Character character, Deck nextDeck) {
        this.character = character;
        this.nextDeck = nextDeck;
    }

    @Override
    public Pair<Character, Deck> pop() {
        return new Pair<>(character, nextDeck);
    }

    public static Deck createDeck() {
        return new DeckBuilder()
                .addCard(new BabyBear())
                .addCard(new BigBadWolf())
                .addCard(new FrogPrince())
                .addCard(new Goldilocks())
                .addCard(new Grandma())
                .addCard(new Gretel())
                .addCard(new Hansel())
                .addCard(new LittlePig())
                .addCard(new LittlePig())
                .addCard(new LittlePig())
                .addCard(new LittleRedRidingHood())
                .addCard(new MamaBear())
                .addCard(new PapaBear())
                .addCard(new Princess())
                .addCard(new Stepmother())
                .addCard(new Witch())
                .addCard(new Woodcutter())
                .build();
    }
}
