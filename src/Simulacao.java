package POOTrabalho.src;

import java.time.LocalDate;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public class Simulacao {


    public static void main(String[] args) throws WrongFileException, NoSuchElementException {
        System.out.println("EScolha uma destas");
        System.out.println("De um Path para carregar um Estado ");

        System.out.println("De um Path para carregar dar Parsing");
        Parser p = new Parser();
        Vizinhanca vizinhanca = p.parse();

        Scanner sc = new Scanner(System.in);


        System.out.println("---------------------------------------------------------------");
        System.out.println("|                                                              |");
        System.out.println("|    _____________       _____            _____________        |");
        System.out.println("|   |   _______   |     |     |          |             |       |");
        System.out.println("|   |   |     |   |     |     |          |     ___     |       |");
        System.out.println("|   |   |     |   |     |     |          |    |___|    |       |");
        System.out.println("|   |   |     |   |     |     |          |     ___     |       |");
        System.out.println("|   |   |     |   |     |     |          |    |   |    |       |");
        System.out.println("|   |   |     |   |     |     |          |    |   |    |       |");
        System.out.println("|   |   |     |   |     |     |____      |    |   |    |       |");
        System.out.println("|   |   |_____|   |     |          |     |    |   |    |       |");
        System.out.println("|   |_____________|     |__________|     |____|   |____|       |");
        System.out.println("|                                                              |");
        System.out.println("---------------------------------------------------------------");

        System.out.println("Introduz uma data ínicio no formato YY-MM-DD:");
        LocalDate start = LocalDate.parse(sc.next());

        System.out.println("Introduz uma data ínicio no formato YY-MM-DD:");
        LocalDate end = LocalDate.parse(sc.next());


        Estatistica stats = new Estatistica();
        long dias = DAYS.between(start, end);
        Comercializadores comercializadores = vizinhanca.getComercializadores();
        double custo = vizinhanca.calculaCustoVizinhanca(start,end, dias, comercializadores);

        System.out.println("1 | Calcular Custo das Casas");
        System.out.println("2 | Casa que mais dinheiro gastou");
        System.out.println("3 | Comercializador com maior volume de faturação");
        System.out.println("4 | Todas as faturas emitidas por um Comercializador");
        System.out.println("5 | Sair");
        int x = sc.nextInt();
        if (x == 1){
            System.out.println("dada");
            System.out.println(custo);
        };
        if (x == 2){
            System.out.println(stats.casaRica(vizinhanca));
        };
        if (x == 3){
            System.out.println(stats.ComercializadorRico(vizinhanca));
        };
        if (x == 4){
            System.out.println("Insira um Comercializador");
            String y = sc.next();
            System.out.println(stats.listaFatura(y, vizinhanca));
        };
        if (x == 5);

        sc.close();
    }






}








