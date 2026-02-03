import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VotoTest {
    Voto voto1;
    Voto voto2;

    Candidato candidato1;
    Candidato candidato2;

    Eleitor eleitor1;
    Eleitor eleitor2;

    @BeforeEach
    void setUp() {
        voto1 = new Voto( eleitor1 = new Eleitor("Ana Rocha", "E001", 17, "ana@mail.com", "911000001"),candidato1 = new Candidato("Joana Almeida", 42, "Trofa"));
        voto2 = new Voto( eleitor2 = new Eleitor("Tiago Lopes", "E004", 18, "tiago@mail.com", "911000004"), candidato2 = new Candidato("Ricardo Meireles", 50, "Maia"));
    }

    @Test
    void testGetEleitor() {
        assertEquals(eleitor1, voto1.getEleitor());
        assertEquals(eleitor2, voto2.getEleitor());
    }

    @Test
    void testGetCandidato() {
        assertEquals(candidato1,voto1.getCandidato());
        assertEquals(candidato2,voto2.getCandidato());
    }


}