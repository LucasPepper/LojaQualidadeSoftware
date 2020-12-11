package br.edu.ifnmg.loja.entidade;

public class Produto {
    private final int id;
    private final String descricao;
    private final int estoque;
    private final double preco;
    private static int totalProdutos = 0;

    public Produto(String descricao, int estoque, double preco){
        totalProdutos++;
        this.id = totalProdutos;
        this.descricao = descricao;
        this.estoque = estoque;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public static int getTotalProdutos() {
        return totalProdutos;
    }
}
