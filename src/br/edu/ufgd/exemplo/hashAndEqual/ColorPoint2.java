package br.edu.ufgd.exemplo.hashAndEqual;

import javafx.scene.paint.Color;

public class ColorPoint2 extends Point {
    private final Color color;

    public ColorPoint2(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    //Quebrado: viola a transitividade
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)) return false;

        //se o é um Point normal, faça a comparação daltônica
        if(!(o instanceof ColorPoint)) return o.equals(this);

        // é um ColorPoint; faça uma comparação completa
        return super.equals(o) && ((ColorPoint2) o).color == color;
    }

}
