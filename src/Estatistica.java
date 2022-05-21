package POOTrabalho.src;

import java.util.*;
import java.util.stream.Collectors;

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


    public String ComercializadorRico(Vizinhanca vizinhanca) throws NoSuchElementException{
        Map<String, Double> faturas = new HashMap<>(); // cada Comercializador tem um número

        for (CasaInteligente casa : vizinhanca.getCasaL()) {
            if (!faturas.containsKey(casa.getNomeFornecedor())){
                faturas.put(casa.getNomeFornecedor(), casa.getFatura().getCustoDaFatura());
            }
            else {
                faturas.put(casa.getNomeFornecedor(), faturas.get(casa.getNomeFornecedor()) + casa.getFatura().getCustoDaFatura());
            }
        }
        Double x = faturas.values().stream().mapToDouble(v -> v).max().orElseThrow(NoSuchElementException::new);

        for(Map.Entry<String, Double> entry: faturas.entrySet()) {

            if(entry.getValue() == x) {
                return entry.getKey();
            }
        }
        return "Error";
    }


    public List<Fatura> listaFatura(String fornecedor, Vizinhanca vizinhanca){
        List<Fatura> result = new ArrayList<>();

        for(CasaInteligente casa : vizinhanca.getCasaL()){
            if(casa.getNomeFornecedor().equals(fornecedor)) result.add(casa.getFatura());
        }

        return result;
    }



}
