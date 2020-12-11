package br.edu.ifnmg.loja.entidade;

public abstract class Pagamento {

    protected Venda venda;

    public Pagamento(Venda venda){
        this.venda = venda;
    }

}
