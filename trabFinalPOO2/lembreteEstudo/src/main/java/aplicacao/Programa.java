package aplicacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import trabalhoFinal.Atividade;
import trabalhoFinal.AtividadeFactory;
import trabalhoFinal.AtividadeFactoryImpl;
import trabalhoFinal.Notificacao;
import trabalhoFinal.NotificacaoExibicao;
import trabalhoFinal.NotificacaoProxy;
import trabalhoFinal.NotificacaoProxyImpl;


public class Programa {

	public static void main(String[] args) {

		AtividadeFactory factory = new AtividadeFactoryImpl();
		NotificacaoProxy proxy = new NotificacaoProxyImpl();
		proxy.iniciarLista();
		
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;

		while (opcao != 4) {
			exibirMenu();
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				adicionarLembrete(proxy, scanner, factory);
				break;
			case 2:
				removerLembrete(proxy, scanner, factory);
				break;
			case 3:
				
				exibirLembretes(proxy);
				
				break;
			case 4:
				System.out.println("Saindo do programa...");
				break;
			default:
				System.out.println("Opção inválida. Por favor, tente novamente.");
				break;
			}
		}
	}

	private static void exibirMenu() {
		System.out.println("\n===== MENU =====");
		System.out.println("1. Adicionar lembrete");
		System.out.println("2. Remover lembrete");
		System.out.println("3. Exibir lembretes");
		System.out.println("4. Sair");
		System.out.print("Escolha uma opção: ");
	}

	private static void adicionarLembrete(NotificacaoProxy proxy, Scanner scanner, AtividadeFactory factory) {

		System.out.print("Digite a mensagem do lembrete: ");
		scanner.nextLine();
		String mensagem = scanner.nextLine();

		System.out.print("Digite a data do lembrete: ");
		String data = scanner.nextLine();

		
		Atividade at1 = factory.criarAtividade(null, mensagem, data);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-final");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(at1);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		Notificacao notificacao = new NotificacaoExibicao(at1);
		proxy.adicionarNotificacao(notificacao);

		System.out.println("Lembrete adicionado com sucesso!");
	}
	

	private static void removerLembrete(NotificacaoProxy proxy, Scanner scanner, AtividadeFactory factory) {
		
		
		System.out.print("Digite o id do lembrete: ");
		Integer id = scanner.nextInt();
   
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-final");
		EntityManager em = emf.createEntityManager();
		
		Atividade at2 = em.find(Atividade.class, id);
        
		if (at2 == null) {
			System.out.println("Lembrete não encontrado.");
			
		} else {
			
			for (Notificacao notificacao : proxy.getNotificacoes()) {
				if (notificacao instanceof NotificacaoExibicao) {
					NotificacaoExibicao notificacaoExibicao = (NotificacaoExibicao) notificacao;
					if (notificacaoExibicao.getAtividade().equals(at2)) {
						proxy.removerNotificacao(notificacao);
						break;
					}
				}
			}
			
			em.getTransaction().begin();
			em.remove(at2);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			System.out.println("Lembrete removido com sucesso!");
		}
	}
	
	private static void exibirLembretes(NotificacaoProxy proxy) {
		
		System.out.println("\n===== LEMBRETES =====");	
		List<Notificacao> lembretes = proxy.getNotificacoes();
		
        
		if (lembretes.isEmpty()) {	
			System.out.println("Não há lembretes registrados.");
		} else {		
			for (Notificacao notificacao : lembretes) {
				
				if (notificacao instanceof NotificacaoExibicao) {
				
					NotificacaoExibicao notificacaoExibicao = (NotificacaoExibicao) notificacao;					
					notificacaoExibicao.notificar();
					
			
				}
			}
		}
	}
}