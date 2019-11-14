package br.exemplo.enums;

public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6),
    MARS(6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURNS(5.685e+26, 6.027e7),
    URANUS(8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    //Todos os campos devem ser finais, pois o enum é imutável
    private final double mass;           // em quilogramas
    private final double radius;         // em metros
    private final double surfaceGravity; // em m /s^2

    //Constante gravitacional universal em m^3 / kg s^2
    private static final double G = 6.6730E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass){
        return mass * surfaceGravity; // F = ma
    }
}
