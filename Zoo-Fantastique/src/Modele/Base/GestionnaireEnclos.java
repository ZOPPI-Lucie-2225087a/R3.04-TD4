package Base;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEnclos {
    
    private List<Enclos> listeDesEnclos = new ArrayList<>();

    public GestionnaireEnclos(List<Enclos> listeDesEnclos) {
        this.listeDesEnclos = listeDesEnclos;
    }
    
    public void ajouterEnclos(Enclos enclos) {
        listeDesEnclos.add(enclos);
    }

    public List<Enclos> getListeDesEnclos() {
        return listeDesEnclos;
    }
}