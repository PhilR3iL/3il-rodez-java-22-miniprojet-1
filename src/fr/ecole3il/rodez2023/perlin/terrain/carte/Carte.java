package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurAleatoire;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurPerlin;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;
import java.util.Scanner;
public class Carte {
    private int largeur;
    private int hauteur;

    private String nom;

    private Terrain [][] tabTerrain;

    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateurCarte){
        this.nom = nom;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.tabTerrain = generateurCarte.genererCarte(largeur,hauteur);
    }

    public  Carte(String donneesCarte){
            Scanner scanner = new Scanner(donneesCarte);

            // Lecture des métadonnées de la carte
            this.nom = scanner.nextLine();
            this.largeur = scanner.nextInt();
            this.hauteur = scanner.nextInt();

            this.tabTerrain = new Terrain[largeur][hauteur];
             // Lecture des données de terrain
            for (int y = 0; y < largeur; y++) {
                    for (int x = 0; x < hauteur ; x++) {
                        double altitude = scanner.nextDouble();
                        double hydrometrie = scanner.nextDouble();
                        double temperature = scanner.nextDouble();

                        tabTerrain[x][y] = new Terrain(altitude, hydrometrie, temperature);
                    }
                }
                scanner.close();
        }





    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public String getNom() {
        return nom;
    }

    public Terrain getTerrain(int x, int y) {
        if ( x < 0 || x >= tabTerrain.length || y < 0 || y >= tabTerrain[0].length ) {
            throw new TerrainInexistant("La position [" + x + "][" + y + "] est invalide.");
        }
        return tabTerrain[x][y];
    }


}
