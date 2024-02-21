package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.exception.MauvaiseValeurException;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import java.util.Random;

public class GenerateurAleatoire extends GenerateurCarte {

    Random valeurAleatoire;

    public GenerateurAleatoire(long graine) {
        super(graine);
        this.valeurAleatoire = new Random(graine);
    }

    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        double altitude = this.valeurAleatoire.nextDouble() * 2 - 1;
        double hydrometrie = this.valeurAleatoire.nextDouble();
        double temperature = this.valeurAleatoire.nextDouble();

        try {
            return new Terrain(altitude, hydrometrie, temperature);
        } catch (MauvaiseValeurException e) {
            e.printStackTrace();
            return null;
        }
    }
}