package trabalhoFinal;

import java.util.List;

public interface NotificacaoProxy
{
  void adicionarNotificacao (Notificacao notificacao);
  void removerNotificacao (Notificacao notificacao);
  void notificar ();
  public List < Notificacao > getNotificacoes ();
  void iniciarLista();
}
