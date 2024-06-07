package school.hei;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import school.hei.Composition.Composition;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Affirmation {
    private String phrase;
    private Status status;
    private Composition composition;


    public Affirmation(String phrase) {
        this.phrase = phrase;
    }

    public Affirmation(String phrase, Status status) {
        this.phrase = phrase;
        this.status = status;
    }

    public Affirmation(Composition composition) {
        this.composition = composition;
    }

    public String vraiOuFaux() {
        if (composition == null) {
            if (status == Status.VERITE) {
                return "vrai";
            }
            if (status == Status.MENSONGE) {
                return "faux";
            }
            return "je ne sais pas";
        }
        return composition.vraiOuFaux();
    }
}
