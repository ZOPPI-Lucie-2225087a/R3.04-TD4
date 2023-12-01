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
    private String Cri;
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
        this.indicateurFaim = indicateurFaim;
        this.dort = dort;
        this.indicateurSante = indicateurSante;
        this.Cri = Cri;
        this.estVivant = true;
    }

    public void manger() {
        if (!dort) {
            indicateurFaim += 30;
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
        indicateurSante += 30;
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
        emettreSon("Je vieillis. Mon âge est maintenant : " + age);

        double probaMourir = A * Math.exp(B * age);

        if (Math.random() < probaMourir) {
            mourir("Je suis mort de vieillesse");
        }
    }

    public void mourir(String raison) {
        emettreSon(raison);
    }

    @Override
    public String toString() {
        return "Creature {\n" +
                "\tnomEspece: " + nomEspece + ",\n" +
                "\tnom: " + nom + ",\n" +
                "\tsexe: " + sexe + ",\n" +
                "\tpoids: " + poids + ",\n" +
                "\ttaille: " + taille + ",\n" +
                "\tage: " + age + ",\n" +
                "\tindicateurFaim: " + indicateurFaim + ",\n" +
                "\tdort: " + dort + ",\n" +
                "\tindicateurSante: " + indicateurSante + "\n" +
                "\t}";
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

}