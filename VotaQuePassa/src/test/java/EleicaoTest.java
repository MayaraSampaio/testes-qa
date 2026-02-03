import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EleicaoTest {
    Eleicao eleicaoAutarquica;
    Eleicao eleicaoAssociacaoEstudantes;

    Candidato aut1;
    Candidato aut2;
    Candidato aut3;
    Candidato aut4;

    Candidato ass1;
    Candidato ass2;
    Candidato ass3;
    Candidato ass4;

    @BeforeEach
    void setUp() {
        eleicaoAutarquica = new Eleicao("Eleicoes Autarquicas 2025", 18);
        eleicaoAssociacaoEstudantes = new Eleicao("Associacao de Estudantes - Secundaria Freixo de Espada a Cinta", 14);

        aut1 = new Candidato("Joana Almeida", 18, "Trofa");
        aut2 = new Candidato("Ricardo Meireles", 20, "Maia");
        aut3 = new Candidato("Cristiano Ronaldo", 38, "Porto");
        aut4 = new Candidato("Joaquim Alberto", 45, "Gaia");

        ass1 = new Candidato("Mariana Costa", 14, "Trofa");
        ass2 = new Candidato("Luis Pereira", 10, "Trofa");
        ass3 = new Candidato("Sofia Matos", 18, "Santo Tirso");
        ass4 = new Candidato("Bruno Gomes", 15, "Maia");


    }

    @Test
    void testAdicionarCandidatoValido() {
        eleicaoAutarquica.adicionarCandidato(aut1);
        assertTrue(eleicaoAutarquica.getCandidatos().contains(aut1));

        eleicaoAutarquica.adicionarCandidato(aut2);
        assertTrue(eleicaoAutarquica.getCandidatos().contains(aut2));



        eleicaoAssociacaoEstudantes.adicionarCandidato(ass2);
        assertTrue(eleicaoAssociacaoEstudantes.getCandidatos().contains(ass2));
        eleicaoAssociacaoEstudantes.adicionarCandidato(ass3);
        assertTrue(eleicaoAssociacaoEstudantes.getCandidatos().contains(ass3));

    }

    void testAdicionarCandidatoInvalido() {
        eleicaoAutarquica.adicionarCandidato(aut2);
        assertTrue(eleicaoAutarquica.getCandidatos().contains(aut1));

        eleicaoAssociacaoEstudantes.adicionarCandidato(ass2);
        assertTrue(eleicaoAssociacaoEstudantes.getCandidatos().contains(ass2));

    }

    @Test
    void testVotar() {

    }

    @Test
    void testContarVotos() {
    }

    @Test
    void testObterVencedor() {
    }

    @Test
    void testGetNome() {
    }

    @Test
    void testGetIdadeMinima() {
    }

    @Test
    void testGetCandidatos() {
    }

    @Test
    void testGetVotos() {
    }
}