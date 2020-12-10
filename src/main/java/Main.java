import br.edu.ifnmg.loja.entidade.Pagamento;
import br.edu.ifnmg.loja.entidade.Produto;
import br.edu.ifnmg.loja.entidade.Venda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static ArrayList<Produto> listaProdutos = new ArrayList<>();
    private static HashMap<Produto, Integer> mapaVendaProdutoQuantidade = new HashMap<>();

    public static void main(String[] args) {

        preencherListaProdutos();

        System.out.println("Bem vindo à Loja!");

        Scanner scanner = new Scanner(System.in);
        int indiceProdutoEscolhido;
        int quantidadeProdutoEscolhido;
        int opcaoSair;

        do {
            System.out.println("Escolha um produto:");

            for (Produto produto : listaProdutos){
                System.out.printf("%d - %s (R$ %.2f)%n", produto.getId(), produto.getDescricao(), produto.getPreco());
            }

            indiceProdutoEscolhido = Integer.parseInt(scanner.nextLine());
            if (indiceProdutoEscolhido != 0) {
                // TODO: Teste unitário
                System.out.printf("Você escolheu %s%n ",
                        listaProdutos.get(indiceProdutoEscolhido - 1).getDescricao());
                System.out.printf("Digite a quantidade (Estoque = %d):",
                        listaProdutos.get(indiceProdutoEscolhido - 1).getEstoque());
                quantidadeProdutoEscolhido = Integer.parseInt(scanner.nextLine());
                Produto produtoEscolhido = listaProdutos.get(indiceProdutoEscolhido - 1);
                mapaVendaProdutoQuantidade.put(produtoEscolhido, quantidadeProdutoEscolhido);
            }

            System.out.println("Deseja mais alguma coisa?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            opcaoSair = Integer.parseInt(scanner.nextLine());

        }while (opcaoSair != 2);

        Venda venda = new Venda(mapaVendaProdutoQuantidade);
        double valorTotalVenda = venda.calcularValorVenda();
        System.out.printf("Total da Venda = R$ %.2f%n ", valorTotalVenda);

        System.out.println("Deseja pagar à vista (10% desconto) ou parcelar?");
        System.out.println("1 - À vista");
        System.out.println("2 - Parcelar");

        int escolhaPagamento = Integer.parseInt(scanner.nextLine());
        int numeroParcelas;
        boolean numeroParcelasIsValido = false;


        if (escolhaPagamento == 1){
            // numeroParcelas = 0;
            Pagamento pagamento = new Pagamento(venda, numeroParcelas = 0);
            double valorAVista = pagamento.calcularValorVista();
            System.out.printf("Valor da compra à vista: R$ %.2f", valorAVista);

        } else if (escolhaPagamento == 2){
            // Parcelar
            do {
                System.out.println("Digite o número de parcelas: (mínimo 1, máximo 10)");
                System.out.println("Valor mínimo da parcela deve ser de R$ 50,00!");
                System.out.println("Somente vendas acima de R$ 1000,00 podem ser parceladas em mais de 5 vezes!");
                numeroParcelas = Integer.parseInt(scanner.nextLine());
                Pagamento pagamento = new Pagamento(venda, numeroParcelas);
                numeroParcelasIsValido = pagamento.validarNumeroParcelas(numeroParcelas);
                if (numeroParcelasIsValido) {
                    double valorParcelas = pagamento.calcularValorParcelas();
                    System.out.printf("Sua compra foi parcelada em %d vezes de R$%.2f ");
                } else {
                    System.out.println("Nº de parcelas inválido!");
                }
            }while (!numeroParcelasIsValido);
        }

        System.out.println("Obrigado!");

    }

    private static void preencherListaProdutos() {

        Produto sabonete = new Produto("Sabonete", 10, 2.00);
        Produto shampoo = new Produto("Shampoo", 5, 10.00);
        Produto desodorante = new Produto("Desodorante", 6, 12.00);
        Produto condicionador = new Produto("Condicionador", 8, 8.00);

        listaProdutos.add(sabonete);
        listaProdutos.add(shampoo);
        listaProdutos.add(desodorante);
        listaProdutos.add(condicionador);
    }
}
