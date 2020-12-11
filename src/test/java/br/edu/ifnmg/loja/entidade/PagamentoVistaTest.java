package br.edu.ifnmg.loja.entidade;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class PagamentoVistaTest {

    Produto desodorante = new Produto("Desodorante", 20, 150.00);
    HashMap<Produto, Integer> mapaVendaProdutoQuantidade = new HashMap<>();

    @Test
    public void testCalcularValorVista() {
        mapaVendaProdutoQuantidade.put(desodorante, 10);
        Venda venda = new Venda(mapaVendaProdutoQuantidade);
        PagamentoVista pagamentoVista = new PagamentoVista(venda);
        double valorAVista = pagamentoVista.calcularValorVista();
        assertEquals(1350, valorAVista);
    }

}