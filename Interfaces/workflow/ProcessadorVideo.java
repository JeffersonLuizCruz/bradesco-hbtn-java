import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {
    private List<CanalNotificacao> canais = new ArrayList<>();

    public void registrarCanal(CanalNotificacao canal) {
        canais.add(canal);
    }

    public void processar(Video video) {
        for (CanalNotificacao canal : canais) {
            canal.notificar(new Mensagem(
                video.getArquivo() + " - " + video.getFormato(),
                TipoMensagem.LOG
            ));
        }
    }
}

