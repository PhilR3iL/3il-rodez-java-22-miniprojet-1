package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

public class GenerateurPerlin extends GenerateurCarte{

    public GenerateurPerlin(long graine) {
        super(graine);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        /**Generation des valeurs de types BruitPerlin2D
         *
         * Vous êtes parti très très très loin dans la réalisation de cette classe
         * J'ai failli faire un coma
         *
         * @BruitPerlin2D --> génération des valeurs avec des graines*/
        BruitPerlin2D altitudePerlin = new BruitPerlin2D(getGraine(), 1);
        BruitPerlin2D hydrometriePerlin = new BruitPerlin2D(getGraine(), 1);
        BruitPerlin2D temperaturePerlin = new BruitPerlin2D(getGraine() * 2, 1);
        /**@double x/y --> création des coordonnées*/
        double x = (double) i / (double) largeur;
        double y = (double) j / (double) hauteur;
        /**@double --> attribution des valeurs aux attributs*/
        double altitude = altitudePerlin.bruit2D(x, y);
        double hydrometrie = hydrometriePerlin.bruit2D(x, y);
        double temperature = temperaturePerlin.bruit2D(x, y);
        hydrometrie = (hydrometrie + 1) / 2;
        temperature = (temperature + 1) / 2 ;
        /**@return --> création d'un nouveau terrain*/
        return new Terrain(altitude, hydrometrie, temperature);
    }

}
