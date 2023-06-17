package trabalhoFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AtividadeTest {

    Atividade atividade1;
    Atividade atividade2;
    Atividade atividade3;

    @BeforeEach
    void setUp() {
        atividade1 = new Atividade(1, "Atividade 1", "2023-06-17");
       
    }

    @Test
    void testToString() {
        String expectedToString = "lembrete 1: Atividade 1, data 2023-06-17";
        assertEquals(expectedToString, atividade1.toString());
    }

}

