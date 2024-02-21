package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.VisualiseurTerrain;

public class VisualiseurTerrainEnonce extends VisualiseurTerrain {

	public VisualiseurTerrainEnonce(Carte carte) {
		super(new DetermineurTerrainEnonce(), carte);
	}

	public boolean basse(double valeur) {
		return valeur < 0.3;
	}

	public boolean moyenne(double valeur) {
		return valeur >= 0.3 && valeur < 0.7;
	}

	public boolean haute(double valeur) {
		return valeur >= 0.7;
	}

	public boolean estPlaine(double altitude, double hydrometrie, double temperature) {
		return basse(hydrometrie) && basse(altitude) && (basse(temperature) || moyenne(temperature) || haute(temperature));
	}

	public boolean estForetFeuillus(double altitude, double hydrometrie, double temperature) {
		return basse(hydrometrie) && (basse(altitude) || moyenne(altitude)) && (moyenne(temperature) || haute(temperature));
	}

	public boolean estToundra(double altitude, double hydrometrie, double temperature) {
		return basse(hydrometrie) && basse(altitude) && haute(temperature);
	}

	public boolean estForetConiferes(double altitude, double hydrometrie, double temperature) {
		return basse(hydrometrie) || haute(hydrometrie) && basse(altitude) && moyenne(temperature);
	}

	public boolean estMontagne(double altitude, double hydrometrie, double temperature) {
		return (basse(hydrometrie) || moyenne(hydrometrie) || haute(hydrometrie)) && haute(altitude)
				&& (basse(temperature) || moyenne(temperature) || haute(temperature));
	}

	public boolean estDesert(double altitude, double hydrometrie, double temperature) {
		return basse(hydrometrie) && haute(altitude) && basse(temperature);
	}

	public boolean estCollines(double altitude, double hydrometrie, double temperature) {
		return (basse(hydrometrie) || moyenne(hydrometrie) || haute(hydrometrie))
				&& (moyenne(altitude) || haute(altitude))
				&& (basse(temperature) || moyenne(temperature) || haute(temperature));
	}

	public boolean estMarais(double altitude, double hydrometrie, double temperature) {
		return (moyenne(hydrometrie) || haute(hydrometrie)) && basse(altitude)
				&& (basse(temperature) || moyenne(temperature));
	}

	public boolean estOcean(double altitude) {
		return altitude < 0;
	}

	@Override
	public TypeTerrain getTypeTerrain(int x, int y) {
		double altitude = getCarte().getTerrain(x, y).getAltitude();
		double hydrometrie = getCarte().getTerrain(x, y).getHydrometrie();
		double temperature = getCarte().getTerrain(x, y).getTemperature();

		if (estPlaine(altitude, hydrometrie, temperature)) {
			return TypeTerrain.PLAINE;
		} else if (estForetFeuillus(altitude, hydrometrie, temperature)) {
			return TypeTerrain.FORET_FEUILLUS;
		} else if (estToundra(altitude, hydrometrie, temperature)) {
			return TypeTerrain.TOUNDRA;
		} else if (estForetConiferes(altitude, hydrometrie, temperature)) {
			return TypeTerrain.FORET_CONIFÈRES;
		} else if (estMontagne(altitude, hydrometrie, temperature)) {
			return TypeTerrain.MONTAGNE;
		} else if (estDesert(altitude, hydrometrie, temperature)) {
			return TypeTerrain.DESERT;
		} else if (estCollines(altitude, hydrometrie, temperature)) {
			return TypeTerrain.COLLINES;
		} else if (estMarais(altitude, hydrometrie, temperature)) {
			return TypeTerrain.MARAIS;
		} else if (estOcean(altitude)) {
			return TypeTerrain.OCEAN;
		}
		return null;
	}

}
