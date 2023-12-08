package Base;

public class Creature {
    private String nomEspece;
    private String nom;
    private char sexe;
    private double poids;
    private double taille;
    private int age;
    private int indicateurFaim;
    private boolean dort;
    private int indicateurSante;
    private boolean malade;
    private boolean estVivant;

    private static final double B = Math.log(2) / 10;
    private static final double A = 0.1 / Math.exp(B * 60);

    public Creature(String nomEspece, String nom, char sexe, double poids, double taille, int age,
            int indicateurFaim, boolean dort, int indicateurSante) {
        this.nomEspece = nomEspece;
        this.nom = nom;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.indicateurFaim = 100;
        this.dort = dort;
        this.indicateurSante = 100;
        this.malade = false;
        this.estVivant = true;
    }

    public void manger() {
        mourir();
        if (!dort) {
            indicateurFaim += 30;
            if (indicateurFaim > 100) {
                indicateurFaim = 100;
            }
            poids += 3;
            emettreSon("Je mange");
        } else {
            emettreSon("Je ne mange pas car je dors");
        }
    }

    public void emettreSon(String son) {
        System.out.println(son);
    }

    public void etreMalade() {
        malade = true;
    }

    public void etreSoigne() {
        indicateurSante += 60;
        if (indicateurSante > 100) {
            indicateurSante = 100;
        }
        malade = false;
    }

    public void diminuerSante(int quantite) {
        mourir();
        indicateurSante -= quantite;
        if (indicateurSante <= 0) {
        }
    }

    public void dormir() {
        dort = true;
    }

    public void seReveiller() {
        dort = false;
    }

    public double vieilir() {
        mourir();
        age++;

        double probaMourir = A * Math.exp(B * age);
        return probaMourir;
    }

    public void mourir() {
        if (Math.random() < vieilir()) {
            emettreSon(this.getNom() + " est mort de vieillesse");
        }
        if (indicateurFaim <=0) {
            emettreSon(this.getNom() + " est mort de faim");
        }
        if (poids > 350){
            emettreSon(this.getNom() + " est mOrt d'Obésité");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("La créature ").append(nom).append(".\n");
        sb.append("C'est un").append(sexe == 'M' ? " mâle" : "e femelle").append(".\n");
        sb.append("Elle pèse ").append(poids).append(" kg et mesure ").append(taille).append(" cm.\n");
        sb.append("Elle a ").append(age).append(age > 1 ? " ans" : " an").append(".\n");
        sb.append("Son indicateur de faim est à ").append(indicateurFaim).append(".\n");
        sb.append("Elle est ").append(dort ? "endormie" : "éveillée").append(".\n");
        sb.append("Son indicateur de santé est à ").append(indicateurSante).append(".\n\n");
        return sb.toString();
    }

    public String getNomEspece() {
        return nomEspece;
    }

    public void setNomEspece(String nomEspece) {
        this.nomEspece = nomEspece;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIndicateurFaim() {
        return indicateurFaim;
    }

    public void setIndicateurFaim(int indicateurFaim) {
        this.indicateurFaim = indicateurFaim;
    }

    public boolean isDort() {
        return dort;
    }

    public void setDort(boolean dort) {
        this.dort = dort;
    }

    public int getIndicateurSante() {
        return indicateurSante;
    }

    public void setIndicateurSante(int indicateurSante) {
        this.indicateurSante = indicateurSante;
    }

    public boolean getmalade() {
        return malade;
    }

    public boolean isEstVivant() {
        return estVivant;
    }

    public void setEstVivant(boolean estVivant) {
        this.estVivant = estVivant;
    }

    public Creature Reproduction(GestionnaireEnclos gestionnaireEnclos) {
        return null;
    }

}