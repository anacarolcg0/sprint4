package br.com.fiap.bo;

import br.com.fiap.dao.OrcamentoDAO;
import br.com.fiap.to.OrcamentoTO;

import java.util.ArrayList;

public class OrcamentoBO {
    private OrcamentoDAO orcamentoDAO;

    public ArrayList<OrcamentoTO> findAll() {
        orcamentoDAO = new OrcamentoDAO();
        // aqui se implementa a regra de negócios
        return orcamentoDAO.findAll();
    }

    public OrcamentoTO findByCodigo(Long codigo) {
        orcamentoDAO = new OrcamentoDAO();
        // aqui se implementa a regra de negócios
        return orcamentoDAO.findByCodigo(codigo);
    }

    public OrcamentoTO save(OrcamentoTO orcamento) {
        orcamentoDAO = new OrcamentoDAO();
        // aqui se implementa a regra de negócios
        return orcamentoDAO.save(orcamento);
    }

    public boolean delete(Long codigo) {
        orcamentoDAO = new OrcamentoDAO();
        // aqui se implementa a regra de negócios
        return orcamentoDAO.delete(codigo);
    }

    public OrcamentoTO update(OrcamentoTO orcamento) {
        orcamentoDAO = new OrcamentoDAO();
        // aqui se implementa a regra de negócios
        return orcamentoDAO.update(orcamento);
    }
}
