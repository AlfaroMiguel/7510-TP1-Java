package ar.uba.fi.tdd.rulogic.model;

public class Fact {
    private String reprFact;

    public Fact (String fact){
        this.reprFact = fact;
    }

    public boolean equals(Object otherFact){
        if(otherFact instanceof Fact){
            Fact toCompare = (Fact) otherFact;
            return this.reprFact.equals(toCompare.reprFact);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return reprFact.hashCode();
    }

    public static boolean isFact (String reprFact){
        return reprFact.matches("\\w+\\(\\w+(,\\w+)*\\).");
    }
}
