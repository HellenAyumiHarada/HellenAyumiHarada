package trabalhoFinal;

public class NotificacaoExibicao implements Notificacao
{
  private final Atividade at1;

   public NotificacaoExibicao (Atividade at1) {
	   this.at1 = at1;
   }

   @Override public void notificar ()
  {
    System.out.println (at1);
  }

 
   public Atividade getAtividade() {
	   return at1;
   }
   
}
