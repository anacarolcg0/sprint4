package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class SinistroTO {
    private Long codigo;
    @NotBlank private String descricaoDoSinistro;
    @NotNull @PositiveOrZero private Double valorDoSinistro;
    @PastOrPresent private LocalDate dataDoSinistro;

    public SinistroTO() {}

    public SinistroTO(Long codigo, String descricaoDoSinistro, Double valorDoSinistro, LocalDate dataDoSinistro) {
        this.codigo = codigo;
        this.descricaoDoSinistro = descricaoDoSinistro;
        this.valorDoSinistro = valorDoSinistro;
        this.dataDoSinistro = dataDoSinistro;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getDescricaoDoSinistro() {
        return descricaoDoSinistro;
    }

    public void setDescricaoDoSinistro(@NotBlank String descricaoDoSinistro) {
        this.descricaoDoSinistro = descricaoDoSinistro;
    }

    public @NotNull @PositiveOrZero Double getValorDoSinistro() {
        return valorDoSinistro;
    }

    public void setValorDoSinistro(@NotNull @PositiveOrZero Double valorDoSinistro) {
        this.valorDoSinistro = valorDoSinistro;
    }

    public @PastOrPresent LocalDate getDataDoSinistro() {
        return dataDoSinistro;
    }

    public void setDataDoSinistro(@PastOrPresent LocalDate dataDoSinistro) {
        this.dataDoSinistro = dataDoSinistro;
    }
}
