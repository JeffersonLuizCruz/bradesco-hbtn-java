public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    // Construtor com validação
    public PersonagemGame(int saudeAtual, String nome) {
        setNome(nome); // Validação do nome
        setSaudeAtual(saudeAtual); // Validação da saúde e definição do status
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        if (saudeAtual < 0) {
            this.saudeAtual = 0;
        } else if (saudeAtual > 100) {
            this.saudeAtual = 100;
        } else {
            this.saudeAtual = saudeAtual;
        }

        if (this.saudeAtual == 0) {
            this.status = "morto";
        } else {
            this.status = "vivo";
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
        // Caso seja nulo ou vazio, mantém o nome atual
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDeDano) {
        setSaudeAtual(this.saudeAtual - quantidadeDeDano);
    }

    public void receberCura(int quantidadeDeCura) {
        setSaudeAtual(this.saudeAtual + quantidadeDeCura);
    }
}

