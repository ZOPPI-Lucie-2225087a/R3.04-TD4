package CreaturesAttributs;

public class Creature {
    private String nomEspece;
    private char sexe;
    private double poids;
    private double taille;
    private int age;
    private int indicateurFaim;
    private boolean dort;
    private int indicateurSante;
    private String Cri;
    private boolean estVivant;

    public Creature(String nomEspece, char sexe, double poids, double taille, int age,
            int indicateurFaim, boolean dort, int indicateurSante) {
        this.nomEspece = nomEspece;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.indicateurFaim = indicateurFaim;
        this.dort = dort;
        this.indicateurSante = indicateurSante;
        this.Cri = Cri;
        this.estVivant = true;
    }

    public String getNomEspece() {
        return nomEspece;
    }

    public void setNomEspece(String nomEspece) {
        this.nomEspece = nomEspece;
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

    public String getCri() {
        return Cri;
    }

    public void setCri(String cri) {
        Cri = cri;
    }

    public boolean isEstVivant() {
        return estVivant;
    }

    public void setEstVivant(boolean estVivant) {
        this.estVivant = estVivant;
    }

    public void manger(int nourriture) {
        if (!dort) {
            indicateurFaim += nourriture;
            if (indicateurFaim > 100) {
                indicateurFaim = 100;
            }
            emettreSon("Je mange");
        } else {
            emettreSon("Je ne mange pas car je dors");
        }
    }

    public void emettreSon(String son) {
        System.out.println(son);
    }

    public void etreSoigne() {
        indicateurSante += 30; // a definir combien on soigne
        if (indicateurSante > 100) {
            indicateurSante = 100;
        }
        emettreSon("Je ne suis plus malade");
    }

    public void diminuerSante(int quantite) {
        indicateurSante -= quantite;
        if (indicateurSante <= 0) {
            mourir("Je suis mort de maladie");
        }
    }

    public void dormir() {
        dort = true;
        emettreSon("Je m'endors");
    }

    public void seReveiller() {
        dort = false;
        emettreSon("Je me réveille");
    }

    public void vieilir() {
        age++;
        emettreSon("Je vieilis. Mon âge est maintenant : " + age);

        double probaMourir = 1 - Math.exp(-0.05 * age); // proba surment trop haute a modifier plus tard

        if (Math.random() < probaMourir) {
            mourir("Je suis mort de vieilese");
        }
    }

    public void mourir(String raison) {
        emettreSon(raison);
    }

}