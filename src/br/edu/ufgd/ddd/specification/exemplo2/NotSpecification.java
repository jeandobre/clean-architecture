package br.edu.ufgd.ddd.specification.exemplo2;

import br.edu.ufgd.ddd.specification.Specification;

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
