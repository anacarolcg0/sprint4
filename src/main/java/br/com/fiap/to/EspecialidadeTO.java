package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class EspecialidadeTO {
    private Long codigo;
    @NotBlank private String descricaoDaEspecialidade;

    public EspecialidadeTO() {}

    public EspecialidadeTO(Long codigo, String descricaoDaEspecialidade) {
        this.codigo = codigo;
        this.descricaoDaEspecialidade = descricaoDaEspecialidade;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getDescricaoDaEspecialidade() {
        return descricaoDaEspecialidade;
    }

    public void setDescricaoDaEspecialidade(@NotBlank String descricaoDaEspecialidade) {
        this.descricaoDaEspecialidade = descricaoDaEspecialidade;
    }
}
