package br.exemplo.singleton;

import org.junit.Assert;
import org.junit.Test;

public class StringLenthComparatorTest {

    @Test
    public void testarObjetoDeFuncao(){
        int i1 = StringLengthComparator.INSTANCE.compare("Jean", "Paulo");
        Assert.assertEquals(-1, i1);

        int i2 = StringLengthComparator.INSTANCE.compare("Jean", "Joao");
        Assert.assertEquals(0, i2);

        int i3 = StringLengthComparator.INSTANCE.compare("Antonio", "Joao");
        Assert.assertEquals(3, i3);
    }
}
