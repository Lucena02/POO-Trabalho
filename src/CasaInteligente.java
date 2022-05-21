package POOTrabalho.src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static POOTrabalho.src.ComercializadoresStrategy.mapFornecedores;

public class CasaInteligente {
    private Map<String,SmartDevice> devices;
    private Map<String, List<String>> divisoes;
    private String nomeP;
    private int nif;
    private String nomeFornecedor;
    private Fatura fatura;

    public CasaInteligente(Map<String, SmartDevice> devices, Map<String, List<String>> divisoes,
                           String nomeP, int nif, String nomeFornecedor, Fatura faturas) {
        setDevices(devices);
        setDivisoes(divisoes);
        this.nomeP = nomeP;
        this.nif = nif;
        this.nomeFornecedor = nomeFornecedor;
        setFatura(faturas);
    }

    public CasaInteligente(CasaInteligente casa){
        this.devices = casa.getDevices();
        this.divisoes = casa.getDivisoes();
        this.nomeP = casa.getNomeP();
        this.nif = casa.getNif();
        this.nomeFornecedor = casa.getNomeFornecedor();
        this.fatura = casa.getFatura();
    }

    public  CasaInteligente(String nomeP, int nif, String nomeFornecedor){
        this.nomeP = nomeP;
        this.nif = nif;
        this.nomeFornecedor = nomeFornecedor;
        this.devices = new HashMap<>();
        this.divisoes = new HashMap<>();
        this.fatura = new Fatura();
    }

    public CasaInteligente(){
        this.devices =  new HashMap<>();
        this.divisoes = new HashMap<>();
        this.nomeP = "";
        this.nif = 0;
        this.nomeFornecedor = "";
        this.fatura = new Fatura();
    }

    public Map<String, SmartDevice> getDevices() {
        return  devices
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().clone()));
    }

    public void setDevices(Map<String, SmartDevice> devices) {
        this.devices = new HashMap<>();

        devices.forEach((key,value) -> this.devices.put(key,value.clone()));
    }

    public Map<String, List<String>> getDivisoes() {
        return this .divisoes
                    .entrySet()
                    .stream()
                    .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().stream().collect(Collectors.toList())));
    }

    public void setDivisoes(Map<String, List<String>> divisoes) {
        this.divisoes = new HashMap<>();

        divisoes
                .forEach((key,value) ->this.divisoes.put(key,value.stream().collect(Collectors.toList())));
    }

    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public Fatura getFatura() {
        return fatura.clone();
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura.clone();
    }

    public boolean existsDevice(String codigo){
        return this.devices.containsKey(codigo);
    }

    public  boolean roomHasDevice (String room,String code){
        return (this.divisoes.get(room).contains(code));
    }

    public void addDevice(SmartDevice sd){
        this.devices.put(sd.getCodigo(),sd.clone());
        }

    public void addToRoom(String divisao, SmartDevice sd){

        for(Map.Entry<String,List<String>> g : divisoes.entrySet()) {
            if (g.getKey().equals(divisao)) {
                g.getValue().add(sd.getCodigo());
            }
        }
    }

    public void addToRoomById(String divisao, String ID){
        for(Map.Entry<String,List<String>> g : divisoes.entrySet()) {
            if (g.getKey().equals(divisao)) {
                g.getValue().add(ID);
            }
        }
    }

    public SmartDevice getDevice(String code){
        if(existsDevice(code)){
            return this.devices.get(code).clone();
        }
        else{return null;}
    }

    public void setALLOn(){
        this.devices.values().stream().forEach(e -> e.LigarSmart()); //CLONE EM TUDo?
    }

    public void setAllOff(){
        this.devices.values().stream().forEach(e -> e.DesligarSmart());
    }

    public void setOn(String code){
        this.devices.get(code).LigarSmart();
    }

    public void setOff(String code){
        this.devices.get(code).DesligarSmart();
    }

    public void setDivOff(String divisao){
        for(Map.Entry<String,List<String>> g : divisoes.entrySet()){
            if(g.getKey().equals(divisao)){
                g.getValue().stream().forEach(k -> getDevice(k).DesligarSmart());
            }
        }
    }

    public void setDivOn(String divisao){
        for(Map.Entry<String,List<String>> g : divisoes.entrySet()){
            if(g.getKey().equals(divisao)){
                g.getValue().stream().forEach(k -> getDevice(k).LigarSmart());
            }
        }
    }

    public void addRoom (String room){
        this.divisoes.putIfAbsent(room,new ArrayList<>());
    }

    public boolean hasRoom(String room){
        return this.divisoes.keySet().contains(room);
    }


    public void custoTotalCasa(LocalDate start, LocalDate end, long d, Comercializadores c){
        String nomeForn = this.getNomeFornecedor();
        Integer i = c.getCodigoFornecedor(nomeForn);
        double custoFatura = mapFornecedores.get(i).formulaEnergia(custoTotalDevices(d));
        this.fatura = new Fatura(custoFatura, start, end, nomeForn);
    }


    public double custoTotalDevices(long dias){
        return (double) this.devices.values().stream()
                .map(SmartDevice::clone)
                .mapToDouble(k -> k.calculoCusto()*dias)
                .sum();
    }

    @Override
    public  boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CasaInteligente that = (CasaInteligente) o;
        return this.nif == that.getNif() &&
                this.nomeP.equals(that.getNomeP()) &&
                this.divisoes.equals(that.getDivisoes()) &&
                this.devices.equals(that.getDevices()) &&
                this.nomeFornecedor.equals(that.getNomeFornecedor());
    }

    @Override
    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CasaInteligente de: ").append(this.nomeP)
                .append("\nNif: ").append(this.nif)
                .append("\nDivisoes: ").append(this.divisoes)
                .append("\nDevices: ").append(this.devices)
                .append("\nFornecedor: ").append(this.nomeFornecedor)
                .append("\nFaturas: ").append(this.fatura.toString());
        return sb.toString();
    }


}
