package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class PecaTO {
    private Long codigo;
    @NotBlank private String nomeDaPeca;
    @NotNull @PositiveOrZero private Double valorUnitario;

    public PecaTO() {}

    public PecaTO(Long codigo, String nomeDaPeca, Double valorUnitario) {
        this.codigo = codigo;
        this.nomeDaPeca = nomeDaPeca;
        this.valorUnitario = valorUnitario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getNomeDaPeca() {
        return nomeDaPeca;
    }

    public void setNomeDaPeca(@NotBlank String nomeDaPeca) {
        this.nomeDaPeca = nomeDaPeca;
    }

    public @NotNull @PositiveOrZero Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(@NotNull @PositiveOrZero Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
