package br.com.fiap.to;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class OrcamentoTO {
    private Long codigo;
    @Min(1) private Integer quantidadeDePeca;
    @NotNull @PositiveOrZero private Double valorDoOrcamento;
    @Min(1) private Integer horasTrabalhadas;

    public OrcamentoTO() {}

    public OrcamentoTO(Long codigo, Integer quantidadeDePeca, Double valorDoOrcamento, Integer horasTrabalhadas) {
        this.codigo = codigo;
        this.quantidadeDePeca = quantidadeDePeca;
        this.valorDoOrcamento = valorDoOrcamento;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @Min(1) Integer getQuantidadeDePeca() {
        return quantidadeDePeca;
    }

    public void setQuantidadeDePeca(@Min(1) Integer quantidadeDePeca) {
        this.quantidadeDePeca = quantidadeDePeca;
    }

    public @NotNull @PositiveOrZero Double getValorDoOrcamento() {
        return valorDoOrcamento;
    }

    public void setValorDoOrcamento(@NotNull @PositiveOrZero Double valorDoOrcamento) {
        this.valorDoOrcamento = valorDoOrcamento;
    }

    public @Min(1) Integer getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(@Min(1) Integer horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
}
