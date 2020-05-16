package wonderland.alice.scoring;

import wonderland.alice.component.card.character.*;
import wonderland.alice.scoring.strategy.*;

public class CardStrategyVisitor {

    public ScoringStrategy visit(BabyBear babyBear) {
        return new BabyBearScoringStrategy();
    }

    public ScoringStrategy visit(BigBadWolf bigBadWolf) {
        return new BigBadWolfScoringStrategy();
    }

    public ScoringStrategy visit(FrogPrince frogPrince) {
        return new FrogPrinceScoringStrategy();
    }

    public ScoringStrategy visit(Goldilocks goldilocks) {
        return new GoldilocksScoringStrategy();
    }

    public ScoringStrategy visit(Grandma grandma) {
        return new GrandmaScoringStrategy();
    }

    public ScoringStrategy visit(Gretel gretel) {
        return new GretelScoringStrategy();
    }

    public ScoringStrategy visit(Hansel hansel) {
        return new HanselScoringStrategy();
    }

    public ScoringStrategy visit(LittlePigOne littlePigOne) {
        return new LittlePigOneScoringStrategy();
    }

    public ScoringStrategy visit(LittlePigTwo littlePigTwo) {
        return new LittlePigTwoScoringStrategy();
    }

    public ScoringStrategy visit(LittlePigThree littlePigThree) {
        return new LittlePigThreeScoringStrategy();
    }

    public ScoringStrategy visit(LittleRedRidingHood littleRedRidingHood) {
        return new LittleRedRidingHoodScoringStrategy();
    }

    public ScoringStrategy visit(MamaBear mamaBear) {
        return new MamaBearScoringStrategy();
    }

    public ScoringStrategy visit(PapaBear papaBear) {
        return new PapaBearScoringStrategy();
    }

    public ScoringStrategy visit(Princess princess) {
        return new PrincessScoringStrategy();
    }

    public ScoringStrategy visit(Stepmother stepmother) {
        return new EmptyScoringStrategy();
    }

    public ScoringStrategy visit(Witch witch) {
        return new EmptyScoringStrategy();
    }

    public ScoringStrategy visit(Woodcutter woodcutter) {
        return new WoodcutterScoringStrategy();
    }

    public ScoringStrategy visit(Empty empty) {
        return new EmptyScoringStrategy();
    }

}
