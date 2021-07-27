package reuniao;



import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestMarcadorDeReuniao {

    MarcadorDeReuniao marcadorDeReuniao = new MarcadorDeReuniao();

    @Test
    public void test(){

        testMarcarReuniaoEntre();
        testIndicaDisponibilidade();
    }

    private void testMarcarReuniaoEntre() {

        List<String> mails = new ArrayList<>();
        mails.add("teste@teste.com");
        mails.add("testador@teste.com");

        LocalDate inicio = LocalDate.of(2021,10,12);
        LocalDate fim = LocalDate.of(2021,10,15);


        marcadorDeReuniao.marcarReuniaoEntre(
                inicio,
                fim,
                mails
        );

        assertEquals("Erro em marcarReuniaoEntre()",mails,marcadorDeReuniao.reuniao.getMail());
        assertEquals("Erro em marcarReuniaoEntre()",inicio,marcadorDeReuniao.reuniao.getInicio());
        assertEquals("Erro em marcarReuniaoEntre()",fim,marcadorDeReuniao.reuniao.getFim());
    }


    private void testIndicaDisponibilidade() {

        Exception exception = assertThrows(NullPointerException.class,()->{
            marcadorDeReuniao.mostraSobreposicao();
        });

        assertTrue("Erro em lançar excessão",exception.getMessage().contains("Nenhum horario disponivel"));

        marcadorDeReuniao.indicaDisponibilidadeDe("teste@teste.com",
                LocalDateTime.of(2021,10,12,0,0),
                LocalDateTime.of(2021,10,12,3,30));

        marcadorDeReuniao.indicaDisponibilidadeDe("teste@teste.com",
                LocalDateTime.of(2021,10,13,0,0),
                LocalDateTime.of(2021,10,13,8,0));

        marcadorDeReuniao.indicaDisponibilidadeDe("testador@teste.com",
                LocalDateTime.of(2021,10,11,23,0),
                LocalDateTime.of(2021,10,12,5,0));

        marcadorDeReuniao.indicaDisponibilidadeDe("testador@teste.com",
                LocalDateTime.of(2021,10,13,7,0),
                LocalDateTime.of(2021,10,13,9,30));

        testMostrarSobreposicao();
    }

    private void testMostrarSobreposicao() {

        marcadorDeReuniao.mostraSobreposicao();

        List<Disponibilidade> disponibilidadeList = marcadorDeReuniao.disponibilidadeList;

        assertEquals("Erro na sobreposição",4,disponibilidadeList.size());

        assertEquals("Erro na sobreposição",
                LocalDateTime.of(2021,10,12,0,0)
                ,disponibilidadeList.get(0).getInicio());
        assertEquals("Erro na sobreposição",
                LocalDateTime.of(2021,10,12,1,0)
                ,disponibilidadeList.get(1).getInicio());
        assertEquals("Erro na sobreposição",
                LocalDateTime.of(2021,10,12,2,0)
                ,disponibilidadeList.get(2).getInicio());
        assertEquals("Erro na sobreposição",
                LocalDateTime.of(2021,10,13,7,0)
                ,disponibilidadeList.get(3).getInicio());

    }


}
