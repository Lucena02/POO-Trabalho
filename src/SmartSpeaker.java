package POOTrabalho.src;

import java.util.Objects;

public class SmartSpeaker extends SmartDevice {
    private int volume;
    public static final int MAX = 100;
    public static final int MIN = 0;
    private String canal;
    private String marca;

    public SmartSpeaker(Modo modo, String codigo, double custoInstalacao, double consumoDiario, int volume, String canal, String marca) {
        super(modo, codigo, custoInstalacao, consumoDiario);
        setVolume(volume);
        this.canal = canal;
        this.marca = marca;
    }

    public SmartSpeaker(SmartDevice sd, int volume, String canal, String marca) {
        super(sd);
        setVolume(volume);
        this.canal = canal;
        this.marca = marca;
    }

    public SmartSpeaker(SmartSpeaker ss){
        super(ss);
        this.volume = ss.getVolume();
        this.canal = ss.getCanal();
        this.marca = ss.getMarca();
    }

    public SmartSpeaker(){
        super();
        this.volume = 0;
        this.canal = "";
        this.marca = "";
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume){
        if(volume >MAX){this.volume=100;
        } else if(volume<MIN){
            this.volume=0;
        } else
        {this.volume=volume;}
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double calculoCusto(){
        if  (this.getModo()==Modo.ON) {
            return this.getConsumoDiario() * this.getVolume();
        }
        return 0;
    }


    @Override
    public SmartSpeaker clone(){
        return new SmartSpeaker(this);
    }
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append("SmartSpeaker: ").append(this.marca)
                .append("\nVolume: ").append(this.volume)
                .append("\nCanal: ").append(this.canal);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartSpeaker that = (SmartSpeaker) o;
        return this.marca.equals(that.getMarca()) &&
                this.volume== that.getVolume() &&
                this.canal.equals(that.getCanal());
    }
}
