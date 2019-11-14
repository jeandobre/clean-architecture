package br.exemplo.hashAndEqual;

import javafx.scene.paint.Color;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    //Quebrado: viola a simetria
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ColorPoint)) return false;

        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    //Não mude Object por outro tipo  na declaração do equals
    //Não faça isso
    //Esse método não sobrescreve, ele sobrecarrega o método
    public boolean equals(ColorPoint o){
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
