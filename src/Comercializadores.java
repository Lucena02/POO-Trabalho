package POOTrabalho.src;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Comercializadores {

    private Map<String,Integer> comercializadores;

    public Comercializadores(){
        this.comercializadores = new HashMap<>();
    }
    public Comercializadores(Comercializadores c){
        this.comercializadores = c.getComercializadores();

    }

    public Comercializadores(Map<String, Integer> comercializadores) {
        this.comercializadores = comercializadores;
    }

    public Comercializadores(String marca, Integer i){
        this.comercializadores = new HashMap<>();
        comercializadores.put(marca,i);
    };


    public Map<String, Integer> getComercializadores() {
        return new HashMap<>(comercializadores);
    }

    public void setComercializadores(Map<String, Integer> comercializadores) {
        this.comercializadores = new HashMap<>(comercializadores);
    }

    public void addComercializador(String marca){
        int rdmNum = ThreadLocalRandom.current().nextInt(1,4);
        this.comercializadores.put(marca,rdmNum);
    }

    public Integer getCodigoFornecedor(String marca){
        return this.comercializadores.get(marca);
    }

    public Comercializadores clone(){
        return new Comercializadores(this);
    }

}
