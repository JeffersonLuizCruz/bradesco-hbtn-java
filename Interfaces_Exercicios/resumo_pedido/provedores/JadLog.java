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

