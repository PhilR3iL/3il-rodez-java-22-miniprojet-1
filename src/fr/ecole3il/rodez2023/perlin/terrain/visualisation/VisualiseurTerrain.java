package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;


public class VisualiseurTerrain {
        private Carte carte;
        private DetermineurTerrain determineurTerrain;

        public VisualiseurTerrain( DetermineurTerrain determineurTerrain,Carte carte) {
            this.carte = carte;
            this.determineurTerrain = determineurTerrain;
        }

    public TypeTerrain getTypeTerrain(int x, int y) {
        return determineurTerrain.determinerTerrain(carte.getTerrain(x,y).getAltitude(),carte.getTerrain(x,y).getHydrometrie(),carte.getTerrain(x,y).getTemperature());
    }

    public String getAltitudeAffichee(int x, int y) {
        return altitudeAffichee(carte.getTerrain(x,y).getAltitude()) ;
    }

    public String getHydrometrieAffichee(int x, int y) {
        return hydrometrieAffichee(carte.getTerrain(x,y).getHydrometrie());
    }

    public String getTemperatureAffichee(int x, int y) {
        return temperatureAffichee(carte.getTerrain(x,y).getTemperature());
    }

    public String altitudeAffichee(double valeur) {
        if (valeur < 0.33) {
            return "Basse";
        } else if (valeur < 0.66) {
            return "Moyenne";
        } else {
            return "Elevee";
        }
    }

    public String hydrometrieAffichee(double valeur) {
        if (valeur < 0.33) {
            return "Sec";
        } else if (valeur < 0.66) {
            return "Moyen";
        } else {
            return "Humide";
        }
    }

    public String temperatureAffichee(double valeur) {
        if (valeur < 0.33) {
            return "Froid";
        } else if (valeur < 0.66) {
            return "Tempere";
        } else {
            return "Chaud";
        }
    }

    public Carte getCarte() {
        return carte;
    }
}



