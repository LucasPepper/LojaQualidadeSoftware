package br.edu.ifnmg.loja.entidade;

public class PagamentoVista extends Pagamento{

    private static final double DESCONTO_VISTA = 0.1;

    public PagamentoVista(Venda venda) {
        super(venda);
    }

    public double calcularValorVista() {
        return this.venda.calcularValorVenda() * (1 - DESCONTO_VISTA);
    }
}
