public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            double bonusBase = getSalarioFixo() * 0.20;
            double diferencaMeta = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
            double bonusAdicional = diferencaMeta * 0.01;
            return bonusBase + bonusAdicional;
        } else {
            return 0.0;
        }
    }
}

