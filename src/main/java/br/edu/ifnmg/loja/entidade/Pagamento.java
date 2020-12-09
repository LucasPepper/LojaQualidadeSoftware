package br.edu.ifnmg.loja.entidade;

public class Pagamento {
    private Venda venda;
    private String forma;

    public Pagamento(Venda venda, int numeroParcelas) {
    }

    // TODO: Teste unitário
    public double calcularValorVista() {
        return 0;
    }

    // TODO: Teste unitário
    public double calcularValorParcelas() {
        return 0;
    }
}
