package POOTrabalho.src;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Simulacao {


        public static void main(String[] args){
            Parser p = new Parser();
            Vizinhanca vizinhanca = p.parse();

            LocalDate start = LocalDate.parse("2020-11-03");
            LocalDate end = LocalDate.parse("2020-12-15");

            long dias = DAYS.between(start, end);
            Comercializadores comercializadores = vizinhanca.getComercializadores();
            double custo = vizinhanca.calculaCustoVizinhanca(dias, comercializadores);
            System.out.println("dada");
            System.out.println(custo);












        }








}
