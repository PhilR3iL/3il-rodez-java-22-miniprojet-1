package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

public enum AltitudeAffichee {
    FondMarin(-1.0),
    Basse(0.0),
    Moyenne(0.33),
    elevee(0.66);

    private double valeurAltitude;

    AltitudeAffichee(double altitude){
        this.valeurAltitude=altitude;
    }

    public double getValeurAltitude() {
        return valeurAltitude;
    }
}
