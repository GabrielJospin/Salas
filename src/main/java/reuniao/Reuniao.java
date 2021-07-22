package reuniao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reuniao {

    private LocalDate inicio;
    private LocalDate fim;
    private List<Participante> disponibilidade;
    private List<String> mail;
    private int qtdParticipantes;

    public Reuniao(LocalDate inicio, LocalDate fim, List<String> mail) {
        this.inicio = inicio;
        this.fim = fim;
        this.disponibilidade = new ArrayList<>();
        this.qtdParticipantes = mail.size();
        this.mail = mail;
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

    public List<Participante> getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(List<Participante> disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getQtdParticipantes() {
        return qtdParticipantes;
    }

    public void setQtdParticipantes(int qtdParticipantes) {
        this.qtdParticipantes = qtdParticipantes;
    }

    public List<String> getMail() {
        return mail;
    }

    public void setMail(List<String> mail) {
        this.mail = mail;
    }
}
