package Base;

/**
 * La classe Creature représente une créature vivante dans le zoo
 */
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

    /**
     * Constructeur de la classe Creature.
     *
     * @param nomEspece       Le nom de l'espèce de la créature.
     * @param nom             Le nom de la créature.
     * @param sexe            Le sexe de la créature ('M' pour masculin, 'F' pour
     *                        féminin).
     * @param poids           Le poids de la créature.
     * @param taille          La taille de la créature.
     * @param age             L'âge de la créature.
     * @param indicateurFaim  L'indicateur de faim de la créature.
     * @param dort            Indique si la créature dort ou non.
     * @param indicateurSante L'indicateur de santé de la créature.
     */
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

    /**
     * Permet à la créature de manger, augmentant l'indicateur de faim et le poids
     * si elle n'est pas en train de dormir.
     */
    public void manger() {
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

    /**
     * Émet un son spécifié par la créature.
     *
     * @param son Le son émis par la créature.
     */
    public void emettreSon(String son) {
        System.out.println(son);
    }

    /**
     * Indique que la créature est malade.
     */
    public void etreMalade() {
        malade = true;
    }

    /**
     * Soigne la créature en augmentant son indicateur de santé si elle était
     * malade.
     */
    public void etreSoigne() {
        indicateurSante += 60;
        if (indicateurSante > 100) {
            indicateurSante = 100;
        }
        malade = false;
    }

    /**
     * Diminue l'indicateur de santé de la créature selon une quantité spécifiée.
     *
     * @param quantite La quantité de diminution de la santé.
     */
    public void diminuerSante(int quantite) {
        indicateurSante -= quantite;
        if (indicateurSante <= 0) {
        }
    }

    /**
     * Fait dormir la créature.
     */
    public void dormir() {
        dort = true;
    }

    /**
     * Réveille la créature.
     */
    public void seReveiller() {
        dort = false;
    }

    /**
     * Fait vieillir la créature, augmentant son âge et retournant la probabilité de
     * mourir.
     *
     * @return La probabilité de mourir de la créature.
     */
    public double vieillir() {
        age++;

        double probaMourir = A * Math.exp(B * age);
        return probaMourir;
    }

    /**
     * Vérifie si la créature doit mourir de vieillesse, de faim ou d'obésité.
     */
    public void mourir() {
        if (Math.random() < vieillir()) {
            emettreSon(this.getNom() + " est mort de vieillesse");
        }
        if (indicateurFaim <= 0) {
            emettreSon(this.getNom() + " est mort de faim");
        }
        if (poids > 350) {
            emettreSon(this.getNom() + " est mOrt d'Obésité");
        }
    }

    /**
     * Méthode permettant d'obtenir une représentation textuelle de la créature.
     *
     * @return Une chaîne de caractères décrivant les caractéristiques de la
     *         créature.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("La créature ").append(nom).append(".\n");
        sb.append("C'est un").append(sexe == 'M' ? " mâle" : "e femelle").append(".\n");
        sb.append("Elle pèse ").append(poids).append(" kg et mesure ").append(taille).append(" cm.\n");
        sb.append("Elle a ").append(age).append(age > 1 ? " ans" : " an").append(".\n");
        sb.append("Son indicateur de faim est à ").append(indicateurFaim).append(".\n");
        sb.append("Elle est ").append(dort ? "endormie" : "éveillée").append(".\n");
        sb.append("Son indicateur de santé est à ").append(indicateurSante).append(".\n");
        sb.append("Elle est ").append(getmalade() ? "malade" : "en bonne santé").append(".\n\n");
        return sb.toString();
    }

    /**
     * Méthode permettant d'obtenir le nom de l'espèce de la créature.
     *
     * @return Le nom de l'espèce de la créature.
     */
    public String getNomEspece() {
        return nomEspece;
    }

    /**
     * Méthode permettant de définir le nom de l'espèce de la créature.
     *
     * @param nomEspece Le nouveau nom de l'espèce de la créature.
     */
    public void setNomEspece(String nomEspece) {
        this.nomEspece = nomEspece;
    }

    /**
     * Méthode permettant d'obtenir le nom de la créature.
     *
     * @return Le nom de la créature.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode permettant de définir le nom de la créature.
     *
     * @param nom Le nouveau nom de la créature.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode permettant d'obtenir le sexe de la créature.
     *
     * @return Le sexe de la créature.
     */
    public char getSexe() {
        return sexe;
    }

    /**
     * Méthode permettant de définir le sexe de la créature.
     *
     * @param sexe Le nouveau sexe de la créature.
     */
    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    /**
     * Méthode permettant d'obtenir le poids de la créature.
     *
     * @return Le poids de la créature.
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Méthode permettant de définir le poids de la créature.
     *
     * @param poids Le nouveau poids de la créature.
     */
    public void setPoids(double poids) {
        this.poids = poids;
    }

    /**
     * Méthode permettant d'obtenir la taille de la créature.
     *
     * @return La taille de la créature.
     */
    public double getTaille() {
        return taille;
    }

    /**
     * Méthode permettant de définir la taille de la créature.
     *
     * @param taille La nouvelle taille de la créature.
     */
    public void setTaille(double taille) {
        this.taille = taille;
    }

    /**
     * Méthode permettant d'obtenir l'âge de la créature.
     *
     * @return L'âge de la créature.
     */
    public int getAge() {
        return age;
    }

    /**
     * Méthode permettant de définir l'âge de la créature.
     *
     * @param age Le nouvel âge de la créature.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Méthode permettant d'obtenir l'indicateur de faim de la créature.
     *
     * @return L'indicateur de faim de la créature.
     */
    public int getIndicateurFaim() {
        return indicateurFaim;
    }

    /**
     * Méthode permettant de définir l'indicateur de faim de la créature.
     *
     * @param indicateurFaim Le nouvel indicateur de faim de la créature.
     */
    public void setIndicateurFaim(int indicateurFaim) {
        this.indicateurFaim = indicateurFaim;
    }

    /**
     * Méthode permettant de vérifier si la créature dort.
     *
     * @return true si la créature dort, false sinon.
     */
    public boolean isDort() {
        return dort;
    }

    /**
     * Méthode permettant de définir l'état de sommeil de la créature.
     *
     * @param dort true si la créature dort, false sinon.
     */
    public void setDort(boolean dort) {
        this.dort = dort;
    }

    /**
     * Méthode permettant d'obtenir l'indicateur de santé de la créature.
     *
     * @return L'indicateur de santé de la créature.
     */
    public int getIndicateurSante() {
        return indicateurSante;
    }

    /**
     * Méthode permettant de définir l'indicateur de santé de la créature.
     *
     * @param indicateurSante Le nouvel indicateur de santé de la créature.
     */
    public void setIndicateurSante(int indicateurSante) {
        this.indicateurSante = indicateurSante;
    }

    /**
     * Méthode permettant de vérifier si la créature est malade.
     *
     * @return true si la créature est malade, false sinon.
     */
    public boolean getmalade() {
        return malade;
    }

    /**
     * Méthode permettant de vérifier si la créature est vivante.
     *
     * @return true si la créature est vivante, false sinon.
     */
    public boolean isEstVivant() {
        return estVivant;
    }

    /**
     * Méthode permettant de définir l'état de vitalité de la créature.
     *
     * @param estVivant true si la créature est vivante, false sinon.
     */
    public void setEstVivant(boolean estVivant) {
        this.estVivant = estVivant;
    }

    /**
     * Méthode de reproduction de la créature.
     *
     * @param gestionnaireEnclos Le gestionnaire d'enclos utilisé pour gérer la
     *                           reproduction.
     * @return Une nouvelle créature issue de la reproduction.
     */
    public Creature Reproduction(GestionnaireEnclos gestionnaireEnclos) {
        return null;
    }

}