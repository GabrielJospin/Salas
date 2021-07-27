import exception.HorarioConflitante;
import exception.SalaInexistente;
import reuniao.MarcadorDeReuniao;
import salas.Reserva;
import salas.Sala;
import salas.SalasManager;

import java.time.LocalDateTime;
import java.util.*;
import java.time.LocalDate;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static void cadastrarSala(){
        try {
            System.out.println("Cadastro de Salas");
            System.out.println("");

            System.out.println("Qual o nome da sala? ");
            String nome = scanner.nextLine();

            System.out.println("Qual a capacidade máxima da sala? ");
            int capacidade = scanner.nextInt();

            System.out.println("Escreva uma breve descrição de 1 linha da sala");
            String desc = scanner.nextLine();

            SalasManager salasManager = SalasManager.instanceOfSalasManager();
            salasManager.adicionaSalaChamada(nome, capacidade, desc);

            System.out.println("Deseja cadastrar nova sala? 1- sim/ 0-não");
            int answer = scanner.nextInt();

            if(answer==1)
                cadastrarSala();
            else
                hello();

        }catch (Exception e){
            System.out.println("Entrada invalida");
            System.out.println("Tente novamente");
            cadastrarSala();
        }
    }


    private static void reservarSala() {

    }

    private static void criarReuniao() {

    }

    private static void hello(){
        System.out.println("*********************************************************");
        System.out.println("Bem vindo ao App Reserva de salas");
        System.out.println("");
        System.out.println("O que deseja fazer?");
        System.out.println("1- Cadastrar Salas");
        System.out.println("2- Criar reunião");
        System.out.println("3- Reservar Sala");
        System.out.println("4- Sair");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                cadastrarSala();
                break;
            case 2:
                criarReuniao();
                break;
            case 3:
                reservarSala();
                break;
            default:
                break;
        }

    }


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
        } catch (SalaInexistente e){
            System.out.println(e.getMessageName() +": A sala pedida não existe");
        } catch (HorarioConflitante e){
            System.out.println(e.getMessageName()+": A Sala está ocupada no horário escolhido");
        }

        try {
            manager.reservaSalaChamada("amarela",
                    LocalDateTime.of(2021, 8, 10, 10, 0),
                    LocalDateTime.of(2021, 8, 10, 12, 0));
        } catch (SalaInexistente e){
            System.out.println(e.getMessageName() +": A sala pedida não existe");
        } catch (HorarioConflitante e){
            System.out.println(e.getMessageName()+": A Sala está ocupada no horário escolhido");
        }

        try {
            manager.reservaSalaChamada("amarela",
                    LocalDateTime.of(2021, 8, 10, 8, 0),
                    LocalDateTime.of(2021, 8, 10, 9, 1));
        } catch (SalaInexistente e){
            System.out.println(e.getMessageName() +": A sala pedida não existe");
        } catch (HorarioConflitante e){
            System.out.println(e.getMessageName()+": A Sala está ocupada no horário escolhido");
        }

        try {
            manager.reservaSalaChamada("azul",
                    LocalDateTime.of(2021, 8, 10, 8, 0),
                    LocalDateTime.of(2021, 8, 10, 9, 1));
        } catch (SalaInexistente e){
            System.out.println(e.getMessageName() +": A sala pedida não existe");
        } catch (HorarioConflitante e){
            System.out.println(e.getMessageName()+": A Sala está ocupada no horário escolhido");
        }

        try {
            manager.reservaSalaChamada("cor de burro quando foge",
                    LocalDateTime.of(2021, 8, 10, 8, 0),
                    LocalDateTime.of(2021, 8, 10, 9, 1));
        } catch (SalaInexistente e){
            System.out.println(e.getMessageName() +": A sala pedida não existe");
        } catch (HorarioConflitante e){
            System.out.println(e.getMessageName()+": A Sala está ocupada no horário escolhido");
        }


        System.out.println(manager.reservasParaSala("amarela"));

        manager.cancelaReserva(new Reserva("amarela",
                LocalDateTime.of(2021, 8, 10, 10, 0),
                LocalDateTime.of(2021, 8, 10, 12, 0)));



        manager.imprimeReservaDaSala("azul");



        participantes.add("Duda");
        participantes.add("Frodo");
        participantes.add("Gii");

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
