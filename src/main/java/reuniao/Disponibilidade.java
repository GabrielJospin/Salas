package reuniao;

import java.time.LocalDateTime;

public class Disponibilidade {

    private String mail;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public Disponibilidade(String mail) {
        this.mail = mail;
        this.inicio = LocalDateTime.of(0,1,1,0,0);
        this.fim = LocalDateTime.of(0,1,1,0,0);
    }

    public Disponibilidade(String mail, LocalDateTime inicio, LocalDateTime fim) {
        this.mail = mail;
        this.inicio = inicio;
        this.fim = fim;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
