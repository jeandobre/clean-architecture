package br.exemplo.services;

public class RemoverProdutoProvider implements Provider {

    @Override
    public Service newService() {
        return new RemoverProdutoService();
    }
}
