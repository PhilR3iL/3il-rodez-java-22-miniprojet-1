package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.exception.MauvaiseValeurException;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

public class Terrain {
    private double altitude;
    private double hydrometrie;
    private double temperature;
    public Terrain(double altitude,double hydrometrie, double temperature) throws MauvaiseValeurException{
        hydrometrie = Math.abs(hydrometrie);
        temperature = Math.abs(temperature);


        if (altitude<-1 || altitude > 1){
            throw new MauvaiseValeurException(altitude);
        }
        else if (hydrometrie < 0 || hydrometrie > 1){
            throw new MauvaiseValeurException(hydrometrie);
        }
        else if (temperature < 0 || temperature > 1){
            throw new MauvaiseValeurException(temperature);
        }
        this.altitude=altitude;
        this.hydrometrie=hydrometrie;
        this.temperature=temperature;
    }
    public TypeTerrain getTypeTerrain(DetermineurTerrain dt){
        return dt.determinerTerrain(altitude,hydrometrie,temperature);
    }

    public double getAltitude() {
        return altitude;
    }

    public double getHydrometrie() {
        return hydrometrie;
    }

    public double getTemperature() {
        return temperature;
    }
}
