package br.edu.ufgd.ddd.specification.exemplo2;

import br.edu.ufgd.ddd.specification.Specification;

public class OrSpecification extends AbstractSpecification {

    Specification one;
    Specification other;

    public OrSpecification(Specification one, Specification other) {
        this.one = one;
        this.other = other;
    }

    @Override
    public boolean isSatisfiedBy(Object candidate) {
        return one.isSatisfiedBy(candidate) || other.isSatisfiedBy(candidate);
    }
}
