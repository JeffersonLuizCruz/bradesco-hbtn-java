public class Frete {
    private double valor;
    private TipoProvedorFrete tipoProvedorFrete;

    public Frete(double valor, TipoProvedorFrete tipoProvedorFrete) {
        this.valor = valor;
        this.tipoProvedorFrete = tipoProvedorFrete;
    }

    public double getValor() {
        return valor;
    }

    public TipoProvedorFrete getTipoProvedorFrete() {
        return tipoProvedorFrete;
    }
}
🔹 provedores/ProvedorFrete.java
java
Copiar
Editar
package provedores;

public interface ProvedorFrete {
    Frete calcularFrete(double peso, double valor);
    TipoProvedorFrete obterTipoProvedorFrete();
}
🔹 provedores/Sedex.java
java
Copiar
Editar
package provedores;

public class Sedex implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double frete;
        if (peso > 1000) { // mais de 1kg
            frete = valor * 0.10;
        } else {
            frete = valor * 0.05;
        }
        return new Frete(frete, TipoProvedorFrete.SEDEX);
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
}
🔹 provedores/JadLog.java
java
Copiar
Editar
package provedores;

public class JadLog implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double frete;
        if (peso > 2000) { // mais de 2kg
            frete = valor * 0.07;
        } else {
            frete = valor * 0.045;
        }
        return new Frete(frete, TipoProvedorFrete.JADLOG);
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }
}
🔹 provedores/Loggi.java
java
Copiar
Editar
package provedores;

public class Loggi implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double frete;
        if (peso > 5000) { // mais de 5kg
            frete = valor * 0.12;
        } else {
            frete = valor * 0.04;
        }
        return new Frete(frete, TipoProvedorFrete.LOGGI);
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }
}
🔹 Pedido.java
java
Copiar
Editar
import provedores.Frete;

public class Pedido {
    private int codigo;
    private double peso;
    private double total;
    private Frete frete;

    public Pedido(int codigo, double peso, double total) {
        this.codigo = codigo;
        this.peso = peso;
        this.total = total;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPeso() {
        return peso;
    }

    public double getTotal() {
        return total;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }
}
🔹 ProcessadorPedido.java
java
Copiar
Editar
import provedores.*;

public class ProcessadorPedido {
    private ProvedorFrete provedorFrete;

    public ProcessadorPedido(ProvedorFrete provedorFrete) {
        this.provedorFrete = provedorFrete;
    }

    public void processar(Pedido pedido) {
        Frete freteCalculado = provedorFrete.calcularFrete(pedido.getPeso(), pedido.getTotal());
        pedido.setFrete(freteCalculado);
    }
}
🔹 Program.java
java
Copiar
Editar
import provedores.*;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Pedido pedido1 = new Pedido(1, 1500, 234.90);
        Pedido pedido2 = new Pedido(2, 600, 124.00);
        Pedido pedido3 = new Pedido(3, 3000, 53.00);
        Pedido pedido4 = new Pedido(4, 7000, 300.00);

        ProcessadorPedido processadorPedidoSedex = new ProcessadorPedido(new Sedex());
        processadorPedidoSedex.processar(pedido1);

        System.out.printf("%s - %.2f\n", pedido1.getFrete().getTipoProvedorFrete(), pedido1.getFrete().getValor());

        ProcessadorPedido processadorPedidoJadLog = new ProcessadorPedido(new JadLog());
        processadorPedidoJadLog.processar(pedido1);        

        System.out.printf("%s - %.2f\n", pedido1.getFrete().getTipoProvedorFrete(), pedido1.getFrete().getValor());

        ProcessadorPedido processadorPedidoLoggi = new ProcessadorPedido(new Loggi());
        processadorPedidoLoggi.processar(pedido1);

        System.out.printf("%s - %.2f\n", pedido1.getFrete().getTipoProvedorFrete(), pedido1.getFrete().getValor());

        System.out.println("-----");

        processadorPedidoSedex.processar(pedido2);
        System.out.printf("%s - %.2f\n", pedido2.getFrete().getTipoProvedorFrete(), pedido2.getFrete().getValor());

        processadorPedidoJadLog.processar(pedido2);        
        System.out.printf("%s - %.2f\n", pedido2.getFrete().getTipoProvedorFrete(), pedido2.getFrete().getValor());

        processadorPedidoLoggi.processar(pedido2);
        System.out.printf("%s - %.2f\n", pedido2.getFrete().getTipoProvedorFrete(), pedido2.getFrete().getValor());

        System.out.println("-----");  

        processadorPedidoSedex.processar(pedido3);
        System.out.printf("%s - %.2f\n", pedido3.getFrete().getTipoProvedorFrete(), pedido3.getFrete().getValor());

        processadorPedidoJadLog.processar(pedido3);        
        System.out.printf("%s - %.2f\n", pedido3.getFrete().getTipoProvedorFrete(), pedido3.getFrete().getValor());

        processadorPedidoLoggi.processar(pedido3);
        System.out.printf("%s - %.2f\n", pedido3.getFrete().getTipoProvedorFrete(), pedido3.getFrete().getValor());

        System.out.println("-----");       

        processadorPedidoSedex.processar(pedido4);
        System.out.printf("%s - %.2f\n", pedido4.getFrete().getTipoProvedorFrete(), pedido4.getFrete().getValor());

        processadorPedidoJadLog.processar(pedido4);        
        System.out.printf("%s - %.2f\n", pedido4.getFrete().getTipoProvedorFrete(), pedido4.getFrete().getValor());

        processadorPedidoLoggi.processar(pedido4);
        System.out.printf("%s - %.2f\n", pedido4.getFrete().getTipoProvedorFrete(), pedido4.getFrete().getValor());        
    }
}
