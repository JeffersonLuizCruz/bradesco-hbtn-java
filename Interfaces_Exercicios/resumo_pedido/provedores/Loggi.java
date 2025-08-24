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

