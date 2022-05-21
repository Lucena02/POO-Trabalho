package POOTrabalho.src;

import com.sun.source.tree.ReturnTree;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Parser {
    int id;

    public Parser (){
        id=0;
    }

    public void AumentarID(){
        this.id= id+1;
    }

        public Vizinhanca parse() throws WrongFileException {
            List<String> linhas = lerFicheiro("logs.txt");
            String[] linhaPartida;
            String divisao = null;
            CasaInteligente casaMaisRecente = null;
            Comercializadores comercializadore = new Comercializadores();
            Vizinhanca comunidade = new Vizinhanca();
            for (String linha : linhas) {
                linhaPartida = linha.split(":", 2);
                switch(linhaPartida[0]){
                    case "Casa":
                        casaMaisRecente = parseCasa(linhaPartida[1]);
                        comunidade.addCasa(casaMaisRecente);
                        break;
                    case "Divisao":
                        if (casaMaisRecente == null) throw new WrongFileException();
                        divisao = linhaPartida[1];
                        casaMaisRecente.addRoom(divisao);
                        //(...)
                        break;
                    case "SmartBulb":
                        if (divisao == null) throw new WrongFileException();
                        SmartBulb sb = parseSmartBulb(linhaPartida[1]);
                        casaMaisRecente.addDevice(sb);
                        casaMaisRecente.addToRoomById(divisao,sb.getCodigo());
                        AumentarID();
                        //(...)
                        break;
                    case "SmartCamera":
                        if (divisao == null) throw new WrongFileException();
                        SmartCamera sc = parseSmartCamera(linhaPartida[1]);
                        casaMaisRecente.addDevice(sc);
                        casaMaisRecente.addToRoomById(divisao,sc.getCodigo());
                        AumentarID();
                    case "SmartSpeaker":
                        if (divisao == null) throw new WrongFileException();
                        SmartSpeaker ss = parseSmartSpeaker(linhaPartida[1]);
                        casaMaisRecente.addDevice(ss);
                        casaMaisRecente.addToRoomById(divisao,ss.getCodigo());
                        AumentarID();
                        System.out.println("Smartspeaker");
                    case "Fornecedor" :
                        System.out.println("dadadadFOrnecedor");
                        String marca = linhaPartida[1];
                        int rdmNum = ThreadLocalRandom.current().nextInt(1,4);
                        comercializadore.addComercializador(marca,rdmNum);
                    default:
                        throw new WrongFileException();
                }
            }
            comunidade.setComercializadores(comercializadore);
            System.out.println("done!");
            return comunidade;
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
            return new SmartBulb(rdmModo(),idS,50,custoDiario,tone,diametro);
        }

        public SmartCamera parseSmartCamera(String input){
            String[] campos = input.split(",");



            return new SmartCamera();
        }

        public SmartSpeaker parseSmartSpeaker(String input){
            String[] campos = input.split(",");
            int volume= Integer.parseInt(campos[0]);
            String canal = campos[1];
            String marca = campos[2];
            int custoDiario = Integer.parseInt(campos[3]);
            String idS = Integer.toString(id);

            return new SmartSpeaker(rdmModo(),idS,50,custoDiario,volume,canal,marca);
        }

        public SmartDevice.Modo rdmModo(){
            int rdmNum = ThreadLocalRandom.current().nextInt(1,4);
            if(rdmNum==1) {return SmartDevice.Modo.ON;}
            return SmartDevice.Modo.OFF;
        }






}