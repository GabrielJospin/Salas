package reuniao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reuniao {

    private LocalDate inicio;
    private LocalDate fim;
    private List<Participante> participantes;

    public Reuniao(LocalDate inicio, LocalDate fim, List<String> participantes) {
        this.inicio = inicio;
        this.fim = fim;
        this.participantes = new ArrayList<>();
        for( String participante : participantes){
            Participante p = new Participante(participante);
            this.participantes.add(p);
        }
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}
