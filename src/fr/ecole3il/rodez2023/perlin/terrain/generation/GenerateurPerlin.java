package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

public class GenerateurPerlin extends GenerateurCarte{
    BruitPerlin2D bruitPerlinHydrometrie;
    BruitPerlin2D bruitPerlinTemperature;
    BruitPerlin2D bruitPerlinAltitude;
    BruitPerlin2D bruitPerlinDetails;
    BruitPerlin2D bruitPerlinForms;

    public GenerateurPerlin(long graine) {
        super(graine);
        long graineDetails = graine*3;
        long graineForms = graine*4;
        bruitPerlinHydrometrie = new BruitPerlin2D(graine,1);
        bruitPerlinTemperature = new BruitPerlin2D(graine*2,1);
        bruitPerlinAltitude = new BruitPerlin2D(graine*4,1);
        bruitPerlinForms = new BruitPerlin2D(graineForms,1);
        bruitPerlinDetails = new BruitPerlin2D(graineDetails,1);
    }

    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        double x = (double)i / largeur;
        double y = (double)j / hauteur;

        double altitude = bruitPerlinAltitude.bruit2D(x, y);
        double hydrometrie = Math.abs(bruitPerlinHydrometrie.bruit2D(x, y));
        double temperature = Math.abs(bruitPerlinTemperature.bruit2D(x, y));

        return new Terrain(altitude, hydrometrie, temperature);
    }

}
