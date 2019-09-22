package br.edu.ufgd.exemploServices;

public class RemoverProdutoProvider implements Provider {

    @Override
    public Service newService() {
        return new RemoverProdutoService();
    }
}
