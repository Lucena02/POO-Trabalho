package POOTrabalho.src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vizinhanca {
    private List<CasaInteligente> casaL;
    private Comercializadores comercializadores;


    public Vizinhanca(){
        this.casaL= new ArrayList<>();
        this.comercializadores = new Comercializadores();
    }

    public Vizinhanca(List<CasaInteligente> casaL, Comercializadores comercializadores) {
        setCasaL(casaL);
        setComercializadores(comercializadores);
    }

    public Vizinhanca(Comercializadores comercializadores){
        setComercializadores(comercializadores);
    }
    public List<CasaInteligente> getCasaL() {
        return (this.casaL.stream().map(CasaInteligente::clone).collect(Collectors.toList()));
    }

    public void setCasaL(List<CasaInteligente> casaL) {
        this.casaL = casaL.stream().map(CasaInteligente::clone).collect(Collectors.toList());
    }

    public Comercializadores getComercializadores() {
        return comercializadores.clone();
    }

    public void setComercializadores(Comercializadores comercializadores) {
        this.comercializadores = comercializadores.clone();
    }

    public void addCasa(CasaInteligente casa){
        casaL.add(casa);
    }

    public double calculaCustoVizinhanca(long dias, Comercializadores c){
        return (double) this.casaL
                .stream()
                .map(CasaInteligente::clone)
                .mapToDouble(k -> k.custoTotalCasa(dias, c))
                .sum();
    }


}
