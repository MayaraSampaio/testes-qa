import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidatoTest {
    Candidato candidato1;
    Candidato candidato2;
    Candidato candidato3;
    Candidato candidato4;

    @BeforeEach
    void setUp() {
        candidato1 = new Candidato("Joana Almeida", 42, "Trofa");
        candidato2 = new Candidato("Ricardo Meireles", 50, "Maia");
        candidato3 = new Candidato("Cristiano Ronaldo", 38, "Porto");
        candidato4 = new Candidato("Joaquim Alberto", 45, "Gaia");

    }

    @Test
    void testGetNome() {
    assertEquals("Joana Almeida", candidato1.getNome());
    assertEquals("Ricardo Meireles", candidato2.getNome());

    }

    @Test
    void testGetIdade() {
        assertEquals(42, candidato1.getIdade());
        assertEquals(50, candidato2.getNome());

    }

    @Test
    void testGetNaturalidade() {
        assertEquals("Trofa", candidato1.getNaturalidade());
        assertEquals("Maia", candidato2.getNaturalidade());
    }



}