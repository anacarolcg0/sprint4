package br.com.fiap.dao;

import br.com.fiap.to.EspecialidadeTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EspecialidadeDAO extends Repository {
    public ArrayList<EspecialidadeTO> findAll() {
        ArrayList<EspecialidadeTO> especialidades = new ArrayList<EspecialidadeTO>();
        String sql = "select * from aaa_especialidades order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    EspecialidadeTO especialidade = new EspecialidadeTO();
                    especialidade.setCodigo(rs.getLong("codigo"));
                    especialidade.setDescricaoDaEspecialidade(rs.getString("descricao_da_especialidade"));
                    especialidades.add(especialidade);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return especialidades;
    }

    public EspecialidadeTO findByCodigo(Long codigo) {
        EspecialidadeTO especialidade = new EspecialidadeTO();
        String sql = "select * from aaa_especialidades where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                especialidade.setCodigo(rs.getLong("codigo"));
                especialidade.setDescricaoDaEspecialidade(rs.getString("descricao_da_especialidade"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return especialidade;
    }

    public EspecialidadeTO save(EspecialidadeTO especialidade) {
        String sql = "insert into aaa_especialidades (descricao_da_especialidade) values(?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, especialidade.getDescricaoDaEspecialidade());
            if (ps.executeUpdate() > 0) {
                return especialidade;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long codigo) {
        String sql = "delete from aaa_especialidades where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public EspecialidadeTO update(EspecialidadeTO especialidade) {
        String sql = "update aaa_especialidades set descricao_da_especialidade=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, especialidade.getDescricaoDaEspecialidade());
            ps.setLong(2, especialidade.getCodigo());
            if (ps.executeUpdate() > 0) {
                return especialidade;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
