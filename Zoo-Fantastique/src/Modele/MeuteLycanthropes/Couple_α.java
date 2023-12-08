package MeuteLycanthropes;

import java.util.List;

public class Couple_α {

    public Lycanthrope trouverMaleAlpha(List<Lycanthrope> meute) {
        Lycanthrope maleAlpha = null;
        int forceMax = -1;

        for (Lycanthrope lycanthrope : meute) {
            if (lycanthrope.getSexe() == 'M' && lycanthrope.getCategorieAge().equals(CategorieAge.ADULTE.toString())
                    && lycanthrope.getForce() > forceMax) {
                forceMax = lycanthrope.getForce();
                maleAlpha = lycanthrope;
            }
        }

        return maleAlpha;
    }

    public Lycanthrope trouverFemelleAlpha(List<Lycanthrope> meute) {
        Lycanthrope FemelleAlpha = null;
        int forceMax = -1;

        for (Lycanthrope lycanthrope : meute) {
            if (lycanthrope.getSexe() == 'F' && lycanthrope.getCategorieAge().equals(CategorieAge.ADULTE.toString())
                    && lycanthrope.getForce() > forceMax) {
                forceMax = lycanthrope.getForce();
                FemelleAlpha = lycanthrope;
            }
        }

        return FemelleAlpha;
    }

    public Lycanthrope[] creerCoupleAlpha(List<Lycanthrope> meute) {
        Lycanthrope maleAlpha = trouverMaleAlpha(meute);
        Lycanthrope femelleAlpha = trouverFemelleAlpha(meute);

        return new Lycanthrope[] { maleAlpha, femelleAlpha };
    }

    public Lycanthrope[] verifierCoupleAlpha(List<Lycanthrope> meute, Lycanthrope[] coupleAlpha) { // a verifier avec des thread constament
        Lycanthrope nouveauMaleAlpha = trouverMaleAlpha(meute);

        if (!nouveauMaleAlpha.equals(coupleAlpha[0])) {
            Lycanthrope ancienneFemelleAlpha = coupleAlpha[1];
            ancienneFemelleAlpha.setRangDomination(nouveauMaleAlpha.getRangDomination());

            Lycanthrope nouvelleFemelleAlpha = trouverFemelleAlpha(meute);
            coupleAlpha = new Lycanthrope[] { nouveauMaleAlpha, nouvelleFemelleAlpha };
        }

        return coupleAlpha;
    }

}
