package trabalhoFinal;


import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


public class AtividadeFactoryImplTest {

	Integer id;
	String nome;
	String data;
	
	@BeforeEach
	void setUp() throws Exception {
		
		  Integer id = 1;
	      String nome = "Atividade 1";
	      String data = "2023-06-17";	
	}
	
    @Test
    public void testCriarAtividade() {
        AtividadeFactoryImpl factory = new AtividadeFactoryImpl();

      
        Atividade atividade = factory.criarAtividade(id, nome, data);

        Assertions.assertEquals(id, atividade.getId());
        Assertions.assertEquals(nome, atividade.getNome());
        Assertions.assertEquals(data, atividade.getData());
    }
}
