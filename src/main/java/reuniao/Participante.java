package reuniao;

import java.time.LocalDateTime;

public class Participante {

    private String nome;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public Participante(String nome) {
        this.nome = nome;
        this.inicio = LocalDateTime.of(0,1,1,0,0);
        this.fim = LocalDateTime.of(0,1,1,0,0);
    }

    public Participante(String nome, LocalDateTime inicio, LocalDateTime fim) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
}
