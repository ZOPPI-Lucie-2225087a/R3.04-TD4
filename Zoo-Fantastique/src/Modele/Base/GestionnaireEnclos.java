package Base;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente un gestionnaire d'enclos.
 * Il permet d'ajouter des enclos à une liste et d'obtenir la liste complète des
 * enclos.
 */
public class GestionnaireEnclos {

    /**
     * Liste contenant l'ensemble des enclos gérés par le gestionnaire.
     */
    private List<Enclos> listeDesEnclos = new ArrayList<>();

    /**
     * Constructeur de la classe GestionnaireEnclos.
     *
     * @param listeDesEnclos La liste initiale d'enclos à gérer.
     */
    public GestionnaireEnclos(List<Enclos> listeDesEnclos) {
        this.listeDesEnclos = listeDesEnclos;
    }

    /**
     * Ajoute un enclos à la liste des enclos gérés par le gestionnaire.
     *
     * @param enclos L'enclos à ajouter.
     */
    public void ajouterEnclos(Enclos enclos) {
        listeDesEnclos.add(enclos);
    }

    /**
     * Obtient la liste complète des enclos gérés par le gestionnaire.
     *
     * @return La liste des enclos.
     */
    public List<Enclos> getListeDesEnclos() {
        return listeDesEnclos;
    }
}