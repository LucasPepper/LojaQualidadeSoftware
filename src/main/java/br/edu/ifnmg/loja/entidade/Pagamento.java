package br.edu.ifnmg.loja.entidade;

public class Pagamento {

    private static final double DESCONTO_VISTA = 0.1;

    private Venda venda;
    private int numeroParcelas;
    private double valorParcelas = 0;

    public Pagamento(Venda venda, int numeroParcelas) {
        this.venda = venda;
        this.numeroParcelas = numeroParcelas;
        this.valorParcelas = calcularValorParcelas();
        validarNumeroParcelas();

    }

    public Pagamento(Venda venda){
        this.venda = venda;
    }

    public Venda getVenda() {
        return this.venda;
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

    public double calcularValorVista() {
        return this.venda.calcularValorVenda() * (1 - DESCONTO_VISTA);
    }
    public double calcularValorParcelas() {

        double valorTotal = this.venda.calcularValorVenda();
        double valorParcelas = valorTotal / this.numeroParcelas;
        System.out.printf("ValorParcelas = %.2f%n", valorParcelas);
        return valorParcelas;
    }


}
