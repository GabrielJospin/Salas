package reuniao;

import org.junit.Test;

import java.util.*;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
        assertEquals("Erro em getMail()",mails.size(),strings.size(),0.0);
        for(int i = 0; i < mails.size(); i++)
            assertEquals("Erro get Mail()",mails.get(i),strings.get(i));
    }

    private void testDisponibilidade(Reuniao reuniao) {
        assertEquals("Iniciação não nula",new ArrayList<>(),reuniao.getDisponibilidade());
    }

    private void testFim(Reuniao reuniao) {
        assertEquals("Erro no getFim",LocalDate.of(2021,10,15),reuniao.getFim());
        reuniao.setFim(LocalDate.of(2021,10,18));
        assertEquals("Erro no setFim",LocalDate.of(2021,10,18),reuniao.getFim());
    }

    private void testInicio(Reuniao reuniao) {
        assertEquals("Erro no getInicio",LocalDate.of(2021,10,12),reuniao.getInicio());
        reuniao.setInicio(LocalDate.of(2021,10,11));
        assertEquals("Erro no setInicio",LocalDate.of(2021,10,11),reuniao.getInicio());
    }
}
