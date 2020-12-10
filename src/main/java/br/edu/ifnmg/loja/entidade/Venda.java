package br.edu.ifnmg.loja.entidade;

import java.util.HashMap;
import java.util.Map;

public class Venda {
    private HashMap<Produto, Integer> mapaProdutoQuantidade;

    public Venda(HashMap<Produto, Integer> mapaProdutoQuantidade){
        this.mapaProdutoQuantidade = mapaProdutoQuantidade;
        this.validarCodigoProduto();
        this.validarQuantidade();
        this.verificarEstoque();

    }

    private void validarQuantidade() {
        for (Map.Entry<Produto, Integer> entry : mapaProdutoQuantidade.entrySet()) {
            if (entry.getValue() < 1){
                throw new RuntimeException("Quantidade inválida!");
            }
        }
    }

    private void verificarEstoque() {
        for (Map.Entry<Produto, Integer> entry : mapaProdutoQuantidade.entrySet()) {
            if (entry.getValue() > entry.getKey().getEstoque()){
                throw new RuntimeException("Estoque insuficiente!");
            }
        }
    }

    private void validarCodigoProduto() {
        for (Map.Entry<Produto, Integer> entry : mapaProdutoQuantidade.entrySet()) {
            if (entry.getKey().getId() < 1 ||
                    entry.getKey().getId() > Produto.getTotalProdutos()){
                throw new RuntimeException("Código do produto inválido!");
            }
        }
    }

    // TODO: Teste unitário
    public double calcularValorVenda(){
        double valorTotal = 0;
        // Iterador para o HashMap dos itens da venda.
        for (Map.Entry<Produto, Integer> entry : mapaProdutoQuantidade.entrySet()) {
            /* System.out.println("Key = " + entry.getKey().getDescricao() +
                    ", Value = " + entry.getValue());
            */
            valorTotal += entry.getKey().getPreco() * entry.getValue();
        }

        return valorTotal;
    }
}
