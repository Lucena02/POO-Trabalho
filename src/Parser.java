package POOTrabalho.src;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    int id;

    public Parser (){
        id=0;
    }

    public void AumentarID(){
        this.id= id+1;
    }

        public void parse(){
            List<String> linhas = lerFicheiro("logs.csv");
            String[] linhaPartida;
            String divisao = null;
            CasaInteligente casaMaisRecente = null;
            Vizinhanca comunidade = new Vizinhanca();
            for (String linha : linhas) {
                linhaPartida = linha.split(":", 2);
                switch(linhaPartida[0]){
                    case "Casa":
                        casaMaisRecente = parseCasa(linhaPartida[1]);
                        comunidade.addCasa(casaMaisRecente);
                        break;
                    case "Divisao":
                        if (casaMaisRecente == null) System.out.println("Linha inválida.");
                        divisao = linhaPartida[1];
                        casaMaisRecente.addRoom(divisao);
                        //(...)
                        break;
                    case "SmartBulb":
                        if (divisao == null) System.out.println("Linha inválida.");
                        SmartBulb sb = parseSmartBulb(linhaPartida[1]);
                        casaMaisRecente.addDevice(sb);
                        casaMaisRecente.addToRoomById(divisao,sb.getCodigo());
                        AumentarID();
                        //(...)
                        break;
                    case "SmartCamera":
                        if (divisao == null) System.out.println("Linha inválida.");
                        SmartCamera sc = parseSmartCamera(linhaPartida[1]);
                        casaMaisRecente.addDevice(sc);
                        casaMaisRecente.addToRoomById(divisao,sc.getCodigo());
                        AumentarID();
                    case "SmartSpeaker":
                        if (divisao == null) System.out.println("Linha inválida.");
                        SmartSpeaker ss = parseSmartSpeaker(linhaPartida[1]);
                        casaMaisRecente.addDevice(ss);
                        casaMaisRecente.addToRoomById(divisao,ss.getCodigo());
                        AumentarID();
                    case "Fornecedor" :
                        Fornecedor forn = linhaPartida[1];
                        comunidade.addForn(forn);
                    default:
                        System.out.println("Linha inválida.");
                        break;
                }
            }
            System.out.println("done!");
        }

        public List<String> lerFicheiro(String nomeFich) {
            List<String> lines;
            try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
            catch(IOException exc) { lines = new ArrayList<>(); }
            return lines;
        }

        public CasaInteligente parseCasa(String input){
            String[] campos = input.split(",");
            String nome = campos[0];
            int nif = Integer.parseInt(campos[1]);
            String nomeF = campos[2];
            return new CasaInteligente(nome,nif,nomeF);
        }

        public SmartBulb parseSmartBulb(String input){
            String[] campos = input.split(",");
            SmartBulb.Tone tone = SmartBulb.Tone.valueOf(campos[0]);
            int diametro = Integer.parseInt(campos[1]);
            int custoDiario = Integer.parseInt(campos[2]);
            String idS = Integer.toString(id);
            return new SmartBulb(SmartDevice.Modo.OFF,idS,50,custoDiario,tone,diametro);
        }

        public SmartCamera parseSmartCamera(String input){
            String[] campos = input.split(",");
        }

        public SmartSpeaker parseSmartSpeaker(String input){
            String[] campos = input.split(",");
            int volume= Integer.parseInt(campos[0]);
            String canal = campos[1];
            String marca = campos[2];
            int custoDiario = Integer.parseInt(campos[3]);
            String idS = Integer.toString(id);
            return new SmartSpeaker(SmartDevice.Modo.OFF,idS,50,custoDiario,volume,canal,marca);
        }








}