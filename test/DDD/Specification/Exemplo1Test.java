package DDD.Specification;

import br.edu.ufgd.ddd.specification.exemplo1.ContainerSpecification;
import br.edu.ufgd.ddd.specification.exemplo1.Feature;
import br.edu.ufgd.ddd.specification.Specification;
import org.junit.Test;

/**
 * Livro DDD Evans
 * Página 262-263
 * Capítulo 10: Design Flexível
 *
 */
public class Exemplo1Test {

    @Test
    public void validarImplementacaoAmbas(){

        Specification ventiled = new ContainerSpecification(Feature.VENTILATED);
        Specification armored = new ContainerSpecification(Feature.ARMORED);

        Specification both = ventiled.and(armored);
    }

    @Test
    public void validarImplementacaoOuUmaOuOutra(){

        Specification ventilatedType1 = new ContainerSpecification(Feature.VENTILATED_TYPE_1);
        Specification ventilatedType2 = new ContainerSpecification(Feature.VENTILATED_TYPE_2);

        Specification either = ventilatedType1.or(ventilatedType2);
    }

    @Test
    public void validarImplementacaoNot(){

        Specification ventiled = new ContainerSpecification(Feature.VENTILATED);
        Specification armored = new ContainerSpecification(Feature.ARMORED);

        Specification cheap = (ventiled.not()).and(armored.not());
    }
}
