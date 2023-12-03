package MeuteLycanthropes;

public enum CategorieAge {
    JEUNE,
    ADULTE,
    VIEUX;

    public static CategorieAge getCategorie(int age) {
        if (age >= 0 && age <= 30) {
            return JEUNE;
        } else if (age >= 31 && age <= 60) {
            return ADULTE;
        } else {
            return VIEUX;
        }
    }
}