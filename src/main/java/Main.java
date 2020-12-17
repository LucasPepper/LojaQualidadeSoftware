import br.edu.ifnmg.loja.entidade.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Produto> listaProdutos = new ArrayList<>();
    private static final HashMap<Produto, Integer> mapaVendaProdutoQuantidade = new HashMap<>();

    public static void main(String[] args) {

        preencherListaProdutos();

        System.out.println("Bem vindo à Loja!");

        Scanner scanner = new Scanner(System.in);
        int indiceProdutoEscolhido;
        int quantidadeProdutoEscolhido;
        int opcaoSair = 0;

        do {
            System.out.println("Escolha um produto:");

            for (Produto produto : listaProdutos) {
                System.out.printf("%d - %s (R$ %.2f)%n", produto.getId(), produto.getDescricao(), produto.getPreco());
            }

            try {
                indiceProdutoEscolhido = Integer.parseInt(scanner.nextLine());

                try {
                    if (indiceProdutoEscolhido != 0) {
                        System.out.printf("Digite a quantidade (Estoque = %d):",
                                listaProdutos.get(indiceProdutoEscolhido - 1).getEstoque());
                        quantidadeProdutoEscolhido = Integer.parseInt(scanner.nextLine());
                        Produto produtoEscolhido = listaProdutos.get(indiceProdutoEscolhido - 1);
                        mapaVendaProdutoQuantidade.put(produtoEscolhido, quantidadeProdutoEscolhido);
                    } else {
                        throw new ArrayIndexOutOfBoundsException("Número do produto inválido!");
                    }
                } catch (Exception e) {
                    System.out.println("Número do produto inválido!");
                    continue;
                }
            }catch(Exception e){
                System.out.println("Opção inválida!");
                continue;
            }

            System.out.println("Deseja mais alguma coisa?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            opcaoSair = Integer.parseInt(scanner.nextLine());

        } while (opcaoSair != 2);

        try {
            Venda venda = new Venda(mapaVendaProdutoQuantidade);
            System.out.printf("Total da Venda = R$ %.2f%n", venda.calcularValorVenda());

            System.out.println("Deseja pagar à vista (10% desconto) ou parcelar?");
            System.out.println("1 - À vista");
            System.out.println("2 - Parcelar");

            int escolhaPagamento = Integer.parseInt(scanner.nextLine());
            int numeroParcelas;
            boolean parcelamentoSucesso;

            // À Vista
            if (escolhaPagamento == 1) {
                PagamentoVista pagamentoVista = new PagamentoVista(venda);
                System.out.printf("Valor da compra à vista: R$ %.2f%n", pagamentoVista.calcularValorVista());

            } else if (escolhaPagamento == 2) {
                // Parcelamento
                do {
                    System.out.println("REGRAS DE PARCELAMENTO");
                    System.out.println("Mínimo 1, Máximo 10");
                    System.out.println("Valor mínimo da(s) parcela(s) deve(m) ser de R$ 50,00");
                    System.out.println("Somente vendas acima de R$ 1000,00 podem ser parceladas em mais de 5 vezes");
                    System.out.println("Digite o número de parcelas: ");
                    numeroParcelas = Integer.parseInt(scanner.nextLine());
                    PagamentoPrazo pagamentoPrazo = new PagamentoPrazo(venda, numeroParcelas);
                    try {
                        System.out.printf("Sua compra foi parcelada em %d vezes de R$%.2f%n",
                                numeroParcelas, pagamentoPrazo.calcularValorParcelas());
                        parcelamentoSucesso = true;
                    } catch (IllegalArgumentException illegalArgumentException) {
                        System.out.println(illegalArgumentException.getMessage());
                        parcelamentoSucesso = false;
                    }
                } while (!parcelamentoSucesso);
            }

        } catch (RuntimeException runtimeException) {
            System.out.println("Venda não realizada!");
            System.out.println(runtimeException.getMessage());
        } 

    }

    private static void preencherListaProdutos(){

        Produto sabonete = new Produto("Sabonete", 100, 2.00);
        Produto shampoo = new Produto("Shampoo", 200, 10.00);
        Produto desodorante = new Produto("Desodorante", 300, 12.00);
        Produto condicionador = new Produto("Condicionador", 250, 8.00);

        listaProdutos.add(sabonete);
        listaProdutos.add(shampoo);
        listaProdutos.add(desodorante);
        listaProdutos.add(condicionador);
    }
}
