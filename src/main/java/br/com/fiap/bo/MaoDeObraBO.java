package br.com.fiap.bo;

import br.com.fiap.dao.MaoDeObraDAO;
import br.com.fiap.to.MaoDeObraTO;

import java.util.ArrayList;

public class MaoDeObraBO {
    private MaoDeObraDAO maoDeObraDAO;

    public ArrayList<MaoDeObraTO> findAll() {
        maoDeObraDAO = new MaoDeObraDAO();
        // aqui se implementa a regra de negócios
        return maoDeObraDAO.findAll();
    }

    public MaoDeObraTO findByCodigo(Long codigo) {
        maoDeObraDAO = new MaoDeObraDAO();
        // aqui se implementa a regra de negócios
        return maoDeObraDAO.findByCodigo(codigo);
    }

    public MaoDeObraTO save(MaoDeObraTO maoDeObra) {
        maoDeObraDAO = new MaoDeObraDAO();
        // aqui se implementa a regra de negócios
        return maoDeObraDAO.save(maoDeObra);
    }

    public boolean delete(Long codigo) {
        maoDeObraDAO = new MaoDeObraDAO();
        // aqui se implementa a regra de negócios
        return maoDeObraDAO.delete(codigo);
    }

    public MaoDeObraTO update(MaoDeObraTO maoDeObra) {
        maoDeObraDAO = new MaoDeObraDAO();
        // aqui se implementa a regra de negócios
        return maoDeObraDAO.update(maoDeObra);
    }
}
