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

    Eleitor eleitor1;
    Eleitor eleitor2;
    Eleitor eleitor3;
    Eleitor eleitor4;
    Eleitor eleitor5;


    @BeforeEach
    void setUp() {
        eleicaoAutarquica = new Eleicao("Eleicoes Autarquicas 2025", 18);
        eleicaoAssociacaoEstudantes = new Eleicao("Associacao de Estudantes - Secundaria Freixo de Espada a Cinta", 14);

        aut1 = new Candidato("Joana Almeida", 18, "Trofa");
        aut2 = new Candidato("Ricardo Meireles", 18, "Maia");
        aut3 = new Candidato("Cristiano Ronaldo", 38, "Porto");
        aut4 = new Candidato("Joaquim Alberto", 45, "Gaia");

        ass1 = new Candidato("Mariana Costa", 14, "Trofa");
        ass2 = new Candidato("Luis Pereira", 10, "Trofa");
        ass3 = new Candidato("Sofia Matos", 18, "Santo Tirso");
        ass4 = new Candidato("Bruno Gomes", 15, "Maia");


        eleitor1 = new Eleitor("João Santos", "E002", 18, "joao@mail.com", "911000002");
        eleitor2 = new Eleitor("Carla Mendes", "E003", 15, "carla@mail.com", "911000003");
        eleitor3 = new Eleitor("Tiago Lopes", "E004", 20, "tiago@mail.com", "911000004");
        eleitor4 = new Eleitor("Miguel Almeida", "E006", 14, "miguel@mail.com", "911000006");
        eleitor5 = new Eleitor("Inês Pires", "E007", 22, "ines@mail.com", "911000007");

    }

    @Test
    void testGetNome() {
        assertEquals("Eleicoes Autarquicas 2025", eleicaoAutarquica.getNome());
        assertEquals("Associacao de Estudantes - Secundaria Freixo de Espada a Cinta" ,eleicaoAssociacaoEstudantes.getNome());
    }

    @Test
    void testGetIdadeMinima() {
        assertEquals(18, eleicaoAutarquica.getIdadeMinima());
        assertEquals(14, eleicaoAssociacaoEstudantes.getIdadeMinima());
    }

    @Test
    void testGetCandidatosIniciaVazio() {
        assertTrue(eleicaoAutarquica.getCandidatos().isEmpty());
        assertTrue(eleicaoAssociacaoEstudantes.getCandidatos().isEmpty());
    }


    @Test
    void testAdicionarCandidatoValidoIdadeIgualMinima() {
        eleicaoAutarquica.adicionarCandidato(aut1);
        assertTrue(eleicaoAutarquica.getCandidatos().contains(aut1));
        assertEquals(1,eleicaoAutarquica.getCandidatos().size());


        eleicaoAutarquica.adicionarCandidato(aut2);
        assertTrue(eleicaoAutarquica.getCandidatos().contains(aut2));
        assertEquals(2,eleicaoAutarquica.getCandidatos().size());

    }

    @Test
    void testAdicionarCandidatoValidoIdadeMaiorQueMinima() {
        eleicaoAutarquica.adicionarCandidato(aut3);
        assertTrue(eleicaoAutarquica.getCandidatos().contains(aut3));
        assertEquals(1,eleicaoAutarquica.getCandidatos().size());


        eleicaoAutarquica.adicionarCandidato(aut4);
        assertTrue(eleicaoAutarquica.getCandidatos().contains(aut4));
        assertEquals(2,eleicaoAutarquica.getCandidatos().size());

    }

    @Test
    void testAdicionarCandidatoInvalidoIdadeMenorQueMinima() {
        assertThrows(IllegalArgumentException.class, () -> eleicaoAutarquica.adicionarCandidato(ass1));
        assertTrue(eleicaoAutarquica.getCandidatos().isEmpty());

        assertThrows(IllegalArgumentException.class, () -> eleicaoAutarquica.adicionarCandidato(ass2));
        assertTrue(eleicaoAutarquica.getCandidatos().isEmpty());

    }

    @Test
    void testContemCandidatosAdicionaApenasUmaVez(){
        eleicaoAutarquica.adicionarCandidato(aut3);
        eleicaoAutarquica.adicionarCandidato(aut3);
        assertEquals(1, eleicaoAutarquica.getCandidatos().size());

        eleicaoAutarquica.adicionarCandidato(aut4);
        eleicaoAutarquica.adicionarCandidato(aut4);
        assertEquals(2, eleicaoAutarquica.getCandidatos().size());
    }



    @Test
    void testVotarComIdadeValidaRegistaVoto() {

        eleicaoAutarquica.adicionarCandidato(aut3);
        eleicaoAutarquica.votar(eleitor1,aut3);
        assertEquals(1,eleicaoAutarquica.getVotos().size());

        eleicaoAutarquica.adicionarCandidato(aut4);
        eleicaoAutarquica.votar(eleitor3,aut4);
        assertEquals(2,eleicaoAutarquica.getVotos().size());

    }

    @Test
    void testVotarComIdadeMenorQueMinimaLancaException() {
        eleicaoAutarquica.adicionarCandidato(aut3);
        assertThrows(IllegalArgumentException.class, () -> eleicaoAutarquica.votar(eleitor2, aut3));
        assertTrue(eleicaoAutarquica.getVotos().isEmpty());

        eleicaoAutarquica.adicionarCandidato(aut3);
        assertThrows(IllegalArgumentException.class, () -> eleicaoAutarquica.votar(eleitor4, aut3));
        assertTrue(eleicaoAutarquica.getVotos().isEmpty());

    }
    @Test
    void testVotarComCandidatoNaoRegistadoLancaException() {
        assertThrows(IllegalArgumentException.class, () ->  eleicaoAutarquica.votar(eleitor3, aut3));
        assertThrows(IllegalArgumentException.class, () ->  eleicaoAutarquica.votar(eleitor1, aut4));

    }

    @Test
    void testVotoDuplicadoLancaException() {

        eleicaoAutarquica.adicionarCandidato(aut3);
        eleicaoAutarquica.votar(eleitor1,aut3);
        assertThrows(IllegalArgumentException.class, () -> eleicaoAutarquica.votar(eleitor1, aut3));
        assertEquals(1, eleicaoAutarquica.getVotos().size());


        eleicaoAutarquica.adicionarCandidato(aut4);
        eleicaoAutarquica.votar(eleitor3,aut4);
        assertThrows(IllegalArgumentException.class, () -> eleicaoAutarquica.votar(eleitor3,aut4));
        assertEquals(2, eleicaoAutarquica.getVotos().size());

    }

    @Test
    void dadoCandidatoSemVotos_quandoContarVotos_entaoRetornaZero() {

        eleicaoAutarquica.adicionarCandidato(aut4);
        assertEquals(0, eleicaoAutarquica.contarVotos(aut4));

    }

    @Test
    void testContarVotosRegistados() {

        eleicaoAutarquica.adicionarCandidato(aut3);
        eleicaoAutarquica.adicionarCandidato(aut4);

        eleicaoAutarquica.votar(eleitor1,aut3);
        eleicaoAutarquica.votar(eleitor3,aut4);
        eleicaoAutarquica.votar(eleitor5,aut4);


        assertEquals(1, eleicaoAutarquica.contarVotos(aut3));
        assertEquals(2, eleicaoAutarquica.contarVotos(aut4));

    }
    @Test
    void testObterVencedor() {
        eleicaoAutarquica.adicionarCandidato(aut3);
        eleicaoAutarquica.adicionarCandidato(aut4);

        eleicaoAutarquica.votar(eleitor1, aut3);
        eleicaoAutarquica.votar(eleitor3, aut4);
        eleicaoAutarquica.votar(eleitor5, aut4);


        assertNotNull(eleicaoAutarquica.obterVencedor());
        assertEquals("Joaquim Alberto", eleicaoAutarquica.obterVencedor().getNome());
        assertEquals(45, eleicaoAutarquica.obterVencedor().getIdade());
        assertEquals("Gaia", eleicaoAutarquica.obterVencedor().getNaturalidade());
    }

    @Test
    void testObterVencedorQuandoEmpate() {
        eleicaoAutarquica.adicionarCandidato(aut3);
        eleicaoAutarquica.adicionarCandidato(aut4);

        eleicaoAutarquica.votar(eleitor1, aut3);
        eleicaoAutarquica.votar(eleitor3, aut4);

        assertNull(eleicaoAutarquica.obterVencedor());
    }


}