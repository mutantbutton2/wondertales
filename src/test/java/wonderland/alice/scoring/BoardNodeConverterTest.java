package wonderland.alice.scoring;

import org.junit.Test;
import wonderland.alice.component.card.Card;
import wonderland.alice.component.card.character.*;
import wonderland.alice.matcher.CardMatcher;

import static org.junit.Assert.assertEquals;
import static wonderland.alice.component.card.Colour.BLUE;
import static wonderland.alice.component.card.Colour.RED;
import static wonderland.alice.matcher.colour.IsColour.isColour;

public class BoardNodeConverterTest {

    @Test
    public void test1() {
        final Card[][] board = new Card[][] {
                new Card[]{new Card(RED, new PapaBear()), new Card(RED, new MamaBear())}
        };

        final Slot[][] result = new BoardNodeConverter(board).convert();
        assertEquals(new Card(RED, new PapaBear()), result[0][0].cardNode.card);
        assertEquals(new Card(RED, new MamaBear()), result[0][1].cardNode.card);

        assertEquals(new Card(RED, new MamaBear()), result[0][0].cardNode.right.card);
        assertEquals(new Card(RED, new PapaBear()), result[0][1].cardNode.left.card);
    }

    @Test
    public void test2() {
        final Card[][] board = new Card[][] {
                new Card[]{new Card(RED, new Gretel()), new Card(BLUE, new BabyBear()), new Card(RED, new Witch())}
        };

        final Slot[][] result = new BoardNodeConverter(board).convert();
        assertEquals(new Card(RED, new Gretel()), result[0][0].cardNode.card);
        assertEquals(new Card(BLUE, new BabyBear()), result[0][1].cardNode.card);
        assertEquals(new Card(RED, new Witch()), result[0][2].cardNode.card);

        assertEquals(new Card(BLUE, new BabyBear()), result[0][0].cardNode.right.card);
        assertEquals(new Card(BLUE, new BabyBear()), result[0][2].cardNode.left.card);
        assertEquals(new Card(RED, new Witch()), result[0][0].cardNode.right.right.card);
        assertEquals(new Card(RED, new Gretel()), result[0][2].cardNode.left.left.card);
    }

}
