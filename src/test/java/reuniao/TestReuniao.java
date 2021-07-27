package reuniao;


import org.junit.jupiter.api.Test;

import java.util.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestReuniao {

    @Test
    public void test(){
        LocalDate inicio = LocalDate.of(2021,10,12);
        LocalDate fim = LocalDate.of(2021,10,15);
        List<String> mails = new ArrayList<>();
        mails.add("teste@testse.com");
        mails.add("testador@testse.com");

        Reuniao reuniao = new Reuniao(inicio,fim,mails);

        testInicio(reuniao);
        testFim(reuniao);
        testDisponibilidade(reuniao);
        testMail(reuniao,mails);

    }

    private void testMail(Reuniao reuniao,List<String> mails) {
        List<String> strings = reuniao.getMail();
        assertEquals(mails.size(),strings.size(),"Erro em getMail()");
        for(int i = 0; i < mails.size(); i++)
            assertEquals("Erro get Mail()",mails.get(i),strings.get(i));
    }

    private void testDisponibilidade(Reuniao reuniao) {
        assertEquals(new ArrayList<>(),reuniao.getDisponibilidade(),"Iniciação não nula");
    }

    private void testFim(Reuniao reuniao) {
        assertEquals(LocalDate.of(2021,10,15), reuniao.getFim(), "Erro no getFim");
        reuniao.setFim(LocalDate.of(2021,10,18));
        assertEquals(LocalDate.of(2021,10,18), reuniao.getFim(), "Erro no setFim");
    }

    private void testInicio(Reuniao reuniao) {
        assertEquals(LocalDate.of(2021,10,12), reuniao.getInicio(), "Erro no getInicio");
        reuniao.setInicio(LocalDate.of(2021,10,11));
        assertEquals(LocalDate.of(2021,10,11), reuniao.getInicio(), "Erro no setInicio");
    }
}
