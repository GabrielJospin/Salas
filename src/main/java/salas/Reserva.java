package salas;

import java.time.LocalDateTime;

public class Reserva {

    private String nomeDaSala;
    private LocalDateTime dataInicial, dataFinal;

    public Reserva(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal) {
        this.nomeDaSala = nomeDaSala;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public String getNomeDaSala() {
        return nomeDaSala;
    }

    public void setNomeDaSala(String nomeDaSala) {
        this.nomeDaSala = nomeDaSala;
    }

    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDateTime dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nomeDaSala='" + nomeDaSala + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                '}';
    }
}
