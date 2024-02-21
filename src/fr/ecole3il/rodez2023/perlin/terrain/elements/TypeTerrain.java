package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.Utils;

import java.awt.image.BufferedImage;

public enum TypeTerrain {
    OCEAN("ocean", "ocean.png"), PLAINE("plain", "plain.png"), FORET_FEUILLUS("deciduous_forest", "deciduous_forest.png"),
    MONTAGNE("mountain", "mountain.png"), DESERT("desert", "desert.png"), COLLINES("hills", "hills.png"), MARAIS("marsh", "marsh.png"),
    FORET_CONIFÈRES("coniferous_forest", "coniferous_forest.png"), TOUNDRA("toundra", "toundra.png");

    private final String nomTerrain;
    private final String path;

    TypeTerrain(String nomTerrain, String path) {
        this.nomTerrain = nomTerrain;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public BufferedImage getImage() {
        return Utils.chargerTuile(this.getPath());
    }

    @Override
    public String toString() {
        return nomTerrain;
    }
}
