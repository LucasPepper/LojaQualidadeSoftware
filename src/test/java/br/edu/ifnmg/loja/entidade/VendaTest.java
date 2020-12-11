package br.edu.ifnmg.loja.entidade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class VendaTest {

    Produto sabonete = new Produto("Sabonete", 10, 2.00);
    Produto desodorante = new Produto("Desodorante", 20, 15.00);
    HashMap<Produto, Integer> mapaVendaProdutoQuantidade = new HashMap<>();
    Venda venda = new Venda(mapaVendaProdutoQuantidade);

    @Test
    public void testCalcularValorVenda() {

        mapaVendaProdutoQuantidade.put(sabonete, 5);
        mapaVendaProdutoQuantidade.put(desodorante, 2);
        double valorVenda = venda.calcularValorVenda();
        assertEquals(40, valorVenda);
    }
}