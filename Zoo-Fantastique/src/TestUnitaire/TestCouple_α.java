package TestUnitaire;

import org.junit.jupiter.api.Test;

import MeuteLycanthropes.CategorieAge;
import MeuteLycanthropes.Couple_α;
import MeuteLycanthropes.Lycanthrope;
import MeuteLycanthropes.RangDomination;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class TestCouple_α {

    @Test
    public void testTrouverMaleAlpha() {
        Lycanthrope l1 = new Lycanthrope("Lycan1", 'M', CategorieAge.ADULTE.toString(), RangDomination.BETA);
        Lycanthrope l2 = new Lycanthrope("Lycan2", 'M', CategorieAge.ADULTE.toString(), RangDomination.BETA);
        List<Lycanthrope> meute = Arrays.asList(l1, l2);

        Couple_α couple = new Couple_α();
        Lycanthrope maleAlpha = couple.trouverMaleAlpha(meute);

        assertEquals(l2, maleAlpha);
    }

    @Test
    public void testTrouverFemelleAlpha() {
        Lycanthrope l1 = new Lycanthrope("Lycan1", 'F', CategorieAge.ADULTE.toString(), RangDomination.BETA);
        Lycanthrope l2 = new Lycanthrope("Lycan2", 'F', CategorieAge.ADULTE.toString(), RangDomination.BETA);
        List<Lycanthrope> meute = Arrays.asList(l1, l2);

        Couple_α couple = new Couple_α();
        Lycanthrope femelleAlpha = couple.trouverFemelleAlpha(meute);

        assertEquals(l2, femelleAlpha);
    }

    @Test
    public void testCreerCoupleAlpha() {
        Lycanthrope l1 = new Lycanthrope("Lycan3", 'M', CategorieAge.ADULTE.toString(), RangDomination.BETA);
        Lycanthrope l2 = new Lycanthrope("Lycan4", 'F', CategorieAge.ADULTE.toString(), RangDomination.BETA);
        List<Lycanthrope> meute = Arrays.asList(l1, l2);

        Couple_α couple = new Couple_α();
        Lycanthrope[] coupleAlpha = couple.creerCoupleAlpha(meute);

        assertArrayEquals(new Lycanthrope[] { l1, l2 }, coupleAlpha);
    }

    @Test
    public void testVerifierCoupleAlpha() {
        Lycanthrope l1 = new Lycanthrope("Lycan5", 'M', CategorieAge.ADULTE.toString(), RangDomination.BETA);
        Lycanthrope l2 = new Lycanthrope("Lycan6", 'M', CategorieAge.ADULTE.toString(), RangDomination.ALPHA);
        Lycanthrope l3 = new Lycanthrope("Lycan7", 'F', CategorieAge.ADULTE.toString(), RangDomination.BETA);
        List<Lycanthrope> meute = Arrays.asList(l1, l2, l3);

        Couple_α couple = new Couple_α();
        Lycanthrope[] coupleAlpha = couple.creerCoupleAlpha(meute);
        coupleAlpha = couple.verifierCoupleAlpha(meute, coupleAlpha);

        assertArrayEquals(new Lycanthrope[] { l2, l3 }, coupleAlpha);
    }

    @Test
    public void testRangDominationFemelleDechue() {
        Lycanthrope l1 = new Lycanthrope("Lycan8", 'M', CategorieAge.ADULTE.toString(), RangDomination.BETA);
        Lycanthrope l2 = new Lycanthrope("Lycan9", 'M', CategorieAge.ADULTE.toString(), RangDomination.ALPHA);
        Lycanthrope l3 = new Lycanthrope("Lycan10", 'F', CategorieAge.ADULTE.toString(), RangDomination.BETA);
        List<Lycanthrope> meute = Arrays.asList(l1, l2, l3);
    
        Couple_α couple = new Couple_α();
        Lycanthrope[] coupleAlpha = couple.creerCoupleAlpha(meute);
        coupleAlpha = couple.verifierCoupleAlpha(meute, coupleAlpha);
    
        assertEquals(l2.getRangDomination(), coupleAlpha[1].getRangDomination());
    }
}