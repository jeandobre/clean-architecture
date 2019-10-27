package br.edu.ufgd.DDD.Specification.exemplo2;

import br.edu.ufgd.DDD.Specification.Specification;

public class NotSpecification extends AbstractSpecification {

    Specification wrapped;

    public NotSpecification(Specification x) {
        wrapped = x;
    }

    @Override
    public boolean isSatisfiedBy(Object candidate) {
        return !wrapped.isSatisfiedBy(candidate);
    }
}
