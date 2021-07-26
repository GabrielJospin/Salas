package reuniao;

import org.junit.Test;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestDisponibilidade {

    @Test
    public void test(){
        Disponibilidade disponibilidade = new Disponibilidade("teste@teste.com",
                LocalDateTime.of(2021,12,10,0,0),
                LocalDateTime.of(2021,12,11,23,59));

        testMail(disponibilidade);
        testInicio(disponibilidade);
        testFim(disponibilidade);
    }

    public void testMail(Disponibilidade disponibilidade){
        if(disponibilidade == null)
            fail("Erro ao criar construtor");

        assertEquals("Erro no getMail()","teste@teste.com",disponibilidade.getMail());
        disponibilidade.setMail("testador@teste.com");
        assertEquals("Erro no setMail()","testador@teste.com",disponibilidade.getMail());
    }

    public void testInicio(Disponibilidade disponibilidade){
        if(disponibilidade == null)
            fail("Erro ao criar construtor");

        assertEquals("Erro no getInicio()",LocalDateTime.of(2021,12,10,0,0),disponibilidade.getInicio());
        disponibilidade.setInicio(LocalDateTime.of(2021,12,11,0,0));
        assertEquals("Erro no setInicio()",LocalDateTime.of(2021,12,11,0,0),disponibilidade.getInicio());
    }

    public void testFim(Disponibilidade disponibilidade){
        if(disponibilidade == null)
            fail("Erro ao criar construtor");

        assertEquals("Erro no getFim()",LocalDateTime.of(2021,12,11,23,59),disponibilidade.getFim());
        disponibilidade.setFim(LocalDateTime.of(2021,12,12,0,0));
        assertEquals("Erro no setFim()",LocalDateTime.of(2021,12,12,0,0),disponibilidade.getFim());
    }
}
