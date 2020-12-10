package br.edu.ifnmg.loja.entidade;

public class Pagamento {

    private static final double DESCONTO_VISTA = 0.1;

    private Venda venda;
    int numeroParcelas;

    public Pagamento(Venda venda, int numeroParcelas) {
        this.venda = venda;
        this.numeroParcelas = numeroParcelas;
    }

    /* REGRAS Nº DE PARCELAS: Mínimo 1, Máximo 10
   Valor mínimo da parcela deve ser de R$ 50,00
   Somente vendas acima de R$ 1000,00 podem ser parceladas em mais de 5 vezes!");
    */
    public boolean validarNumeroParcelas(int numeroParcelas) {

        double valorTotal = this.calcularValorParcelas();

        if (numeroParcelas < 0 || numeroParcelas > 10){
            return false;
        }else if (valorTotal < 1000 && numeroParcelas > 5){
            return false;
        }

        double valorParcelas = this.calcularValorParcelas();

        if (valorParcelas < 50){
            return false;
        }

        return true;
    }

    // TODO: Teste unitário
    public double calcularValorVista() {
        return this.venda.calcularValorVenda() * (1 - DESCONTO_VISTA);
    }

    // TODO: Teste unitário
    public double calcularValorParcelas() {

        // TODO: Teste unitário
        double valorTotal = this.venda.calcularValorVenda();
        double valorParcelas = valorTotal / this.numeroParcelas;

        return valorParcelas;
    }
}
