package MeuteLycanthropes;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Couple_α {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Lycanthrope[] coupleAlpha;

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

    public void startVerifyingCoupleAlpha(List<Lycanthrope> meute) {
        Runnable verifier = new Runnable() {
            public void run() {
                coupleAlpha = verifierCoupleAlpha(meute, coupleAlpha);
            }
        };

        scheduler.scheduleAtFixedRate(verifier, 0, 5, TimeUnit.SECONDS);
    }

    public void stopVerifyingCoupleAlpha() {
        scheduler.shutdown();
    }

    public Lycanthrope[] reproduire(boolean saisonDesAmours, List<Lycanthrope> meute) {
        if (!saisonDesAmours) {
            return new Lycanthrope[0];
        }
    
        Random rand = new Random();
        int nombreDeNouveauxLycanthropes = rand.nextInt(7) + 1;
    
        Lycanthrope[] nouveauxLycanthropes = new Lycanthrope[nombreDeNouveauxLycanthropes];
        for (int i = 0; i < nombreDeNouveauxLycanthropes; i++) {
            String nom = "NouveauLycan" + i;
            char sexe = rand.nextBoolean() ? 'M' : 'F';
            String categorieAge = CategorieAge.JEUNE.toString();
            int rangIndex = rand.nextInt(RangDomination.values().length);
            RangDomination rangDomination = RangDomination.values()[rangIndex];
    
            nouveauxLycanthropes[i] = new Lycanthrope(nom, sexe, categorieAge, rangDomination);
            meute.add(nouveauxLycanthropes[i]);
        }
    
        return nouveauxLycanthropes;
    }
}
