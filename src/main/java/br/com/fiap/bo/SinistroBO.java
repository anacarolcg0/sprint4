package br.com.fiap.bo;

import br.com.fiap.dao.SinistroDAO;
import br.com.fiap.to.SinistroTO;

import java.util.ArrayList;

public class SinistroBO {
    private SinistroDAO sinistroDAO;

    public ArrayList<SinistroTO> findAll() {
        sinistroDAO = new SinistroDAO();
        // aqui se implementa a regra de negócios
        return sinistroDAO.findAll();
    }

    public SinistroTO findByCodigo(Long codigo) {
        sinistroDAO = new SinistroDAO();
        // aqui se implementa a regra de negócios
        return sinistroDAO.findByCodigo(codigo);
    }

    public SinistroTO save(SinistroTO sinistro) {
        sinistroDAO = new SinistroDAO();
        // aqui se implementa a regra de negócios
        return sinistroDAO.save(sinistro);
    }

    public boolean delete(Long codigo) {
        sinistroDAO = new SinistroDAO();
        // aqui se implementa a regra de negócios
        return sinistroDAO.delete(codigo);
    }

    public SinistroTO update(SinistroTO sinistro) {
        sinistroDAO = new SinistroDAO();
        // aqui se implementa a regra de negócios
        return sinistroDAO.update(sinistro);
    }
}
