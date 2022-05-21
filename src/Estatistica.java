package POOTrabalho.src;

import java.util.Iterator;

public class Estatistica {

    public CasaInteligente casaRica(Vizinhanca vizinhanca){
        CasaInteligente casaR = new CasaInteligente();
        double recorde = 0;

        for(CasaInteligente c : vizinhanca.getCasaL()){
            if (c.getFatura().getCustoDaFatura() > recorde){
                casaR = c.clone();
                recorde = c.getFatura().getCustoDaFatura();
            }
        }

        return casaR;
    }


}
