import java.util.Objects;

public class SmartSpeaker extends SmartDevices {
    private int volume; // como limitar entre 0 a 100?
    private double frequencia; //tipo de dado na frequencia?
    private String marca; // que ser final?

    public SmartSpeaker(Modo modo, String codigo, double custoInstalacao, double consumoDiario, int volume, double frequencia, String marca) {
        super(modo, codigo, custoInstalacao, consumoDiario);
        this.volume = volume;
        this.frequencia = frequencia;
        this.marca = marca;
    }

    public SmartSpeaker(SmartDevices sd, int volume, double frequencia, String marca) {
        super(sd);
        this.volume = volume;
        this.frequencia = frequencia;
        this.marca = marca;
    }

    public SmartSpeaker(SmartSpeaker ss){
        this.volume = ss.getVolume();
        this.frequencia = ss.getFrequencia();
        this.marca = ss.getMarca();
    }

    public SmartSpeaker(){
        super();
        this.volume = 0;
        this.frequencia = 0;
        this.marca = "";
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double calculoCusto(){
        return this.volume;
    }


    @Override
    public SmartSpeaker clone(){
        return new SmartSpeaker(this); // como funcionar com o construtor
    }
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append("SmartSpeaker: ").append(this.marca)
                .append("\nVolume: ").append(this.volume)
                .append("\nFrequencia: ").append(this.frequencia);
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
                this.frequencia == that.getFrequencia();
    }
}
