package br.edu.ufgd.exemplo.hashAndEqual;

import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Objects;
import java.util.Set;

public class ColorTest {

    @Test
    public void deveDarErroQuandoCompararColorPoint(){

        Point p = new Point(1,2);
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
        Point p2 = new Point(1,2);
        ColorPoint2 p3 = new ColorPoint2(1,2, Color.BLUE);

        Assert.assertTrue(p1.equals(p2));
        Assert.assertTrue(p2.equals(p3));
        Assert.assertTrue(p1.equals(p3));
    }

    @Test
    public void testarIgualdadeDeEnderecos(){
        Point x = new Point(1,2);
        Point y = new Point(1,2);

        //testar igualdade de objetos
        Assert.assertTrue(x.equals(y));
        //testar referecia de objeto.
        Assert.assertFalse(x == y);

        Assert.assertTrue(Objects.equals(x, y));

    }



}
