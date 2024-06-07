package school.hei.Composition;

import lombok.Getter;
import school.hei.Affirmation;

import java.util.List;

@Getter
public final class CompositionEnDonc extends Composition {

    public CompositionEnDonc(List<Affirmation> affirmations) {
        super(affirmations);
    }

    @Override
    public String vraiOuFaux() {
        if (getAffirmations().get(0).vraiOuFaux().equals("vrai") ||
                getAffirmations().get(1).vraiOuFaux().equals("faux")) {
            return "faux";
        }
        return "vrai";
    }
}