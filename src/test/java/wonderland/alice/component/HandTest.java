package wonderland.alice.component;

import org.junit.Test;
import wonderland.alice.component.card.character.BabyBear;
import wonderland.alice.component.card.character.PapaBear;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HandTest {


    @Test
    public void testEquality() {
        final Hand hand1 = new Hand(List.of(new BabyBear(), new PapaBear()));
        final Hand hand2 = new Hand(List.of(new PapaBear(), new BabyBear()));
        assertEquals(hand1, hand2);
    }

}
