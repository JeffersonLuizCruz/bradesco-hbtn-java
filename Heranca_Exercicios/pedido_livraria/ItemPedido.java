public class ItemPedido {
    private int quantidade;
    private produtos.Produto produto;

    public ItemPedido(produtos.Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public produtos.Produto getProduto() {
        return produto;
    }
}

