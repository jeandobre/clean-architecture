package br.exemplo.services;

import org.junit.Test;

public class ServicesTest {

    @Test
    public void registrarServicosCorretamente(){

       NovoClienteProvider novoClienteProvider = new NovoClienteProvider();
       Services.registerDefaultProvider(novoClienteProvider);

       NovoClienteService servico1 = (NovoClienteService) novoClienteProvider.newService();
       servico1.novoCadastroDeClientes();

       RemoverProdutoProvider removerProdutoProvider = new RemoverProdutoProvider();
       Services.registerDefaultProvider(removerProdutoProvider);

       RemoverProdutoService servico = (RemoverProdutoService) removerProdutoProvider.newService();
       servico.removerProduto();

    }

}
