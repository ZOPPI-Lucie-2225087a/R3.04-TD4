package MeuteLycanthropes;

public class Conflit {
    private Lycanthrope lycanthrope1;
    private Lycanthrope lycanthrope2;

    public Conflit(Lycanthrope lycanthrope1, Lycanthrope lycanthrope2) {
        if (lycanthrope1.getRangDomination() != lycanthrope2.getRangDomination()) {
            throw new IllegalArgumentException(
                    "Les lycanthropes doivent avoir le même rang de domination pour entrer en conflit.");
        }
        this.lycanthrope1 = lycanthrope1;
        this.lycanthrope2 = lycanthrope2;
    }

    public void resoudre() {
        if (lycanthrope1.calculerNiveau() > lycanthrope2.calculerNiveau()) {
            lycanthrope1.setRangDomination(lycanthrope1.getRangDomination().next());
            lycanthrope2.setRangDomination(lycanthrope2.getRangDomination().previous());
            System.out.println(lycanthrope1 + "a gagner le combat");
        } else if (lycanthrope1.calculerNiveau() < lycanthrope2.calculerNiveau()) {
            lycanthrope1.setRangDomination(lycanthrope1.getRangDomination().previous());
            lycanthrope2.setRangDomination(lycanthrope2.getRangDomination().next());
            System.out.println(lycanthrope2 + "a gagner le combat");
        } else {
            System.out.println("Le conflit est un match nul.");
        }
    }
}