package school.hei;

import org.junit.jupiter.api.Test;
import school.hei.Composition.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AffirmationTest {
    @Test
    void vraiOuFauxAffirmationUniqueTest(){
        var beau = new Affirmation("Lou est beau", Status.VERITE);
        var pauvre = new Affirmation("Lou est pauvre", Status.MENSONGE);
        var genereux = new Affirmation("Lou est généreux");

        assertEquals("vrai",beau.vraiOuFaux());
        assertEquals("faux",pauvre.vraiOuFaux());
        assertEquals("je ne sais pas",genereux.vraiOuFaux());
    }

    @Test
    void vraiOuFauxCompositionAffirmationTest(){
        var beau = new Affirmation("Lou est beau", Status.VERITE);
        var pauvre = new Affirmation("Lou est pauvre", Status.MENSONGE);
        var genereux = new Affirmation("Lou est généreux");

        //Composition de deux affirmations
        var pauvreEtGenereux = new Affirmation(
                new CompositionEnEt(List.of(pauvre, genereux))
        );

        var beauDoncPauvre = new Affirmation(
                new CompositionEnDonc(List.of(beau, pauvre))
        );

        var pauvreDoncGenereux = new Affirmation(
                new CompositionEnDonc(List.of(pauvre, genereux))
        );

        assertEquals("faux",pauvreEtGenereux.vraiOuFaux());
        assertEquals("faux",beauDoncPauvre.vraiOuFaux());
        assertEquals("vrai",pauvreDoncGenereux.vraiOuFaux());

        //Composition plus de deux
        var beauOuGenereux = new Affirmation(
                new CompositionEnOu(List.of(beau, genereux))
        );
        var beauOuGenereuxDoncPauvre = new Affirmation(
                new CompositionEnDonc(List.of(beauOuGenereux, pauvre))
        );


        var pauvreOuGenereux = new Affirmation(
                new CompositionEnOu(List.of(pauvre, genereux))
        );
        var beauOuGenereuxDoncPauvreEtPauvreOuGenereux = new Affirmation(
                new CompositionEnEt(List.of(beauOuGenereuxDoncPauvre, pauvreOuGenereux))
        );

        assertEquals("faux",beauOuGenereuxDoncPauvre.vraiOuFaux());
        assertEquals("faux",beauOuGenereuxDoncPauvreEtPauvreOuGenereux.vraiOuFaux());
    }
}
