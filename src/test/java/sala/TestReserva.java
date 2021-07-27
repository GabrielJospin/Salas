package sala;

import org.junit.jupiter.api.Test;
import salas.Reserva;

import java.time.LocalDateTime;

import static junit.framework.Assert.assertEquals;

public class TestReserva {

    private Reserva reserva;

    @Test
    public void test(){
        LocalDateTime inicio = LocalDateTime.of(2021,12,1,5,0);
        LocalDateTime fim = LocalDateTime.of(2021,12,1,7,0);
        String sala = "Sala";
        reserva = new Reserva(sala,inicio,fim);
        testInicio();
        testFim();
        testSala();
    }

    private void testSala() {
        assertEquals("erro em getSala","Sala".toLowerCase(),reserva.getNomeDaSala().toLowerCase());

        reserva.setNomeDaSala("sssala");

        assertEquals("erro em setSala","ssSala".toLowerCase(),reserva.getNomeDaSala().toLowerCase());
    }

    private void testFim() {
        assertEquals("Erro em getFim",
                LocalDateTime.of(2021,12,1,7,0),
                reserva.getDataFinal());

        reserva.setDataFinal(LocalDateTime.of(2021,10,1,21,15));


        assertEquals("Erro em setFinal",
                LocalDateTime.of(2021,10,1,21,15),
                reserva.getDataFinal());
    }

    private void testInicio() {
        assertEquals("Erro em getInicio",
                LocalDateTime.of(2021,12,1,5,0),
                reserva.getDataInicial());

        reserva.setDataFinal(LocalDateTime.of(2021,10,1,20,15));


        assertEquals("Erro em setInicio",
                LocalDateTime.of(2021,10,1,20,15),
                reserva.getDataInicial());
    }


}
