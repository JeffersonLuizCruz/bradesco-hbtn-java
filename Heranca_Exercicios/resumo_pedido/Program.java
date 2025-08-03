import java.util.*;
import produtos.Livro;
import produtos.Dvd;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        Livro livro1 = new Livro("Duna", 2017, "Brasil", 56.30, 680, "Frank Herbert", 1);
        Livro livro2 = new Livro("Um de nos esta mentindo", 2018, "Brasil", 34.93, 384, "Karen Mcmanus", 1);
        Livro livro3 = new Livro("Mindset Milionario", 2021, "Brasil", 31.70, 272, "José Roberto Marques", 1);

        Dvd dvd1 = new Dvd("Anjos da Noite 5 - Guerras de Sangue", 2016, "Estados Unidos", 16.90, "Anna Foerster", "Ação", 91);
        Dvd dvd2 = new Dvd("Annabelle 2 - A Criacao do Mal", 2017, "Brasil", 39.90, "Jame Wan e Peter Safran", "Terror", 109);

        ItemPedido[] itensPedido1 = {
            new ItemPedido(livro1, 1),
            new ItemPedido(dvd2, 1)
        };
        Pedido pedido1 = new Pedido(0, itensPedido1);
        pedido1.apresentarResumoPedido();

        ItemPedido[] itensPedido2 = {
            new ItemPedido(livro1, 1),
            new ItemPedido(dvd2, 1)
        };
        Pedido pedido2 = new Pedido(10, itensPedido2);
        pedido2.apresentarResumoPedido();

        ItemPedido[] itensPedido3 = {
            new ItemPedido(livro2, 1),
            new ItemPedido(livro3, 2),
            new ItemPedido(dvd1, 1)
        };
        Pedido pedido3 = new Pedido(5, itensPedido3);
        pedido3.apresentarResumoPedido();

        ItemPedido[] itensPedido4 = {
            new ItemPedido(livro2, 1),
            new ItemPedido(livro2, 1),
            new ItemPedido(livro3, 2),
            new ItemPedido(dvd1, 1),
            new ItemPedido(dvd2, 2)
        };
        Pedido pedido4 = new Pedido(5, itensPedido4);
        pedido4.apresentarResumoPedido();
    }
}

