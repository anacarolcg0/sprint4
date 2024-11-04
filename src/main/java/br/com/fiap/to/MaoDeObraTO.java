package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class MaoDeObraTO {
    private Long codigo;
    @NotBlank private String descricaoMaoDeObra;
    @NotNull @PositiveOrZero private Double valorHora;

    public MaoDeObraTO() {}

    public MaoDeObraTO(Long codigo, String descricaoMaoDeObra, Double valorHora) {
        this.codigo = codigo;
        this.descricaoMaoDeObra = descricaoMaoDeObra;
        this.valorHora = valorHora;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getDescricaoMaoDeObra() {
        return descricaoMaoDeObra;
    }

    public void setDescricaoMaoDeObra(@NotBlank String descricaoMaoDeObra) {
        this.descricaoMaoDeObra = descricaoMaoDeObra;
    }

    public @NotNull @PositiveOrZero Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(@NotNull @PositiveOrZero Double valorHora) {
        this.valorHora = valorHora;
    }
}
