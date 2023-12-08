package Base;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente un gestionnaire de créatures.
 * Il permet d'ajouter des créatures à une liste et d'obtenir la liste complète
 * des créatures.
 */
public class GestionnaireCreature {

    /**
     * Liste contenant l'ensemble des créatures gérées par le gestionnaire.
     */
    private List<Creature> listeDesCreatures = new ArrayList<>();

    /**
     * Ajoute une créature à la liste des créatures gérées par le gestionnaire.
     *
     * @param creature La créature à ajouter.
     */
    public void ajouterCreature(Creature creature) {
        listeDesCreatures.add(creature);
    }

    /**
     * Obtient la liste complète des créatures gérées par le gestionnaire.
     *
     * @return La liste des créatures.
     */
    public List<Creature> getListeDesCreatures() {
        return listeDesCreatures;
    }
}