package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

public class Terrain {
    private double altitude;
    private double temperature;
    private double hydrometrie;

    public Terrain(double altitude, double temperature, double hydrometrie) {
        temperature = Math.abs(temperature);
        hydrometrie = Math.abs(hydrometrie);
        if(temperature > 1 || temperature < 0)
            throw new MauvaiseValeurException("la valeur temperature entrée n'est pas correcte");

        if(hydrometrie > 1 || hydrometrie < 0)
            throw new MauvaiseValeurException("la valeur hydometrie entrée n'est pas correcte");

        if(altitude > 1 || altitude < -1)
            throw new MauvaiseValeurException("la valeur altitude entrée n'est pas correcte");


        this.altitude = altitude;
        this.temperature = temperature;
        this.hydrometrie = hydrometrie;
    }


    public double getAltitude() {
        return this.altitude;
    }

    public void setAltitude(double altitude) {
        if(altitude > 1 || altitude < -1)
            throw new MauvaiseValeurException("la valeur altitude entrée n'est pas correcte");
        else
            this.altitude = altitude;
    }

    public void setTemperature(double temperature) {
        if(altitude > 1 || altitude < 0)
            throw new MauvaiseValeurException("la valeur altitude entrée n'est pas correcte");
        else
            this.temperature = temperature;
    }

    public void setHydrometrie(double hydrometrie) {
        if(altitude > 1 || altitude < 0)
            throw new MauvaiseValeurException("la valeur altitude entrée n'est pas correcte");
        else
            this.hydrometrie = hydrometrie;
    }

    TypeTerrain getTypeTerrain(DetermineurTerrain dt){
        return dt.determinerTerrain(altitude, hydrometrie, temperature);
    }
    public double getHydrometrie() {
        return this.hydrometrie;
    }

    public double getTemperature() {
        return this.temperature;
    }
}
