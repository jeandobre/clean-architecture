package br.exemplo.hashAndEqual;

import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Objects;

public class ColorTest {

    @Test
    public void deveDarErroQuandoCompararColorPoint(){

        br.exemplo.hashAndEqual.Point p = new br.exemplo.hashAndEqual.Point(1,2);
        ColorPoint cp = new ColorPoint(1,2, Color.RED);

        Assert.assertTrue(p.equals(cp));

        //Aqui está vindo como false pois está incorreta a
        // implementação de equals
        Assert.assertFalse(cp.equals(p));

    }

    //StackOverflow
    @Test
    public void deveDarErroQuandoCompararColorPoint2(){
        ColorPoint2 p1 = new ColorPoint2(1,2, Color.RED);
        br.exemplo.hashAndEqual.Point p2 = new br.exemplo.hashAndEqual.Point(1,2);
        ColorPoint2 p3 = new ColorPoint2(1,2, Color.BLUE);

        Assert.assertTrue(p1.equals(p2));
        Assert.assertTrue(p2.equals(p3));
        Assert.assertTrue(p1.equals(p3));
    }

    @Test
    public void testarIgualdadeDeEnderecos(){
        br.exemplo.hashAndEqual.Point x = new br.exemplo.hashAndEqual.Point(1,2);
        br.exemplo.hashAndEqual.Point y = new Point(1,2);

        //testar igualdade de objetos
        Assert.assertTrue(x.equals(y));
        //testar referecia de objeto.
        Assert.assertFalse(x == y);

        Assert.assertTrue(Objects.equals(x, y));

    }



}
