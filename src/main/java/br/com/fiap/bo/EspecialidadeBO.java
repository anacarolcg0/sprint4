package br.com.fiap.bo;

import br.com.fiap.dao.EspecialidadeDAO;
import br.com.fiap.to.EspecialidadeTO;

import java.util.ArrayList;

public class EspecialidadeBO {
    private EspecialidadeDAO especialidadeDAO;

    public ArrayList<EspecialidadeTO> findAll() {
        especialidadeDAO = new EspecialidadeDAO();
        // aqui se implementa a regra de negócios
        return especialidadeDAO.findAll();
    }

    public EspecialidadeTO findByCodigo(Long codigo) {
        especialidadeDAO = new EspecialidadeDAO();
        // aqui se implementa a regra de negócios
        return especialidadeDAO.findByCodigo(codigo);
    }

    public EspecialidadeTO save(EspecialidadeTO especialidade) {
        especialidadeDAO = new EspecialidadeDAO();
        // aqui se implementa a regra de negócios
        return especialidadeDAO.save(especialidade);
    }

    public boolean delete(Long codigo) {
        especialidadeDAO = new EspecialidadeDAO();
        // aqui se implementa a regra de negócios
        return especialidadeDAO.delete(codigo);
    }

    public EspecialidadeTO update(EspecialidadeTO especialidade) {
        especialidadeDAO = new EspecialidadeDAO();
        // aqui se implementa a regra de negócios
        return especialidadeDAO.update(especialidade);
    }
}
