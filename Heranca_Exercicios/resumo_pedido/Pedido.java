import java.util.Locale;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
        }
        return total - (total * (percentualDesconto / 100.0));
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");

        double totalProdutos = 0.0;

        for (ItemPedido item : itens) {
            produtos.Produto produto = item.getProduto();
            double preco = produto.obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double totalItem = preco * quantidade;
            totalProdutos += totalItem;

            String tipo = produto instanceof produtos.Livro ? "Livro" : "Dvd";
            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipo,
                    produto.titulo,
                    preco,
                    quantidade,
                    totalItem);
        }

        double desconto = totalProdutos * (percentualDesconto / 100.0);
        double totalPedido = totalProdutos - desconto;

        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f\n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalPedido);
        System.out.println("----------------------------");
    }
}

