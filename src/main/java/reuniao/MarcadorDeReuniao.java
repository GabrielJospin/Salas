package reuniao;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;

public class MarcadorDeReuniao {

    Reuniao reuniao;

    public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal,
                                   Collection<String> listaDeParticipantes){
        reuniao = new Reuniao(dataInicial, dataFinal, (List<String>) listaDeParticipantes);
    }

    public void indicaDisponibilidadeDe(String participante,
                                        LocalDateTime inicio,
                                        LocalDateTime fim){
        reuniao.getParticipantes().stream().forEach(p -> {
            if (p.getNome().toLowerCase().equals(participante.toLowerCase())) {
                p.setInicio(inicio);
                p.setFim(fim);
            }
        });

    }

    public void mostraSobreposicao(){

        reuniao.getParticipantes().stream().forEach(p->{
            String nome = p.getNome();
            LocalDateTime inicio = p.getInicio();
            LocalDateTime fim = p.getFim();
            System.out.printf("%s disponivel em %s a %s\n",nome,inicio.toString(),fim.toString());
        });

        LocalDateTime inicio = LocalDateTime.of(reuniao.getInicio(), LocalTime.of(0,0));
        LocalDateTime fim = LocalDateTime.of(reuniao.getFim(), LocalTime.of(23,0));
        long time = inicio.until(fim, ChronoUnit.HOURS);
        int disponibilidade[] = new int[ (int) time];
        
    }

}
