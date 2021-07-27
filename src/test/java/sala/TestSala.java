package sala;

import org.junit.jupiter.api.Test;
import salas.Sala;

import static junit.framework.Assert.assertEquals;

public class TestSala {

    @Test
    public void test(){
        Sala sala = new Sala("Azul",55,"Sala de aula para testes");

        testNome(sala);
        testCapacidade(sala);
        testDescricao(sala);
    }

    private void testDescricao(Sala sala) {
        assertEquals("erro em getDescricao","Sala de aula para testes".toLowerCase(),sala.getDescricao().toLowerCase());
        sala.setDescricao("Sala nova");
        assertEquals("erro em setNome","Sala nova".toLowerCase(),sala.getDescricao().toLowerCase());
    }

    private void testCapacidade(Sala sala) {
        assertEquals("erro em getNome",55,sala.getCapacidadeMax());
        sala.setCapacidadeMax(33);
        assertEquals("erro em setNome",33,sala.getCapacidadeMax());
    }

    private void testNome(Sala sala) {
        assertEquals("erro em getNome","Azul".toLowerCase(),sala.getNome().toLowerCase());
        sala.setNome("Amarela");
        assertEquals("erro em setNome","amarela".toLowerCase(),sala.getNome().toLowerCase());
    }
}
