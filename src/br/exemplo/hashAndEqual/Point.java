package br.exemplo.hashAndEqual;

import java.util.Objects;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    // Para comparar float e double use o Float.compare e o Double.compare ao invés
    // de Float.equals e Double.equals (Pois internamente eles fazem autoboxing de
    // cada comparação)
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    //Método hashCode de uma linha - desempenho fraco
    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }
}
