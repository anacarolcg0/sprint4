package br.com.fiap.bo;

import br.com.fiap.dao.ServicoDAO;
import br.com.fiap.to.ServicoTO;

import java.util.ArrayList;

public class ServicoBO {
    private ServicoDAO servicoDAO;

    public ArrayList<ServicoTO> findAll() {
        servicoDAO = new ServicoDAO();
        // aqui se implementa a regra de negócios
        return servicoDAO.findAll();
    }

    public ServicoTO findByCodigo(Long codigo) {
        servicoDAO = new ServicoDAO();
        // aqui se implementa a regra de negócios
        return servicoDAO.findByCodigo(codigo);
    }

    public ServicoTO save(ServicoTO servico) {
        servicoDAO = new ServicoDAO();
        // aqui se implementa a regra de negócios
        return servicoDAO.save(servico);
    }

    public boolean delete(Long codigo) {
        servicoDAO = new ServicoDAO();
        // aqui se implementa a regra de negócios
        return servicoDAO.delete(codigo);
    }

    public ServicoTO update(ServicoTO servico) {
        servicoDAO = new ServicoDAO();
        // aqui se implementa a regra de negócios
        return servicoDAO.update(servico);
    }
}
