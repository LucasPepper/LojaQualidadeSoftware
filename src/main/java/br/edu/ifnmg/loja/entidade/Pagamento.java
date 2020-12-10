package br.edu.ifnmg.loja.entidade;

public class Pagamento {

    private static final double DESCONTO_VISTA = 0.1;

    private Venda venda;
    int numeroParcelas;

    public Pagamento(Venda venda, int numeroParcelas) {
        this.venda = venda;
        this.numeroParcelas = numeroParcelas;

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

        if (numeroParcelas < 0 || numeroParcelas > 10){
            throw new IllegalArgumentException("Nº de parcelas inválido!");
        }else if (valorTotal < 1000 && numeroParcelas > 5){
            throw new IllegalArgumentException("Nº de parcelas inválido!");
        }

        double valorParcelas = this.calcularValorParcelas();
        if (valorParcelas < 50){
            throw new IllegalArgumentException("Valor mínimo da parcela inválido!");
        }
    }

    // TODO: Teste unitário

    /* REGRAS Nº DE PARCELAS: Mínimo 1, Máximo 10
   Valor mínimo da parcela deve ser de R$ 50,00
   Somente vendas acima de R$ 1000,00 podem ser parceladas em mais de 5 vezes!");
    */

    public double calcularValorVista() {
        /* TODO: Teste unitário
        System.out.printf("TESTE: VISTA = %.2f", this.venda.calcularValorVenda() * (1 - DESCONTO_VISTA));

         */
        return this.venda.calcularValorVenda() * (1 - DESCONTO_VISTA);
    }
    public double calcularValorParcelas() {

        // TODO: Teste unitário
        double valorTotal = this.venda.calcularValorVenda();
        double valorParcelas = valorTotal / this.numeroParcelas;

        return valorParcelas;
    }


}
