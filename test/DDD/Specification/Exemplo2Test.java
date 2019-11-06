package DDD.Specification;

import br.edu.ufgd.DDD.Specification.Specification;
import br.edu.ufgd.DDD.Specification.exemplo1.ContainerSpecification;
import br.edu.ufgd.DDD.Specification.exemplo1.Feature;
import br.edu.ufgd.DDD.Specification.exemplo2.AndSpecification;
import br.edu.ufgd.DDD.Specification.exemplo2.NotSpecification;
import br.edu.ufgd.DDD.Specification.exemplo2.OrSpecification;
import org.junit.Test;

/**
 * Livro DDD Evans
 * Página 262-263
 * Capítulo 10: Design Flexível
 *
 */
public class Exemplo2Test {

    @Test
    public void validarImplementacaoAmbas(){

        Specification ventiled = new ContainerSpecification(Feature.VENTILATED);
        Specification armored = new ContainerSpecification(Feature.ARMORED);

        new AndSpecification(ventiled, armored);
    }

    @Test
    public void validarImplementacaoOuUmaOuOutra(){

        Specification ventilatedType1 = new ContainerSpecification(Feature.VENTILATED_TYPE_1);
        Specification ventilatedType2 = new ContainerSpecification(Feature.VENTILATED_TYPE_2);

        new OrSpecification(ventilatedType1, ventilatedType2);
    }

    @Test
    public void validarImplementacaoNot(){

        Specification ventiled = new ContainerSpecification(Feature.VENTILATED);
        Specification armored = new ContainerSpecification(Feature.ARMORED);

        new NotSpecification(ventiled);
        new NotSpecification(armored);
    }
}
