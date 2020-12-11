package br.edu.ifnmg.loja.entidade;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoTest {

    Produto desodorante = new Produto("Desodorante", 20, 150.00);
    HashMap<Produto, Integer> mapaVendaProdutoQuantidade = new HashMap<>();
    HashMap<Produto, Integer> mapaVendaProdutoQuantidade2 = new HashMap<>();

    @Test
    void calcularValorVista() {
        mapaVendaProdutoQuantidade.put(desodorante, 10);
        Venda venda = new Venda(mapaVendaProdutoQuantidade);
        Pagamento pagamentoVista = new Pagamento(venda);
        double valorAVista = pagamentoVista.calcularValorVista();
        assertEquals(1350, valorAVista);

    }

    @Test
    void calcularValorParcelas() {
        mapaVendaProdutoQuantidade2.put(desodorante, 10);
        Venda venda2 = new Venda(mapaVendaProdutoQuantidade2);
        Pagamento pagamentoParcelado =  new Pagamento(venda2, 2);
        double valorParcelas = pagamentoParcelado.calcularValorParcelas();
        assertEquals(750, valorParcelas);
    }
}