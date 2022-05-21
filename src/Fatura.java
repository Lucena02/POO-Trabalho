package POOTrabalho.src;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Fatura {

    private double custoDaFatura;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private String fornecedor;


    public Fatura(double custoDaFatura, LocalDate dataInicio, LocalDate dataFinal, String fornecedor) {
        this.custoDaFatura = custoDaFatura;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.fornecedor = fornecedor;
    }

    public  Fatura(Fatura fatura){
        this.custoDaFatura = fatura.getCustoDaFatura();
        this.dataInicio = fatura.getDataInicio();
        this.dataFinal = fatura.getDataFinal();
        this.fornecedor = fatura.getFornecedor();
    }

    public Fatura(){
        this.custoDaFatura = 0;
        this.fornecedor = "N/A";
    }

    public double getCustoDaFatura() {
        return custoDaFatura;
    }

    public void setCustoDaFatura(double custoDaFatura) {
        this.custoDaFatura = custoDaFatura;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        fornecedor = fornecedor;
    }


    @Override
    public  Fatura clone()  {
        return new Fatura(this);
    }

    @Override
    public  boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fatura that = (Fatura) o;
        return this.custoDaFatura == that.getCustoDaFatura() &&
                this.dataInicio.equals(that.getDataInicio()) &&
                this.dataFinal.equals(that.getDataFinal()) &&
                this.fornecedor.equals(that.getFornecedor());
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--------------------")
                .append("\nFatura de custo: ").append(this.custoDaFatura)
                .append("\nData Inicio: ").append(this.dataInicio)
                .append("\nData Final: ").append(this.dataFinal)
                .append("\nFornecedor: ").append(this.fornecedor)
                .append("\n--------------------");
        return sb.toString();
    }

}

