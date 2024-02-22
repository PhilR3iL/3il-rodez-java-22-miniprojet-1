package fr.ecole3il.rodez2023.perlin.math;


import fr.ecole3il.rodez2023.perlin.Utils;

/**
 * @author philibert roquart, fainéant
 *
 *
 */
public class BruitPerlin2D extends Bruit2D {
	private final int[] permutation;

	// Tableau de permutations pour le bruit de Perlin
	private static final int[] PERMUTATION = { 151, 160, 137, 91, 90, 15, 131, 13, 201, 95, 96, 53, 194, 233, 7, 225,
			140, 36, 103, 30, 69, 142, 8, 99, 37, 240, 21, 10, 23, 190, 6, 148, 247, 120, 234, 75, 0, 26, 197, 62, 94,
			252, 219, 203, 117, 35, 11, 32, 57, 177, 33, 88, 237, 149, 56, 87, 174, 20, 125, 136, 171, 168, 68, 175, 74,
			165, 71, 134, 139, 48, 27, 166, 77, 146, 158, 231, 83, 111, 229, 122, 60, 211, 133, 230, 220, 105, 92, 41,
			55, 46, 245, 40, 244, 102, 143, 54, 65, 25, 63, 161, 1, 216, 80, 73, 209, 76, 132, 187, 208, 89, 18, 169,
			200, 196, 135, 130, 116, 188, 159, 86, 164, 100, 109, 198, 173, 186, 3, 64, 52, 217, 226, 250, 124, 123, 5,
			202, 38, 147, 118, 126, 255, 82, 85, 212, 207, 206, 59, 227, 47, 16, 58, 17, 182, 189, 28, 42, 223, 183,
			170, 213, 119, 248, 152, 2, 44, 154, 163, 70, 221, 153, 101, 155, 167, 43, 172, 9, 129, 22, 39, 253, 19, 98,
			108, 110, 79, 113, 224, 232, 178, 185, 112, 104, 218, 246, 97, 228, 251, 34, 242, 193, 238, 210, 144, 12,
			191, 179, 162, 241, 81, 51, 145, 235, 249, 14, 239, 107, 49, 192, 214, 31, 181, 199, 106, 157, 184, 84, 204,
			176, 115, 121, 50, 45, 127, 4, 150, 254, 138, 236, 205, 93, 222, 114, 67, 29, 24, 72, 243, 141, 128, 195,
			78, 66, 215, 61, 156, 180 };
	// Vecteurs de gradient pour le bruit de Perlin
	private static final float[][] GRADIENT_2D = {
			{ 1, 1 },
			{ -1, 1 },
			{ 1, -1 },
			{ -1, -1 },
			{ 1, 0 },
			{ -1, 0 },
			{ 0, 1 },
			{ 0, -1 } };

	public BruitPerlin2D(long graine, double resolution) {
		super(graine, resolution);
		this.permutation = Utils.melanger(PERMUTATION,getGraine());
	}

	@Override
	public double bruit2D(double x, double y) {
		double vecteurX, vecteurY, tmp, interpolation1, interpolation2, interpolation3, interpolation4, Cx, Cy, Li1, Li2;
		int ligneX, colonneY, indiceI, indiceJ, indiceG0, indiceG1, indiceG2, indiceG3;

		// Adapter pour la résolution
		x /= getResolution();
		y /= getResolution();

		// Obtenir les coordonnées de la grille associées à (x, y)
		ligneX = (int) (x);
		colonneY = (int) (y);

		// Masquage pour récupérer les indices de permutation
		indiceI = ligneX & 255;
		indiceJ = colonneY & 255;

		// Récupérer les indices de gradient associés aux coins du quadrilatère
		indiceG0 = permutation[(indiceI + permutation[indiceJ % 256]) % 256] % 8;
		indiceG1 = permutation[((indiceI + 1) + permutation[indiceJ % 256]) % 256] % 8;
		indiceG2 = permutation[(indiceI + permutation[(indiceJ + 1) % 256]) % 256] % 8;
		indiceG3 = permutation[(indiceI + 1 + permutation[(indiceJ + 1) % 256]) % 256] % 8;

		// Récupérer les vecteurs de gradient et effectuer des interpolations pondérées
		vecteurX = x - ligneX;
		vecteurY = y - colonneY;
		interpolation1 = GRADIENT_2D[indiceG0][0] * vecteurX + GRADIENT_2D[indiceG0][1] * vecteurY;

		vecteurX = x - (ligneX + 1);
		vecteurY = y - colonneY;
		interpolation2 = GRADIENT_2D[indiceG1][0] * vecteurX + GRADIENT_2D[indiceG1][1] * vecteurY;

		vecteurX = x - ligneX;
		vecteurY = y - (colonneY + 1);
		interpolation3 = GRADIENT_2D[indiceG2][0] * vecteurX + GRADIENT_2D[indiceG2][1] * vecteurY;

		vecteurX = x - (ligneX + 1);
		vecteurY = y - (colonneY + 1);
		interpolation4 = GRADIENT_2D[indiceG3][0] * vecteurX + GRADIENT_2D[indiceG3][1] * vecteurY;

		// Interpolations pour lisser les valeurs obtenues
		tmp = x - ligneX;
		Cx = 3 * Math.pow(tmp,2) - 2 * Math.pow(tmp,3);

		Li1 = interpolation1 + Cx * (interpolation2 - interpolation1);
		Li2 = interpolation3 + Cx * (interpolation4 - interpolation3);

		tmp = y - colonneY;
		Cy = 3 * Math.pow(tmp,2) - 2 * Math.pow(tmp,3);

		return Li1 + Cy * (Li2 - Li1);
	}
}
