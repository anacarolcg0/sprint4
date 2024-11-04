package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ServicoTO {
    private Long codigo;
    @NotBlank private String descricaoDoServico;
    @NotNull @PositiveOrZero private Double valorDoServico;

    public ServicoTO() {}

    public ServicoTO(Long codigo, String descricaoDoServico, Double valorDoServico) {
        this.codigo = codigo;
        this.descricaoDoServico = descricaoDoServico;
        this.valorDoServico = valorDoServico;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getDescricaoDoServico() {
        return descricaoDoServico;
    }

    public void setDescricaoDoServico(@NotBlank String descricaoDoServico) {
        this.descricaoDoServico = descricaoDoServico;
    }

    public @NotNull @PositiveOrZero Double getValorDoServico() {
        return valorDoServico;
    }

    public void setValorDoServico(@NotNull @PositiveOrZero Double valorDoServico) {
        this.valorDoServico = valorDoServico;
    }
}
