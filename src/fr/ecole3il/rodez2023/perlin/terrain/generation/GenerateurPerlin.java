package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

public class GenerateurPerlin extends GenerateurCarte {

    private BruitPerlin2D bruitAltitude;
    private BruitPerlin2D bruitHydrometrie;
    private BruitPerlin2D bruitTemperature;

    public GenerateurPerlin(long graine) {
        super(graine);

        // Utilisez la graine pour initialiser les générateurs de bruit de Perlin
        bruitAltitude = new BruitPerlin2D(graine * 2, 1.0);
        bruitHydrometrie = new BruitPerlin2D(graine, 1.0);
        bruitTemperature = new BruitPerlin2D(graine * 2, 1.0);
    }

    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        // Normalisez les coordonnées
        double x = (double) i / largeur;
        double y = (double) j / hauteur;

        // Utilisez les générateurs de bruit de Perlin pour les trois caractéristiques
        double altitude = bruitAltitude.bruit2D(x, y);
        double hydrometrie = bruitHydrometrie.bruit2D(x, y);
        double temperature = bruitTemperature.bruit2D(x, y);


        return new Terrain(altitude, hydrometrie, temperature);
    }
}
