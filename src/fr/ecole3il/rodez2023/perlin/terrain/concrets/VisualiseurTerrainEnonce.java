package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.VisualiseurTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
public class VisualiseurTerrainEnonce extends VisualiseurTerrain {
	public VisualiseurTerrainEnonce(Carte c) {
		super(c, new DetermineurTerrainEnonce());
	}

}