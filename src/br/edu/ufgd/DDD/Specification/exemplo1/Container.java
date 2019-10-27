package br.edu.ufgd.DDD.Specification.exemplo1;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<Feature> features;

    public Container() {
        this.features = new ArrayList();
    }

    public List<Feature> getFeatures() {
        return features;
    }
}
