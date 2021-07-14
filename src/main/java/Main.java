import reuniao.MarcadorDeReuniao;
import reuniao.Participante;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        System.out.println("*********************************************************");
        System.out.println("Reserva de Salas");
        System.out.println("");
        MarcadorDeReuniao mr = new MarcadorDeReuniao();
        List<String> list = new ArrayList<>();

        list.add("Duda");
        list.add("Frodo");
        list.add("Gii");

        mr.marcarReuniaoEntre(LocalDate.of(2021,10,2),
                LocalDate.of(2021,10,3),list);

        mr.indicaDisponibilidadeDe("Duda",
                LocalDateTime.of(2021,10,2,20,0),
                LocalDateTime.of(2021,10,2,21,0));
        mr.indicaDisponibilidadeDe("Frodo",
                LocalDateTime.of(2021,10,2,19,0),
                LocalDateTime.of(2021,10,2,21,0));
        mr.indicaDisponibilidadeDe("Gii",
                LocalDateTime.of(2021,10,2,20,0),
                LocalDateTime.of(2021,10,2,22,0));
        mr.mostraSobreposicao();
    }
}
