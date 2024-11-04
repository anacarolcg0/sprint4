package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class VeiculoTO {
    private Long codigo;
    @NotBlank private String placa;
    @NotBlank private String modelo;
    @NotBlank private String cor;
    @PastOrPresent private LocalDate dataDeFabricacao;

    public VeiculoTO() {}

    public VeiculoTO(Long codigo, String placa, String modelo, String cor, LocalDate dataDeFabricacao) {
        this.codigo = codigo;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.dataDeFabricacao = dataDeFabricacao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotBlank String placa) {
        this.placa = placa;
    }

    public @NotBlank String getModelo() {
        return modelo;
    }

    public void setModelo(@NotBlank String modelo) {
        this.modelo = modelo;
    }

    public @NotBlank String getCor() {
        return cor;
    }

    public void setCor(@NotBlank String cor) {
        this.cor = cor;
    }

    public @PastOrPresent LocalDate getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    public void setDataDeFabricacao(@PastOrPresent LocalDate dataDeFabricacao) {
        this.dataDeFabricacao = dataDeFabricacao;
    }
}
