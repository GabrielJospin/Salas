package salas;

import exception.HorarioConflitante;

import java.util.*;

public class Sala {

    private String nome;
    private int capacidadeMax;
    private String descricao;
    private String local;
    private String observacoes;
    private List<Reserva> reservaList;

    public Sala(String nome, int capacidadeMax, String descricao) {
        this.nome = nome;
        this.capacidadeMax = capacidadeMax;
        this.descricao = descricao;
        this.reservaList = new ArrayList<>();
    }


    public void addReserva(Reserva reserva) throws HorarioConflitante {

        for (Reserva value : reservaList) {
                testReserva(value, reserva);
        }
        reservaList.add(reserva);
    }

    public void testReserva(Reserva reservaDaLista, Reserva reservaInserida) throws HorarioConflitante {
        int comaparewithInit = reservaDaLista.getDataInicial().compareTo(reservaInserida.getDataInicial());
        int comaparewithEnd = reservaDaLista.getDataInicial().compareTo(reservaInserida.getDataFinal());
        if(comaparewithInit > 0 && comaparewithEnd < 0){
           throw new HorarioConflitante();
        }

        comaparewithInit = reservaDaLista.getDataFinal().compareTo(reservaInserida.getDataInicial());
        comaparewithEnd = reservaDaLista.getDataFinal().compareTo(reservaInserida.getDataFinal());
        if(comaparewithInit > 0 && comaparewithEnd < 0){
            throw new HorarioConflitante();
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "nome='" + nome + '\'' +
                ", capacidadeMax=" + capacidadeMax +
                ", descricao='" + descricao + '\'' +
                ", local='" + local + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", reservaList=" + reservaList +
                '}';
    }
}
