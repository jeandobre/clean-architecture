package br.exemplo.hashAndEqual;

import javafx.scene.paint.Color;

import java.util.Objects;

//Componentes de valores adicionados sem violar o contrato do equals
public class ColorPointCorreto {
    private final Point point;
    private final Color color;

    public ColorPointCorreto(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * Retorne a view da point desse ponto colorido.
     *
     * @return Point
     */
    public Point asPoint(){
        return point;
    }

    @Override
    public boolean equals(Object o) {
        //o instaceof já testa o nullpointer
        if(!(o instanceof ColorPointCorreto)) return false;

        ColorPointCorreto cp = (ColorPointCorreto) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
