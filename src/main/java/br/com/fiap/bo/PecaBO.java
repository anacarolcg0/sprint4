package br.com.fiap.bo;

import br.com.fiap.dao.PecaDAO;
import br.com.fiap.to.PecaTO;

import java.util.ArrayList;

public class PecaBO {
    private PecaDAO pecaDAO;

    public ArrayList<PecaTO> findAll() {
        pecaDAO = new PecaDAO();
        // aqui se implementa a regra de negócios
        return pecaDAO.findAll();
    }

    public PecaTO findByCodigo(Long codigo) {
        pecaDAO = new PecaDAO();
        // aqui se implementa a regra de negócios
        return pecaDAO.findByCodigo(codigo);
    }

    public PecaTO save(PecaTO peca) {
        pecaDAO = new PecaDAO();
        // aqui se implementa a regra de negócios
        return pecaDAO.save(peca);
    }

    public boolean delete(Long codigo) {
        pecaDAO = new PecaDAO();
        // aqui se implementa a regra de negócios
        return pecaDAO.delete(codigo);
    }

    public PecaTO update(PecaTO peca) {
        pecaDAO = new PecaDAO();
        // aqui se implementa a regra de negócios
        return pecaDAO.update(peca);
    }
}
