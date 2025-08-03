import produtos.Produto;
import produtos.Livro;
import produtos.Dvd;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }
        double desconto = total * (percentualDesconto / 100.0);
        return total - desconto;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        double totalProdutos = 0;
        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            String tipo = (produto instanceof Livro) ? "Livro" : "Dvd";
            String titulo = produto.getTitulo();
            double preco = produto.obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double totalItem = preco * quantidade;

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipo, titulo, preco, quantidade, totalItem);
            totalProdutos += totalItem;
        }

        double desconto = totalProdutos * (percentualDesconto / 100.0);
        double totalFinal = totalProdutos - desconto;

        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f\n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalFinal);
        System.out.println("----------------------------");
    }
}

