package salas;

import exception.HorarioConflitante;
import exception.SalaInexistente;

import java.time.LocalDateTime;
import java.util.*;

public class SalasManager {

    private static List<Sala> salaList;

    private static SalasManager salasManager;

    private SalasManager() {
        super();
        salaList = new ArrayList<>();
    }

    public static synchronized SalasManager instanceOfSalasManager(){

        if(salasManager instanceof SalasManager){
            return salasManager;
        }

        salasManager = new SalasManager();
        return salasManager;
    }



    public void adicionaSalaChamada(String nome, int capacidadeMaxima, String descricao){
       adicionaSala(new Sala(nome,capacidadeMaxima,descricao));
    }

    public void removeSalaChamada(String nomeDaSala){
        for (int i = 0; i < salaList.size(); i++){
            if(salaList.get(i).getNome().toLowerCase().equals(nomeDaSala.toLowerCase())){
                salaList.remove(i);
                break;
            }
        }
    }


    public List<Sala> listaDeSalas() {
        return salaList;
    }

    public void adicionaSala(Sala sala){
        salaList.add(sala);
    }

    public Reserva reservaSalaChamada(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal) throws SalaInexistente, HorarioConflitante {
        Reserva reserva = new Reserva(nomeDaSala,dataInicial,dataFinal);

        for (Sala sala : salaList) {
            if (sala.getNome().toLowerCase().equals(nomeDaSala.toLowerCase())) {
                sala.addReserva(reserva);
                return reserva;
            }
        }

        throw new SalaInexistente();
    }

    public Collection<Reserva> reservasParaSala(String nomeSala){

        for (Sala sala : salaList) {
            if (sala.getNome().toLowerCase().equals(nomeSala.toLowerCase())) {
               return sala.getReservaList();
            }
        }

        return null;
    }

    public void cancelaReserva(Reserva cancelada){

        for (Sala sala : salaList) {
            if (sala.getNome().toLowerCase().equals(cancelada.getNomeDaSala().toLowerCase())) {
                sala.getReservaList().remove(cancelada);
            }
        }

    }

    public void imprimeReservaDaSala(String nomeSala){

        Collection<Reserva> list = reservasParaSala(nomeSala);
        list.forEach(reserva ->{
            System.out.printf("Reserva das %s as %s\n",reserva.getDataInicial(),reserva.getDataFinal());
        });

    }


}
