package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.exception.TerrainInexistant;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

import java.util.Locale;
import java.util.Scanner;

public class Carte {
    private String nom;
    private int largeur;
    private int hauteur;
    private Terrain[][] terrains;
    public String getNom() {
        return nom;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Terrain getTerrain(int x, int y) throws TerrainInexistant {
        if(x<0||y<0 || x>= largeur || y>= hauteur){
            throw  new TerrainInexistant(String.format("Terrain inexistant à la position (%d, %d)",x,y));
        }

        return terrains[x][y];
    }

    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateurCarte) {
        this.nom=nom;
        this.largeur=largeur;
        this.hauteur=hauteur;
        terrains=generateurCarte.genererCarte(largeur,hauteur);
    }
    public Carte(String donneesCarte) {
        Scanner scanner = new Scanner(donneesCarte);
        scanner.useLocale(Locale.US);
        this.nom = scanner.nextLine();
        this.largeur = Integer.parseInt(scanner.nextLine());
        this.hauteur = Integer.parseInt(scanner.nextLine());

        this.terrains = new Terrain[this.hauteur][this.largeur];
        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                double altitude = scanner.nextDouble();
                double hydrometrie = scanner.nextDouble();
                double temperature = scanner.nextDouble();
                this.terrains[i][j] = new Terrain(altitude, hydrometrie, temperature);
            }
        }

        scanner.close();
    }
}
