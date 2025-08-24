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

