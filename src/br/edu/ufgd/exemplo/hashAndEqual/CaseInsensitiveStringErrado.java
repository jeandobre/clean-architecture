package br.edu.ufgd.exemplo.hashAndEqual;

import java.util.Objects;

public final class CaseInsensitiveStringErrado {
    private final String s;

    public CaseInsensitiveStringErrado(String s) {
        this.s = Objects.requireNonNull(s);
    }

    //Quebrado: Viola a simetria
    @Override
    public boolean equals(Object o) {
        if(o instanceof CaseInsensitiveStringErrado)
            return s.equalsIgnoreCase(((CaseInsensitiveStringErrado) o).s);
        if(o instanceof String) //Interoperabilidade unilateral
            return s.equalsIgnoreCase((String) o);
        return false;
    }

}
