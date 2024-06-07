package school.hei.Composition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import school.hei.Affirmation;

import java.util.List;

@Getter
@AllArgsConstructor
public sealed abstract class Composition permits
        CompositionEnEt, CompositionEnOu, CompositionEnDonc {
    private final List<Affirmation> affirmations;

    public abstract String vraiOuFaux();
}
