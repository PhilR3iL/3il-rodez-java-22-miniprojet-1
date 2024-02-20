package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.Utils;

import java.awt.image.BufferedImage;

public enum TypeTerrain {
    COLLINES,
    DESERT,
    FORET_DE_CONIFERES,
    FORET_DE_FEUILLUS,
    MARAIS,
    MONTAGNE,
    OCEAN,
    PLAINE,
    TOUNDRA;

    public BufferedImage getImage() {
        String nomFichier = switch (this) {
            case COLLINES -> "hills.png";
            case DESERT -> "desert.png";
            case FORET_DE_CONIFERES -> "coniferous_forest.png";
            case FORET_DE_FEUILLUS -> "deciduous_forest.png";
            case MARAIS -> "marsh.png";
            case MONTAGNE -> "mountain.png";
            case OCEAN -> "ocean.png";
            case PLAINE -> "plain.png";
            case TOUNDRA -> "tundra.png";
        };
        return Utils.chargerTuile(nomFichier);
    }

    public String toString() {
        return switch (this) {
            case COLLINES -> "Collines";
            case DESERT -> "Désert";
            case FORET_DE_CONIFERES -> "Forêt de conifères";
            case FORET_DE_FEUILLUS -> "Forêt de feuillus";
            case MARAIS -> "Marais";
            case MONTAGNE -> "Montagne";
            case OCEAN -> "Océan";
            case PLAINE -> "Plaine";
            case TOUNDRA -> "Toundra";
        };
    }
}