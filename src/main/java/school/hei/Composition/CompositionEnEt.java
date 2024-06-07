package school.hei.Composition;

import lombok.Getter;
import school.hei.Affirmation;

import java.util.List;

@Getter
public final class CompositionEnEt extends Composition {

    public CompositionEnEt(List<Affirmation> affirmations) {
        super(affirmations);
    }

    @Override
    public String vraiOuFaux() {
        if (!getAffirmations().get(0).vraiOuFaux().equals("vrai") ||
                !getAffirmations().get(1).vraiOuFaux().equals("vrai")) {
            return "faux";
        }
        return "vrai";
    }
}
