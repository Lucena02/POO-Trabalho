package POOTrabalho.src;

public class SmartBulb extends SmartDevice{
    public enum Tone{
        Cold,
        Neutral,
        Warm
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
        this.tone=Tone.Cold;
        this.diametro=0;
    }
    public  SmartBulb(SmartBulb ss){
        super(ss);
        this.tone=ss.getTone();
        this.diametro=ss.getDiametro();
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

    @Override
    public SmartBulb clone(){
        return new SmartBulb(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append("SmartBulb modo: ").append(this.tone)
                .append("\nDiametro: ").append(this.diametro);
        return sb.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartBulb that = (SmartBulb) o;
        return  this.diametro == that.getDiametro() &&
                this.tone == that.tone;
    }












    public double calculoCusto(){
        switch (this.getTone()){
            case Cold: return this.getConsumoDiario();
            case Neutral: return this.getConsumoDiario()*cpNeutral;
            case Warm: return this.getConsumoDiario()*cpWarm;
        }
        return 0;
    }
}
