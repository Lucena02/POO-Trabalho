package POOTrabalho.src;

    public abstract class SmartDevice {
    public enum Modo {
        ON,
        OFF
    }
    private Modo modo;
    private String codigo;
    private double consumoDiario;
    private double custoInstalacao;


    public SmartDevice(){
        this.modo = Modo.OFF;
        this.codigo = null;
        this.consumoDiario = 0;
        this.custoInstalacao = 0;

    }

    public SmartDevice (Modo modo, String codigo, double custoInstalacao, double consumoDiario) {
        this.modo = modo;
        this.codigo = codigo;
        this.custoInstalacao = custoInstalacao;
        this.consumoDiario = consumoDiario;
    }

    public SmartDevice(SmartDevice sd){
        this.modo = sd.getModo();
        this.codigo= sd.getCodigo();
        this.consumoDiario = sd.getConsumoDiario();
        this.custoInstalacao = sd.getCustoInstalacao();
    }
    public abstract double calculoCusto();

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getConsumoDiario() {
        return consumoDiario;
    }

    public void setConsumoDiario(double consumoDiario) {
        this.consumoDiario = consumoDiario;
    }

    public double getCustoInstalacao() {
        return custoInstalacao;
    }

    public void setCustoInstalacao(double custoInstalacao) {
        this.custoInstalacao = custoInstalacao;
    }

    public void DesligarSmart(){
        this.modo = Modo.OFF;
    }

    public  void LigarSmart(){
        this.modo = Modo.ON;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("SmartDevice: ").append(this.modo)
          .append("\nCodigo de Identificação: ").append(this.codigo)
          .append("\nCusto de Instalação: ").append(this.custoInstalacao)
          .append("\nConsumo Diario: ").append(this.consumoDiario).append( " kWh");
        return sb.toString();
    }

    public boolean equals(Object o){
        if (this ==o) return true;
        if ((o==null) || (this.getClass() != o.getClass())) return false;

        SmartDevice sd = (SmartDevice) o;
        return  sd.getModo() == this.modo &&
                this.codigo.equals(sd.getCodigo()) &&
                sd.getCustoInstalacao() == this.custoInstalacao &&
                sd.getConsumoDiario() == this.getConsumoDiario();
    }

    public abstract SmartDevice clone();


}
