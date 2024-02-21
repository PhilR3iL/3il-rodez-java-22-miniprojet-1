package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.MauvaiseValeurException;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;


import java.util.Random;

/**
 * Cette classe représente un générateur de carte aléatoire héritant de la classe GenerateurCarte.
 * Initialise des valeurs au hasard pour les trois caractéristiques de terrain.
 * Utilise la méthode Perlin pour générer un tableau de terrains en fonction d'une graine aléatoire.
 * @author proussille
 */
public class GenerateurAleatoire extends GenerateurCarte {

    /**
     * Constructeur du générateur de carte aléatoire.
     */
    public GenerateurAleatoire() {
        super(new Random().nextLong()); // Utilisez une graine aléatoire
    }

    /**
     * Constructeur du générateur de carte aléatoire avec une graine spécifique.
     *
     * @param graine La graine utilisée pour la génération de la carte.
     */
    public GenerateurAleatoire(long graine) {
        super(graine);
    }

    /**
     * Implémente la génération d'un terrain aléatoire à une position donnée.
     *
     * @param i        La position verticale dans la carte.
     * @param j        La position horizontale dans la carte.
     * @param largeur  La largeur totale de la carte.
     * @param hauteur  La hauteur totale de la carte.
     * @return Le terrain généré aléatoirement pour la position spécifiée.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        Random random = new Random(getGraine());

        // Génération de valeurs aléatoires pour les caractéristiques du terrain
        double altitude = random.nextDouble(1); // Valeur entre 0 et 1
        double temperature = random.nextDouble(1); // Valeur entre 0 et 1
        double hydrometrie = random.nextDouble(1); // Valeur entre 0 et 1

        return new Terrain(altitude, temperature, hydrometrie);

    }
}
