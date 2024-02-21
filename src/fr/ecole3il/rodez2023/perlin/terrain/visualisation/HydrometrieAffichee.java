package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

public enum HydrometrieAffichee {
    Sec(0.0),
    Moyen(0.33),
    Humide(0.66);

    private double valeurHydrometrie;

    HydrometrieAffichee(double hydrometrie){
        this.valeurHydrometrie=hydrometrie;
    }

    public double getValeurHydrometrie() {
        return valeurHydrometrie;
    }
}
