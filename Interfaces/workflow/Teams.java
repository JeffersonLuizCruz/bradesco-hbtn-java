public class Teams implements CanalNotificacao {
    @Override
    public void notificar(Mensagem mensagem) {
        System.out.printf("[TEAMS] {%s} - %s%n", mensagem.getTipoMensagem(), mensagem.getTexto());
    }
}

