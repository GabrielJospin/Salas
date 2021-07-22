import exception.HorarioConflitante;
import exception.SalaInexistente;
import reuniao.MarcadorDeReuniao;
import reuniao.Participante;
import salas.Reserva;
import salas.SalasManager;

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
        List<String> participantes = new ArrayList<>();
        List<String> salas = new ArrayList<>();

        salas.add("Amarela");
        salas.add("Azul");
        salas.add("vermelha");

        SalasManager manager = SalasManager.instanceOfSalasManager();

        manager.adicionaSalaChamada("Amarela",10,"Sala do Infantil I");
        manager.adicionaSalaChamada("Azul",15,"Sala do Infantil II");
        manager.adicionaSalaChamada("Vermelha",13,"Sala do Infantil III");

        manager.removeSalaChamada("vermelha");

        System.out.println(manager.listaDeSalas().toString());



        try {
            manager.reservaSalaChamada("amarela",
                    LocalDateTime.of(2021, 8, 10, 9, 0),
                    LocalDateTime.of(2021, 8, 10, 11, 0));
        } catch (SalaInexistente | HorarioConflitante e){
            e.printStackTrace();
        }

        try {
            manager.reservaSalaChamada("amarela",
                    LocalDateTime.of(2021, 8, 10, 10, 0),
                    LocalDateTime.of(2021, 8, 10, 12, 0));
        } catch (SalaInexistente | HorarioConflitante e){
            e.printStackTrace();
        }

        try {
            manager.reservaSalaChamada("amarela",
                    LocalDateTime.of(2021, 8, 10, 8, 0),
                    LocalDateTime.of(2021, 8, 10, 9, 1));
        } catch (SalaInexistente | HorarioConflitante e){
            e.printStackTrace();
        }

        try {
            manager.reservaSalaChamada("azul",
                    LocalDateTime.of(2021, 8, 10, 8, 0),
                    LocalDateTime.of(2021, 8, 10, 9, 1));
        } catch (SalaInexistente | HorarioConflitante e){
            e.printStackTrace();
        }

        try {
            manager.reservaSalaChamada("cor de burro quando foge",
                    LocalDateTime.of(2021, 8, 10, 8, 0),
                    LocalDateTime.of(2021, 8, 10, 9, 1));
        } catch (SalaInexistente | HorarioConflitante e){
            e.printStackTrace();
        }


        System.out.println(manager.reservasParaSala("amarela"));

        manager.cancelaReserva(new Reserva("amarela",
                LocalDateTime.of(2021, 8, 10, 10, 0),
                LocalDateTime.of(2021, 8, 10, 12, 0)));



        manager.imprimeReservaDaSala("azul");



        participantes.add("Duda");
        participantes.add("Frodo");
        participantes.add("Gii");
        participantes.add("Balog");

        mr.marcarReuniaoEntre(LocalDate.of(2021,10,2),
                LocalDate.of(2021,10,3),participantes);

        mr.indicaDisponibilidadeDe("Duda",
                LocalDateTime.of(2021,10,2,20,0),
                LocalDateTime.of(2021,10,2,21,0));
        mr.indicaDisponibilidadeDe("Frodo",
                LocalDateTime.of(2021,10,2,19,0),
                LocalDateTime.of(2021,10,2,21,0));
        mr.indicaDisponibilidadeDe("Gii",
                LocalDateTime.of(2021,10,2,20,0),
                LocalDateTime.of(2021,10,2,22,0));

        mr.indicaDisponibilidadeDe("Balog",
                LocalDateTime.of(2021,10,3,9,0),
                LocalDateTime.of(2021,10,3,11,47));

        mr.indicaDisponibilidadeDe("Gabs",
                LocalDateTime.of(2021,10,3,9,0),
                LocalDateTime.of(2021,10,3,12,0));

        mr.indicaDisponibilidadeDe("Ana",
                LocalDateTime.of(2021,10,3,8,0),
                LocalDateTime.of(2021,10,3,13,0));
        mr.mostraSobreposicao();
    }
}
