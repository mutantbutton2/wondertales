package wonderland.alice.component.card.character;

public abstract class Character {

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

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
