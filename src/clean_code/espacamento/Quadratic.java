package clean_code.espacamento;

public class Quadratic {

    public static double root1(double a, double b, double c){
        double determinant = determinant(a, b, c);
        return (-b + Math.sqrt(determinant)) / (2*a);
    }

    //Espaços entre parâmetros
    //não deixar espaços entre o parêntese da função
    public static double root2(int a, int b, int c){
        double determinant = determinant(a, b, c);
        return (-b - Math.sqrt(determinant)) / (2*a);
    }

    public static double determinant(double a, double b, double c){
        return b*b - 4*a*c;
    }
}
