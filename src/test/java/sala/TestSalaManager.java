package sala;

import exception.HorarioConflitante;
import exception.SalaInexistente;
import org.junit.jupiter.api.Test;
import salas.Sala;
import salas.SalasManager;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static junit.framework.Assert.assertTrue;

public class TestSalaManager {

    SalasManager salasManager;

    @Test
    public void test(){
        salasManager = SalasManager.instanceOfSalasManager();

        try {
            testCriarSala();
            testReservaSala();
        } catch (SalaInexistente | HorarioConflitante e) {
            e.printStackTrace();
        }
    }

    private void testReservaSala() throws SalaInexistente, HorarioConflitante {
        salasManager.reservaSalaChamada("SalaA", LocalDateTime.now(),
                LocalDateTime.now().plus(1, ChronoUnit.HOURS));
    }

    private void testCriarSala() {
        salasManager.adicionaSalaChamada("SalaA",55,"desc");
        assertTrue(salasManager.listaDeSalas().contains(new Sala("SalaA",55,"desc")));
        salasManager.removeSalaChamada("SalaS");
        assertTrue(salasManager.listaDeSalas().contains(new Sala("SalaA",55,"desc")));
        salasManager.adicionaSalaChamada("SalaA",55,"desc");

    }



}
