package fr.ecole3il.rodez2023.perlin.math;

public class SuperBruitPerlin2D extends Bruit2D {

    public SuperBruitPerlin2D(long graine, double resolution) {
        super(graine, resolution);
    }

    @Override
    public double bruit2D(double x, double y) {
        return 0;
    }

    /**
     * Cette méthode multiplie la composante x du vecteur par la distance x, et la composante y par la distance y,
     * puis renvoie la somme des deux produits.
     *
     * @param vecteur tableau représentant les composantes x et y du vecteur
     * @param x       la distance x
     * @param y       la distance y
     * @return vecteur.x * x + vecteur.y * y
     */
    private double produitScalaire(double[] vecteur, double x, double y) {
        double vecX = vecteur[0];
        double vecY = vecteur[1];

        return vecX * x + vecY * y;
    }

    /**
     * Cette méthode applique une fonction de lissage à une valeur donnée t.
     * La fonction de lissage utilisée ici est spécifique à l'algorithme du bruit de Perlin.
     *
     * @param t la valeur à lisser
     * @return le résultat du lissage
     */
    private double lissage(double t) {
        return t * t * t * (t * (t * 6 - 15) + 10); // Fonction de lissage correcte pour le bruit de Perlin
    }

    /**
     * Cette méthode effectue une interpolation linéaire entre deux valeurs a et b en utilisant un coefficient t comme facteur de mélange.
     *
     * @param t facteur de mélange
     * @param a première valeur
     * @param b deuxième valeur
     * @return la valeur interpolée
     */
    private double interpolation(double t, double a, double b) {
        return a + t * (b - a);
    }
}
