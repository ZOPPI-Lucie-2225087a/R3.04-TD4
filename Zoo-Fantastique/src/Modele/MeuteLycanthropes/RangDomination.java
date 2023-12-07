package MeuteLycanthropes;

public enum RangDomination {
    ALPHA("α"),
    BETA("β"),
    GAMMA("γ"),
    DELTA("δ"),
    EPSILON("ε"),
    ZETA("ζ"),
    ETA("η"),
    THETA("θ"),
    IOTA("ι"),
    KAPPA("κ"),
    LAMBDA("λ"),
    MU("μ"),
    NU("ν"),
    XI("ξ"),
    OMICRON("ο"),
    PI("π"),
    RHO("ρ"),
    SIGMA("σ"),
    TAU("τ"),
    UPSILON("υ"),
    PHI("φ"),
    CHI("χ"),
    PSI("ψ"),
    OMEGA("ω");

    private final String symbol;

    RangDomination(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
    
    public RangDomination next() {
        int nextOrdinal = this.ordinal() + 1;
        if (nextOrdinal >= RangDomination.values().length) {
            nextOrdinal = 0;
        }
        return RangDomination.values()[nextOrdinal];
    }
    
    public RangDomination previous() {
        int prevOrdinal = this.ordinal() - 1;
        if (prevOrdinal < 0) {
            prevOrdinal = RangDomination.values().length - 1;
        }
        return RangDomination.values()[prevOrdinal];
    }



}
