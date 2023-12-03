package MeuteLycanthropes;

import java.util.ArrayList;

public class Meute {
    private ArrayList<Lycanthrope> lycanthropes;
    private String cri;

    public Meute(String cri) {
        this.lycanthropes = new ArrayList<Lycanthrope>();
        this.cri = cri;
        System.out.println("Une nouvelle meute a été créée ! (cri : \"" + this.cri + "\")");
    }

    public void afficherLycanthropes() {
        System.out.println("Voici les lycanthropes de la meute :");
        for (Lycanthrope lycanthrope : lycanthropes) {
            System.out.println(lycanthrope);
        }
    }

    public void ajouterLycanthrope(Lycanthrope lycanthrope) {
        if(!this.lycanthropes.contains(lycanthrope)) {
            this.lycanthropes.add(lycanthrope);
            System.out.println(lycanthrope.getNom() + " a été ajouté à la meute");
        }
    }

    public void retirerLycanthrope(Lycanthrope lycanthrope) {
        if(this.lycanthropes.contains(lycanthrope)) {
            this.lycanthropes.remove(lycanthrope);
            System.out.println(lycanthrope.getNom() + " a été retiré de la meute");
        }
    }

    public String getCri() {
        return cri;
    }

    public ArrayList<Lycanthrope> getLycanthropes() {
        return this.lycanthropes;
    }
}