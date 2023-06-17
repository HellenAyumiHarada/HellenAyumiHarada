package trabalhoFinal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotificacaoExibicaoTest {

    @Test
    public void testNotificar() {
        Atividade atividade = new Atividade(1, "Atividade 1", "2023-06-17");
        NotificacaoExibicao notificacao = new NotificacaoExibicao(atividade);

        Assertions.assertDoesNotThrow(() -> notificacao.notificar());
    }

    @Test
    public void testGetAtividade() {
        Atividade atividade = new Atividade(1, "Atividade 1", "2023-06-17");
        NotificacaoExibicao notificacao = new NotificacaoExibicao(atividade);

        Assertions.assertEquals(atividade, notificacao.getAtividade());
    }
}
