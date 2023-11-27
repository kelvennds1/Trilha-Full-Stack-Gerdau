package br.com.dev.desingpatterns.factorymethods.solucao;

import br.com.dev.desingpatterns.factorymethods.Produto;
import br.com.dev.desingpatterns.factorymethods.TipoProdutoEnum;

public class TesteProdutoFactoryMethod {
    public static void main(String[] args) {
        Produto produtoDigital = ProdutoFactory.getInstance(TipoProdutoEnum.DIGITAL);
        Produto produtoFisico= ProdutoFactory.getInstance(TipoProdutoEnum.FISICO);

        System.out.println(produtoDigital);
        System.out.println(produtoFisico);
    }
}
