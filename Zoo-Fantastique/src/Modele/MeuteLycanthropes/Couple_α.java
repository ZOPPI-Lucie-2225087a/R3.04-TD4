package MeuteLycanthropes;

import java.util.List;

public class Couple_α {
    private Lycanthrope maleAlpha;
    private Lycanthrope femelleAlpha;

    private List<Lycanthrope> femelles;

    public Couple_α(Lycanthrope maleAlpha, List<Lycanthrope> femelles) {
        this.maleAlpha = maleAlpha;
        this.femelles = femelles;
        this.femelleAlpha = trouverNouvelleFemelleAlpha();
    }

    public void setFemelles(List<Lycanthrope> nouvellesFemelles) { //met a jour la liste ed femelle
        this.femelles.clear();
        this.femelles.addAll(nouvellesFemelles);
        this.femelleAlpha = trouverNouvelleFemelleAlpha();
    }

    private Lycanthrope trouverNouvelleFemelleAlpha() {
        Lycanthrope nouvelleFemelleAlpha = null;
        int forceFemelleAlpha = -1;

        for (Lycanthrope femelle : femelles) {
            if (femelle.getSexe() == 'F' && femelle.getForce() > forceFemelleAlpha) {
                forceFemelleAlpha = femelle.getForce();
                nouvelleFemelleAlpha = femelle;
            }
        }

        return nouvelleFemelleAlpha;
    }

    public void dechuFemelleAlpha(Lycanthrope ancienneFemelleAlpha) {
        if (ancienneFemelleAlpha == this.femelleAlpha) {
            ancienneFemelleAlpha.setRangDomination(this.maleAlpha.getRangDomination());
        }
    }
}

