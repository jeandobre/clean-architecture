package br.edu.ufgd.exemplo.skeletal;

import java.util.Map;
import java.util.Objects;

public abstract class AbstractMapEntry<K,V> implements Map.Entry<K,V> {

    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    // Implementa o contrato geral da Map.Entry.hashCode
    @Override
    public int hashCode() {
        return Objects.hashCode(getKey())
                ^ Objects.hashCode(getValue());
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Map.Entry)) return false;
        if(o == this) return true;
        Map.Entry<?,?> entry = (Map.Entry) o;
        return Objects.equals(entry.getKey(), getKey())
                && Objects.equals(entry.getValue(), getValue());
    }

    @Override
    public String toString() {
        return getKey() + "=" + getValue();
    }
}
