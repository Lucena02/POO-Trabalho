package POOTrabalho.src;

public class SmartBulb extends SmartDevice{
    public enum Tone{
        COLD,
        NEUTRAL,
        WARM
    }
    private Tone tone;
    private double diametro;
    private static final int  cpCold=1;
    private static final int  cpNeutral=2;
    private static final int  cpWarm=3;

    public SmartBulb(Tone tone, double diametro) {
        this.tone = tone;
        this.diametro = diametro;
    }

    public SmartBulb(Modo modo, String codigo, double custoInstalacao, double consumoDiario, Tone tone, double diametro) {
        super(modo, codigo, custoInstalacao, consumoDiario);
        this.tone = tone;
        this.diametro = diametro;
    }

    public SmartBulb(SmartDevice sd, Tone tone, double diametro) {
        super(sd);
        this.tone = tone;
        this.diametro = diametro;
    }

    public SmartBulb(){
        super();
        this.tone=Tone.COLD;
        this.diametro=0;
    }
    public Tone getTone(){
        return this.tone;
    }

    public void setTone(Tone tone){
        this.tone=tone;
    }
    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double calculoCusto(){
        return 0;
    }
}
