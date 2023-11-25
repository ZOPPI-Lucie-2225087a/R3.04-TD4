public class Creature {
    private String nomEspece;
    private char sexe;
    private double poids;
    private double taille;
    private int age;
    private int indicateurFaim;
    private boolean dort;
    private int indicateurSante;

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
}