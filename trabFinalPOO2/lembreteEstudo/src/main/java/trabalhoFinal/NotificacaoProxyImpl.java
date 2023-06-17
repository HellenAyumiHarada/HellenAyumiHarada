package trabalhoFinal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NotificacaoProxyImpl implements NotificacaoProxy
{
  private List < Notificacao > notificacoes = new ArrayList <> ();

   @Override public void adicionarNotificacao (Notificacao notificacao)
  {   
    notificacoes.add (notificacao);
  }

   @Override public void removerNotificacao (Notificacao notificacao)
  {
	   
    notificacoes.remove (notificacao);
    
	
  }

  @Override public void notificar ()
  {
  for (Notificacao notificacao:notificacoes)
      {
	notificacao.notificar ();
      }
  }
  @Override
  public List < Notificacao > getNotificacoes ()
  {
    return notificacoes;
  }

@Override
public void iniciarLista() {
	
	Atividade a;
	Integer i=1;
	do {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-final");
	EntityManager em = emf.createEntityManager();		
	em.getTransaction().begin();	
	a = em.find(Atividade.class,i);
	em.getTransaction().commit();
	em.close();
	emf.close();
	if(a!=null) {
		NotificacaoExibicao n = new NotificacaoExibicao(a);
		notificacoes.add (n);
	}
	i++;
	}while(a!=null);
	
	
	
	
}
}