package school.hei.Composition;

import school.hei.Affirmation;

import java.util.List;

public final class CompositionEnOu extends Composition {

    public CompositionEnOu(List<Affirmation> affirmations) {
        super(affirmations);
    }

    @Override
    public String vraiOuFaux() {
        if (getAffirmations().get(0).vraiOuFaux().equals("vrai") ||
                getAffirmations().get(1).vraiOuFaux().equals("vrai")) {
            return "vrai";
        }
        return "faux";
    }
}
