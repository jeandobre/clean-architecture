package br.exemplo.classesMarcadas;

//Exemplo de classe marcada - muito inferior a uma hierarquia de classes
class FigureIncorreta {

    enum Shape { RECTANGLE, CIRCLE};

    //campo marcador - a forma dessa figura
    final Shape shape;

    //Esses campos só são usados quando a forma é RECTANGLE
    double length;
    double width;

    //Esse campo só é usado quando a forma é CIRCLE
    double radius;

    //Contrutor do circulo
    public FigureIncorreta(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    //Construtor do retangulo
    public FigureIncorreta(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area(){
        switch(shape){
            case RECTANGLE: return length * width;
            case CIRCLE: return Math.PI * (radius * radius);
            default: throw new AssertionError();
        }
    }

}
