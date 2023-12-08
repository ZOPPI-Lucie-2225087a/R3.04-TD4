package Base;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireCreature {

    private List<Creature> listeDesCreatures = new ArrayList<>();

    public void ajouterCreature(Creature creature) {
        listeDesCreatures.add(creature);
    }

    public List<Creature> getListeDesCreatures() {
        return listeDesCreatures;
    }
}