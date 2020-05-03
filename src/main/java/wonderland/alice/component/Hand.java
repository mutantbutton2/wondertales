package wonderland.alice.component;

import wonderland.alice.component.card.character.Character;

import java.util.*;

import static java.util.Collections.emptyList;

public class Hand {

    private final List<Character> cards;

    public static Hand emptyHand() {
        return new Hand(emptyList());
    }

    public Hand(List<Character> cards) {
        this.cards = cards;
    }

    public Hand add(Character character) {
        List<Character> newCards = cloneCards();
        newCards.add(character);
        return new Hand(newCards);
    }

    public Hand use(Character character) {
        List<Character> newCards = cloneCards();
        newCards.remove(character);
        return new Hand(newCards);
    }

    public Character firstCard() {
        return cards.get(0);
    }

    private List<Character> cloneCards() {
        List<Character> newCards = new ArrayList<>(cards.size());
        newCards.addAll(cards);
        return newCards;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return new HashSet<>(cards).equals(new HashSet<>(hand.cards));
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}
