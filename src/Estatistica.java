package POOTrabalho.src;

import java.util.Iterator;

public class Estatistica {


    public Estatistica(){}
    public CasaInteligente casaRica(Vizinhanca vizinhanca){
        CasaInteligente casaR = new CasaInteligente();
        double recorde = 0;

        for(CasaInteligente c : vizinhanca.getCasaL()){
            if (c.getFatura().getCustoDaFatura() > recorde){
                System.out.println("ola!");
                casaR = c.clone();
                recorde = c.getFatura().getCustoDaFatura();
            }
        }

        return casaR;
    }


}
