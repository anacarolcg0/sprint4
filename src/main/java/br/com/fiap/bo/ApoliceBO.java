package br.com.fiap.bo;

import br.com.fiap.dao.ApoliceDAO;
import br.com.fiap.to.ApoliceTO;

import java.util.ArrayList;

public class ApoliceBO {
    private ApoliceDAO apoliceDAO;

    public ArrayList<ApoliceTO> findAll() {
        apoliceDAO = new ApoliceDAO();
        // aqui se implementa a regra de negócios
        return apoliceDAO.findAll();
    }

    public ApoliceTO findByCodigo(Long codigo) {
        apoliceDAO = new ApoliceDAO();
        // aqui se implementa a regra de negócios
        return apoliceDAO.findByCodigo(codigo);
    }

    public ApoliceTO save(ApoliceTO apolice) {
        apoliceDAO = new ApoliceDAO();
        // aqui se implementa a regra de negócios
        return apoliceDAO.save(apolice);
    }

    public boolean delete(Long codigo) {
        apoliceDAO = new ApoliceDAO();
        // aqui se implementa a regra de negócios
        return apoliceDAO.delete(codigo);
    }

    public ApoliceTO update(ApoliceTO apolice) {
        apoliceDAO = new ApoliceDAO();
        // aqui se implementa a regra de negócios
        return apoliceDAO.update(apolice);
    }
}
