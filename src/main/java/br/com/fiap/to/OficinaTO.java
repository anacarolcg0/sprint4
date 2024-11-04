package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class OficinaTO {
    private Long codigo;
    @NotBlank private String nomeDaOficina;
    @NotBlank private String enderecoDaOficina;

    public OficinaTO() {}

    public OficinaTO(Long codigo, String nomeDaOficina, String enderecoDaOficina) {
        this.codigo = codigo;
        this.nomeDaOficina = nomeDaOficina;
        this.enderecoDaOficina = enderecoDaOficina;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getNomeDaOficina() {
        return nomeDaOficina;
    }

    public void setNomeDaOficina(@NotBlank String nomeDaOficina) {
        this.nomeDaOficina = nomeDaOficina;
    }

    public @NotBlank String getEnderecoDaOficina() {
        return enderecoDaOficina;
    }

    public void setEnderecoDaOficina(@NotBlank String enderecoDaOficina) {
        this.enderecoDaOficina = enderecoDaOficina;
    }
}
