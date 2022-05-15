package POOTrabalho.src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vizinhanca {
    private List<CasaInteligente> casaL;
    private List<Fornecedor> fornecedoresL;


    public Vizinhanca(){
        this.casaL= new ArrayList<>();
        this.fornecedoresL = new ArrayList<>();
    }

    public Vizinhanca(List<CasaInteligente> casaL, List<Fornecedor> fornecedoresL) {
        setCasaL(casaL);
        setFornecedoresL(fornecedoresL);
    }

    public List<CasaInteligente> getCasaL() {
        return (this.casaL.stream().map(CasaInteligente::clone).collect(Collectors.toList()));
    }

    public void setCasaL(List<CasaInteligente> casaL) {
        this.casaL = casaL.stream().map(CasaInteligente::clone).collect(Collectors.toList());
    }

    public List<Fornecedor> getFornecedoresL() {
        return (this.fornecedoresL.stream().map(Fornecedor::clone).collect(Collectors.toList()));
    }

    public void setFornecedoresL(List<Fornecedor> fornecedoresL) {
        this.fornecedoresL = fornecedoresL.stream().map(Fornecedor::clone).collect(Collectors.toList());
    }

    public void addCasa(CasaInteligente casa){
        casaL.add(casa.clone());
    }

    public void addForn(Fornecedor forn){
        fornecedoresL.add(forn.clone());
    }



}
