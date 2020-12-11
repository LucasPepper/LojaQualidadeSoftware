package br.edu.ifnmg.loja.entidade;

public class PagamentoPrazo extends Pagamento{

    private final int numeroParcelas;

    public PagamentoPrazo(Venda venda, int numeroParcelas) {
        super(venda);
        this.numeroParcelas = numeroParcelas;
        validarNumeroParcelas();
    }

    public void validarNumeroParcelas() {

        double valorTotal = this.venda.calcularValorVenda();

        if (this.numeroParcelas <= 0 || this.numeroParcelas > 10){
            throw new IllegalArgumentException("Nº de parcelas inválido!");
        }else if (valorTotal < 1000 && this.numeroParcelas > 5){
            throw new IllegalArgumentException("Nº de parcelas inválido!");
        }

        double valorParcelas = this.calcularValorParcelas();
        if (valorParcelas < 50){
            throw new IllegalArgumentException("Valor mínimo da parcela inválido!");
        }
    }
    public double calcularValorParcelas() {
        double valorTotal = this.venda.calcularValorVenda();
        return valorTotal / this.numeroParcelas;
    }
}
