package br.com.fiap.bo;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.to.VeiculoTO;

import java.util.ArrayList;

public class VeiculoBO {
    private VeiculoDAO veiculoDAO;

    public ArrayList<VeiculoTO> findAll() {
        veiculoDAO = new VeiculoDAO();
        // aqui se implementa a regra de negócios
        return veiculoDAO.findAll();
    }

    public VeiculoTO findByCodigo(Long codigo) {
        veiculoDAO = new VeiculoDAO();
        // aqui se implementa a regra de negócios
        return veiculoDAO.findByCodigo(codigo);
    }

    public VeiculoTO save(VeiculoTO veiculo) {
        veiculoDAO = new VeiculoDAO();
        // aqui se implementa a regra de negócios
        return veiculoDAO.save(veiculo);
    }

    public boolean delete(Long codigo) {
        veiculoDAO = new VeiculoDAO();
        // aqui se implementa a regra de negócios
        return veiculoDAO.delete(codigo);
    }

    public VeiculoTO update(VeiculoTO veiculo) {
        veiculoDAO = new VeiculoDAO();
        // aqui se implementa a regra de negócios
        return veiculoDAO.update(veiculo);
    }
}
