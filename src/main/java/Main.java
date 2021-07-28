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


    private static void cadastrarSala(Scanner scanner){
        try {
            System.out.println("Opa, então vamos cadastrar uma sala agora");
            System.out.println("");

            System.out.println("Qual o nome da sala? ");
            String nome = scanner.next();

            System.out.println("Qual a capacidade máxima da sala? ");
            int capacidade = scanner.nextInt();

            System.out.println("Escreva uma breve descrição de 1 linha da sala");
            String desc = scanner.nextLine();

            SalasManager sm = SalasManager.instanceOfSalasManager();
            sm.adicionaSalaChamada(nome, capacidade, desc);

            System.out.println("Quer fazer um cadastro mais detalhado? 1-sim/ 0-não");
            int answer = scanner.nextInt();
            if(answer==1){
                int position = sm.listaDeSalas().indexOf(new Sala(nome,capacidade,desc));


                System.out.println("qual o local da sala?");
                sm.listaDeSalas().get(position).setLocal(scanner.nextLine());

                System.out.println("alguma observação? ");
                sm.listaDeSalas().get(position).setObservacoes(scanner.nextLine());
            }

            System.out.println("Deseja cadastrar nova sala? 1- sim/ 0-não");
            answer = scanner.nextInt();

            if(answer==1)
                cadastrarSala(scanner);
            else
                hello(scanner);

        }catch (Exception e){
            System.out.println("Opa, parece que você inseriu um dado invalido");
            System.out.println("Errar faz parte da vida, o importante é não desistir");
            cadastrarSala(scanner);
        }
    }

    private static void reservarSala(Scanner scanner) {
        try {
            SalasManager sm = SalasManager.instanceOfSalasManager();
            System.out.println("Opa, então vamos reservar a Sala");
            System.out.println("Primeiro vamos precisar do nome da Sala (uma só palavra)");
            String sala = scanner.next();
            System.out.println("Certo agora o horário inicial da reserva");
            LocalDateTime inicio = inserirHorario(scanner);
            System.out.println("O Horário final desta reserva");
            LocalDateTime fim = inserirHorario(scanner);
            sm.reservaSalaChamada(sala,inicio,fim);
            hello(scanner);
        }catch (SalaInexistente salaInexistente) {
            System.out.println("Opa parece que esta sala é inexistente");
            System.out.println("Tudo bem vamos tentar de novo....");
            reservarSala(scanner);
        } catch (HorarioConflitante horarioConflitante) {
            System.out.println("Poxa, alguém já marcou nesse horário");
            System.out.println("Vamos tentar outra sala ou horário:");
            reservarSala(scanner);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void planejarReuniao(Scanner scanner) {

        try{
            MarcadorDeReuniao mr = new MarcadorDeReuniao();
            System.out.println("Ah certo, então você deseja planejar uma reunião");
            System.out.println("");
            System.out.println("Bem, primeiro o Host deve passar os dados da reunião");
            System.out.println("Quando (no minimo) deve começar ser a reunião?");
            LocalDate inicio = inserirData(scanner);
            System.out.println( "Até quando pode terminar essa reuniao? ");
            LocalDate fim = inserirData(scanner);
            System.out.println("Digite o email de todos os participantes com um Espaço");

            List<String> mail = new ArrayList<>();
            while(scanner.hasNext()){
                mail.add(scanner.next());
            }

            mr.marcarReuniaoEntre(inicio,fim,mail);

            System.out.println("Agora cada participante deve cadastrar sua disponibilidade");


            marcarDisponibilidade(mr,scanner);

            System.out.println("hmm... Certo, agora me dexie fazer as contas aqui");
            System.out.println("Bem esses seriam os horarios ideais para a sua reunião:");
            mr.mostraSobreposicao();

            System.out.println("Se você voltar ao menu agora podemos marcar essa reunião...");
            hello(scanner);
        }catch (NullPointerException e){
            System.out.println("Opa parece que não houve um horario com todos disponiveis");
            System.out.println("Mas tudo bem vamos tentar re-planejá-la");
            planejarReuniao(scanner);
        } catch (Exception e){
            System.out.println("Opa parece que você digitou algum dado invalido");
            System.out.println("Está tudo bem, vamos tentar de novo");
            planejarReuniao(scanner);
        }

    }

    private static void marcarDisponibilidade(MarcadorDeReuniao mr, Scanner scanner) {

        try{

            System.out.println("Olá! Vamos ver aqui sua disponibilidade!");
            System.out.println("Qual o seu email? (Por favor não utilize espaços)");
            String mail = scanner.next();
            System.out.println("Agora qual o inicio da sua disponibilidade?");
            LocalDateTime inicio = inserirHorario(scanner);
            System.out.println("Agora qual o fim da sua disponibilidade?");
            LocalDateTime fim = inserirHorario(scanner);

            mr.indicaDisponibilidadeDe(mail,inicio,fim);

            System.out.println("Você quer cadastrar mais alguma disponibilidade (1- sim/ 0- não)");
            int answer = scanner.nextInt();
            if(answer == 1)
                marcarDisponibilidade(mr,scanner);
        }catch (Exception e){
            System.out.println("Oh não, recebemos um dado inválido");
            System.out.println("Erros podem acontecer, e está tudo bem, vamos tentar de novo");
            marcarDisponibilidade(mr,scanner);
        }
    }

    private static LocalDateTime inserirHorario(Scanner scanner) {

        try{
            System.out.println("não esqueça que deve inserir apenas valores numéricos");

            System.out.print("Ano: ");
            int year = scanner.nextInt();
            System.out.println();

            System.out.print("Mês: ");
            int month = scanner.nextInt();
            System.out.println();

            System.out.print("dia: ");
            int day = scanner.nextInt();
            System.out.println();

            System.out.print("Hora: ");
            int hour = scanner.nextInt();
            System.out.println();

            System.out.print("Minutos: ");
            int minute = scanner.nextInt();
            System.out.println();

            return LocalDateTime.of(year,month,day,hour,minute);
        }catch (Exception e){
            System.out.println("Opa, recebemos um dado errado");
            System.out.println("Vamos tentar outra vez, errar é humano mesmo");
            System.out.print("Ah e, ");
            return inserirHorario(scanner);
        }

    }

    private static LocalDate inserirData(Scanner scanner) {

        try {
            System.out.println("apenas inserir dados numéricos");

            System.out.print("Ano: ");
            int year = scanner.nextInt();
            System.out.println();

            System.out.print("Mês: ");
            int month = scanner.nextInt();
            System.out.println();

            System.out.print("dia: ");
            int day = scanner.nextInt();
            System.out.println();

            return LocalDate.of(year,month,day);
        }catch (Exception e){
            System.out.println("Ops, tivemos um erro aqui, parece que houve um dado inválido");
            System.out.println("Mas tudo bem, vamos tentar de novo");
            System.out.print("Ah e lembre-se de ");
            return inserirData(scanner);
        }

    }

    private static void hello(Scanner scanner){
        System.out.println("*********************************************************");
        System.out.println("Bem vindo ao App Reserva de salas");
        System.out.println("");
        System.out.println("O que deseja fazer?");
        System.out.println("1- Cadastrar Salas");
        System.out.println("2- Planejar reunião");
        System.out.println("3- Reservar Sala");
        System.out.println("4- Ver salas disponíveis");
        System.out.println("5- Ver reservas de uma sala");
        System.out.println("6- Cancelar reserva");
        System.out.println("7- Sair");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                cadastrarSala(scanner);
                break;
            case 2:
                planejarReuniao(scanner);
                break;
            case 3:
                reservarSala(scanner);
                break;
            case 4:
                listaDeSalas(scanner);
                break;
            case 5:
                listaDeReservas(scanner);
                break;
            case 6:
                cancelarReserva(scanner);
            case 42:
                answer(scanner);
                break;
            default:
                break;
        }

    }

    private static void cancelarReserva(Scanner scanner) {
        System.out.println("Opa então vamos cançelar esta reserva");
        System.out.println("Para isso precisaremos dos dados desta reserva");
        try{
            SalasManager sm = SalasManager.instanceOfSalasManager();

            System.out.println("Qual a sala reservada?");
            String sala = scanner.nextLine();
            System.out.println("Qual o horário de inicio");
            LocalDateTime inicio = inserirHorario(scanner);
            System.out.println("Qual o horario do fim");
            LocalDateTime fim  = inserirHorario(scanner);
            sm.cancelaReserva(new Reserva(sala,inicio,fim));
        }catch (Exception e){
            System.out.println("Opa tivemos um erro de inserção");
            System.out.println("vamos tentar novamente");
            cancelarReserva(scanner);
        }
    }

    private static void listaDeReservas(Scanner scanner) {
        SalasManager sm = SalasManager.instanceOfSalasManager();

        System.out.println("Bem vamos ver as reservas de uma sala");
        System.out.println("Qual sala você deseja procurar?");
        String sala = scanner.nextLine();
        System.out.printf("Reservas para a sala %s \n",sala);

        sm.imprimeReservaDaSala(sala);
    }

    private static void listaDeSalas(Scanner scanner) {
        System.out.println("Bem estas são as salas disponíveis: ");
        SalasManager sm = SalasManager.instanceOfSalasManager();
        List<Sala> salas = sm.listaDeSalas();
        salas.forEach(sala -> {
            System.out.printf("Sala: %s, capacidade: %d, Descrição: %s",
                    sala.getNome(), sala.getCapacidadeMax(),sala.getDescricao());
            if(!sala.getLocal().isEmpty())
                System.out.printf(", Local: %s",sala.getLocal());
            if(!sala.getObservacoes().isEmpty())
                System.out.printf(", P.S.: %s",sala.getObservacoes());
            System.out.println();
        });
        hello(scanner);
    }

    private static void answer(Scanner scanner) {
        System.out.println("the answer to life the universe and everything is");
        for (int i = 0; i <20; i++){
            try {
                Thread.sleep(100);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("42");
        hello(scanner);
    }


    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        hello(scanner);
        scanner.close();
        System.out.println("Encerrando o programa com sucesso");
        System.out.println("Obrigado por usar");
        System.out.println("Maria Eduarda Rodrigues - 11796621");
        System.out.println("Gabriel Medeiros Jospin - 11796020");
    }
}
