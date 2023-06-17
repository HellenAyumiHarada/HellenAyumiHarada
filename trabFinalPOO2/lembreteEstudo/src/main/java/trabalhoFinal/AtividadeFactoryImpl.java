package trabalhoFinal;

public class AtividadeFactoryImpl implements AtividadeFactory {

	@Override
	public Atividade criarAtividade(Integer id, String nome, String data) {
		return new Atividade(id, nome, data);
	}
	
	 
}
