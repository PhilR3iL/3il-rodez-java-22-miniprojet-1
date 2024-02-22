package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.exception.TerrainInexistant;
import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

public abstract class VisualiseurTerrain {
    private DetermineurTerrain determineurTerrain;
    private Carte carte;
    public VisualiseurTerrain(Carte carte, DetermineurTerrain determineurTerrain){
        this.carte=carte;
        this.determineurTerrain=determineurTerrain;
    }


    public AltitudeAffichee getAltitudeAffichee(int x, int y) throws TerrainInexistant {
        Terrain terrain = carte.getTerrain(x, y);
        double altitude = ((Terrain) terrain).getAltitude();

        if (altitude < 0) {
            return AltitudeAffichee.FondMarin;
        } else if (altitude < AltitudeAffichee.Basse.getValeurAltitude()) {
            return AltitudeAffichee.Basse;
        } else if (altitude < AltitudeAffichee.Moyenne.getValeurAltitude()) {
            return AltitudeAffichee.Moyenne;
        } else {
            return AltitudeAffichee.elevee;
        }
    }


    public HydrometrieAffichee getHydrometrieAffichee(int x, int y) throws TerrainInexistant {
        Terrain terrain = carte.getTerrain(x, y);
        double hydrometrie = terrain.getHydrometrie();

        if (hydrometrie < HydrometrieAffichee.Sec.getValeurHydrometrie()) {
            return HydrometrieAffichee.Sec;
        } else if (hydrometrie < HydrometrieAffichee.Moyen.getValeurHydrometrie()) {
            return HydrometrieAffichee.Moyen;
        } else {
            return HydrometrieAffichee.Humide;
        }
    }


    public TemperatureAffichee getTemperatureAffichee(int x, int y) throws TerrainInexistant {
        Terrain terrain = carte.getTerrain(x, y);
        double temperature = terrain.getTemperature();

        if (temperature < TemperatureAffichee.Froid.getValeurLimite()) {
            return TemperatureAffichee.Froid;
        } else if (temperature < TemperatureAffichee.Tempere.getValeurLimite()) {
            return TemperatureAffichee.Tempere;
        } else {
            return TemperatureAffichee.Chaud;
        }
    }


    public TypeTerrain getTypeTerrain(int x, int y) throws TerrainInexistant {
        Terrain terrain = carte.getTerrain(x, y);
        TypeTerrain typeTerrain = determineurTerrain.determinerTerrain(terrain.getAltitude(), terrain.getHydrometrie(), terrain.getTemperature());
        return typeTerrain;
    }
    public DetermineurTerrain getDetermineurTerrain() {
        return determineurTerrain;
    }
    public Carte getCarte() {
        return carte;
    }
}
