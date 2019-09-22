package br.edu.ufgd.exemploServices;

public class NovoClienteProvider implements Provider {

    @Override
    public Service newService() {
        return new NovoClienteService();
    }
}
