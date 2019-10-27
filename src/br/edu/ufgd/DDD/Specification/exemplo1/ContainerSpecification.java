package br.edu.ufgd.DDD.Specification.exemplo1;

import br.edu.ufgd.DDD.Specification.Specification;

/**
 * Livro DDD Evans
 * Página 262-263
 * Capítulo 10: Design Flexível
 *
 */
public class ContainerSpecification implements Specification {

    private Feature requiredFeature;

    public ContainerSpecification(Feature requiredFeature) {
        this.requiredFeature = requiredFeature;
    }

    @Override
    public boolean isSatisfiedBy(Object candidate) {

        if(!(candidate instanceof Container)) return false;

        return ((Container) candidate).getFeatures().contains(requiredFeature);
    }

    @Override
    public Specification and(Specification other) {
        return this;
    }

    @Override
    public Specification or(Specification other) {
        return this;
    }

    @Override
    public Specification not() {
        return this;
    }
}
