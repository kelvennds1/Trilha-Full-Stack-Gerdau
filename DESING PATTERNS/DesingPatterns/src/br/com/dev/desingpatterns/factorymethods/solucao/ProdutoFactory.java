package br.com.dev.desingpatterns.factorymethods.solucao;

import br.com.dev.desingpatterns.factorymethods.Produto;
import br.com.dev.desingpatterns.factorymethods.ProdutoDigital;
import br.com.dev.desingpatterns.factorymethods.ProdutoFisico;
import br.com.dev.desingpatterns.factorymethods.TipoProdutoEnum;

public class ProdutoFactory {
    public  static Produto getInstance(TipoProdutoEnum tipoProdutoEnum){
        switch (tipoProdutoEnum){
            case FISICO:
                ProdutoFisico produtoFisico = new ProdutoFisico();
                produtoFisico.setPossuiDimensoesFisicas(true);
                return produtoFisico;
            case DIGITAL:
                ProdutoDigital produtoDigital = new ProdutoDigital();
                produtoDigital.setPossuiDimensoesFisicas(false);
                return produtoDigital;
            default:
                throw new IllegalArgumentException("Tipo de produto não disponivel");
        }
    }
}
