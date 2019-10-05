package br.edu.ufgd.exemplo.services;

public class NovoClienteProvider implements Provider {

    @Override
    public Service newService() {
        return new NovoClienteService();
    }
}
