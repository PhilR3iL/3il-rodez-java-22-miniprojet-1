package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

public enum TemperatureAffichee {
    Froid(0.0),
    Tempere(10.0),
    Chaud(20.0);

    private double valeurTemperature;

    TemperatureAffichee(double temperature) {
        this.valeurTemperature = temperature;
    }

    public double getValeurLimite() {
        return valeurTemperature;
    }
}
