package sala;

import exception.HorarioConflitante;
import exception.SalaInexistente;
import org.junit.jupiter.api.Test;
import salas.Sala;
import salas.GerenciadorDeSalas;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static junit.framework.Assert.assertTrue;

public class TestSalaManager {

    GerenciadorDeSalas gerenciadorDeSalas;

    @Test
    public void test(){
        gerenciadorDeSalas = GerenciadorDeSalas.instanceOfSalasManager();

        try {
            testCriarSala();
            testReservaSala();
        } catch (SalaInexistente | HorarioConflitante e) {
            e.printStackTrace();
        }
    }

    private void testReservaSala() throws SalaInexistente, HorarioConflitante {
        gerenciadorDeSalas.reservaSalaChamada("SalaA", LocalDateTime.now(),
                LocalDateTime.now().plus(1, ChronoUnit.HOURS));
    }

    private void testCriarSala() {
        gerenciadorDeSalas.adicionaSalaChamada("SalaA",55,"desc");
        assertTrue(gerenciadorDeSalas.listaDeSalas().contains(new Sala("SalaA",55,"desc")));
        gerenciadorDeSalas.removeSalaChamada("SalaS");
        assertTrue(gerenciadorDeSalas.listaDeSalas().contains(new Sala("SalaA",55,"desc")));
        gerenciadorDeSalas.adicionaSalaChamada("SalaA",55,"desc");

    }



}
