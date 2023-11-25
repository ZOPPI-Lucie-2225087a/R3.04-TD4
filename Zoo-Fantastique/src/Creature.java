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
        this.Cri= Cri;
        this.estVivant= true;
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

    public void manger(int nourriture){
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
        indicateurSante += 30; //a definir combien on soigne
        if (indicateurSante > 100) {
            indicateurSante = 100;
        }
        emettreSon("Je ne suis plus malade");
    }

    public void dormir() {
        dort = true;
        emettreSon("Je m'endors");
    }
    public void seReveiller() {
        dort = false;
        emettreSon("Je me réveille");
    }

}