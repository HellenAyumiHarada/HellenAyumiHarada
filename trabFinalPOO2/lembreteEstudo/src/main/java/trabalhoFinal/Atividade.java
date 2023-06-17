package trabalhoFinal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String data;

	public Atividade(Integer id, String nome, String data) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

	@Override
	public String toString() {
		return "lembrete "+id+": " + nome + ", data " + data;
	}	
	
	public boolean equals(Atividade a) {
		return this.id.equals(a.getId());
	}
}

