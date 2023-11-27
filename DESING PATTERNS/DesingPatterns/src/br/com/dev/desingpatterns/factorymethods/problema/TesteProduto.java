package br.com.dev.desingpatterns.factorymethods.problema;

import br.com.dev.desingpatterns.factorymethods.ProdutoDigital;
import br.com.dev.desingpatterns.factorymethods.ProdutoFisico;

public class TesteProduto {
    public static void main(String[] args) {
        ProdutoFisico produtoFisico = new ProdutoFisico();
        produtoFisico.setPossuiDimensoesFisicas(true);

        ProdutoDigital produtoDigital = new ProdutoDigital();
        produtoDigital.setPossuiDimensoesFisicas(false);
    }
}
