import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EleitorTest {
    Eleitor eleitor1;
    Eleitor eleitor2;
    Eleitor eleitor3;
    Eleitor eleitor4;

    @BeforeEach
    void setUp() {
        eleitor1 = new Eleitor("Ana Rocha", "E001", 17, "ana@mail.com", "911000001");
        eleitor2 = new Eleitor("João Santos", "E002", 20, "joao@mail.com", "911000002");
        eleitor3 = new Eleitor("Carla Mendes", "E003", 15, "carla@mail.com", "911000003");
        eleitor4 = new Eleitor("Tiago Lopes", "E004", 18, "tiago@mail.com", "911000004");
    }

    @Test
    void testGetNome() {
        assertEquals("Ana Rocha",eleitor1.getNome());
        assertEquals("João Santos",eleitor2.getNome());

    }

    @Test
    void testGetNumeroIdentificacao() {
        assertEquals("E001",eleitor1.getNumeroIdentificacao());
        assertEquals("E002",eleitor2.getNumeroIdentificacao());
    }

    @Test
    void testGetIdade() {
        assertEquals(17,eleitor1.getIdade());
        assertEquals(20,eleitor2.getIdade());
    }

    @Test
    void testGetEmail() {
        assertEquals("ana@mail.com",eleitor1.getEmail());
        assertEquals("joao@mail.com",eleitor2.getEmail());
    }

    @Test
    void testGetTelemovel() {
        assertEquals("911000001",eleitor1.getTelemovel());
        assertEquals("911000002",eleitor2.getTelemovel());

    }
}