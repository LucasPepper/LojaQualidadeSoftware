package br.edu.ifnmg.loja.entidade;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class PagamentoPrazoTest {

    Produto desodorante = new Produto("Desodorante", 20, 150.00);
    HashMap<Produto, Integer> mapaVendaProdutoQuantidade = new HashMap<>();

    @Test
    public void testCalcularValorParcelas() {
        mapaVendaProdutoQuantidade.put(desodorante, 10);
        Venda venda = new Venda(mapaVendaProdutoQuantidade);
        PagamentoPrazo pagamentoPrazo =  new PagamentoPrazo(venda, 2);
        double valorParcelas = pagamentoPrazo.calcularValorParcelas();
        assertEquals(750, valorParcelas);
    }
}