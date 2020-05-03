package wonderland.alice.component.strategy;

import wonderland.alice.component.Hand;
import wonderland.alice.component.Location;
import wonderland.alice.State;

public class FirstCardStrategy implements Strategy {

    private final State state;

    public FirstCardStrategy(State state) {
        this.state = state;
    }

    @Override
    public Play execute() {
        final Hand hand = state.currentHand();
        return new Play(hand.firstCard(), nextAvailableLocation());
    }

    private Location nextAvailableLocation() {
        for (int row = 0; row < state.getBoard().getRowCount(); row++) {
            for (int column = 0; column < state.getBoard().getColumnCount(); column++) {
                if (state.getBoard().isAvailable(row, column)) {
                    return new Location(row, column);
                }
            }
        }
        return new Location(0, 0);
    }

}
