package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class ApoliceTO {
    private Long codigo;
    @NotBlank private String tipoDeCobertura;
    @NotNull @PositiveOrZero private Double valorSegurado;
    @PastOrPresent private LocalDate dataEmissao;

    public ApoliceTO() {}

    public ApoliceTO(Long codigo, String tipoDeCobertura, Double valorSegurado, LocalDate dataEmissao) {
        this.codigo = codigo;
        this.tipoDeCobertura = tipoDeCobertura;
        this.valorSegurado = valorSegurado;
        this.dataEmissao = dataEmissao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getTipoDeCobertura() {
        return tipoDeCobertura;
    }

    public void setTipoDeCobertura(@NotBlank String tipoDeCobertura) {
        this.tipoDeCobertura = tipoDeCobertura;
    }

    public @NotNull @PositiveOrZero Double getValorSegurado() {
        return valorSegurado;
    }

    public void setValorSegurado(@NotNull @PositiveOrZero Double valorSegurado) {
        this.valorSegurado = valorSegurado;
    }

    public @PastOrPresent LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(@PastOrPresent LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
