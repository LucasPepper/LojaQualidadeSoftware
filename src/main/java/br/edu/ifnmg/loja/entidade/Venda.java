package br.edu.ifnmg.loja.entidade;

import java.util.HashMap;
import java.util.Map;

public class Venda {
    private HashMap<Produto, Integer> mapaProdutoQuantidade;
    private double valorTotal;

    public Venda(HashMap<Produto, Integer> mapaProdutoQuantidade){
        this.mapaProdutoQuantidade = mapaProdutoQuantidade;
    }

    // TODO: Teste unitário
    public double calcularValorVenda(){

        // Iterador para o HashMap dos itens da venda.
        // TODO: Bug: está acessando o índice errado
        for (Map.Entry<Produto, Integer> entry : mapaProdutoQuantidade.entrySet()) {
            System.out.println("Key = " + entry.getKey().getDescricao() +
                    ", Value = " + entry.getValue());

            valorTotal += entry.getKey().getPreco() * entry.getValue();
        }

        return valorTotal;
    }
}
