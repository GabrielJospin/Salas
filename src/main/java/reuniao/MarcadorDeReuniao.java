package reuniao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;

public class MarcadorDeReuniao {

    Reuniao reuniao;

    public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal,
                                   Collection<String> listaDeParticipantes){
        reuniao = new Reuniao(dataInicial, dataFinal, (List<String>) listaDeParticipantes);
    }

    public void indicaDisponibilidadeDe(String participante,
                                        LocalDateTime inicio,
                                        LocalDateTime fim){

        reuniao.getParticipantes().add(new Participante(participante,inicio,fim));

    }

    private Map<LocalDateTime,Integer> prepareList(){
        LocalDateTime inicio = LocalDateTime.of(reuniao.getInicio(),LocalTime.of(0,0));
        LocalDateTime fim = LocalDateTime.of(reuniao.getFim(), LocalTime.of(23,0));
        long time = inicio.until(fim, ChronoUnit.HOURS);
        Map<LocalDateTime,Integer> disponibilidade = new HashMap<>();
        for(int i = 0; i < time; i++){
            disponibilidade.put(inicio.plus(i,ChronoUnit.HOURS),0);
        }

        return disponibilidade;
    }

    public void mostraSobreposicao(){

        reuniao.getParticipantes().forEach(p->{
            String nome = p.getNome();
            LocalDateTime inicio = p.getInicio();
            LocalDateTime fim = p.getFim();
            System.out.printf("%s disponivel em %s a %s\n",nome,inicio.toString(),fim.toString());
        });

        Map<LocalDateTime,Integer> disponibilidade = prepareList();

        for(int i = 0; i<reuniao.getParticipantes().size();i++){
            Participante p = reuniao.getParticipantes().get(i);
            LocalDateTime inicio = LocalDateTime.of(reuniao.getInicio(),LocalTime.of(0,0)) ;
            long timeI = inicio.until(p.getInicio(),ChronoUnit.HOURS);
            long timeF = inicio.until(p.getFim(),ChronoUnit.HOURS);
            for(int j = (int) timeI; j < timeF && j < disponibilidade.size(); j++ ){
                LocalDateTime key = inicio.plus(j,ChronoUnit.HOURS);
                if (disponibilidade.containsKey(key)){
                    disponibilidade.replace(key,disponibilidade.get(key) + 1);
                }
            }
        }

        LocalDateTime inicio = LocalDateTime.of(reuniao.getInicio(),LocalTime.of(0,0));
    //<Hora, QTD Participantes>
        for(int i = 0; i < disponibilidade.size(); i++){
            LocalDateTime position = inicio.plus(i,ChronoUnit.HOURS);
            int value = disponibilidade.get(position);
            if(value == reuniao.getQtdParticipantes()){
                System.out.printf("%s tem todos os participantes\n",position.toString());
            }
        }

    }

}
