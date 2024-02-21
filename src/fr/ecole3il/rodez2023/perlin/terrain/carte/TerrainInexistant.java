package fr.ecole3il.rodez2023.perlin.terrain.carte;

public class TerrainInexistant extends IndexOutOfBoundsException {
    public TerrainInexistant(String s) {
        super(s);
    }
}
