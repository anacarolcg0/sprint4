package br.com.fiap.bo;

import br.com.fiap.dao.OficinaDAO;
import br.com.fiap.to.OficinaTO;

import java.util.ArrayList;

public class OficinaBO {
    private OficinaDAO oficinaDAO;

    public ArrayList<OficinaTO> findAll() {
        oficinaDAO = new OficinaDAO();
        // aqui se implementa a regra de negócios
        return oficinaDAO.findAll();
    }

    public OficinaTO findByCodigo(Long codigo) {
        oficinaDAO = new OficinaDAO();
        // aqui se implementa a regra de negócios
        return oficinaDAO.findByCodigo(codigo);
    }

    public OficinaTO save(OficinaTO oficina) {
        oficinaDAO = new OficinaDAO();
        // aqui se implementa a regra de negócios
        return oficinaDAO.save(oficina);
    }

    public boolean delete(Long codigo) {
        oficinaDAO = new OficinaDAO();
        // aqui se implementa a regra de negócios
        return oficinaDAO.delete(codigo);
    }

    public OficinaTO update(OficinaTO oficina) {
        oficinaDAO = new OficinaDAO();
        // aqui se implementa a regra de negócios
        return oficinaDAO.update(oficina);
    }
}
