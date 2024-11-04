package br.com.fiap.dao;

import br.com.fiap.to.OficinaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OficinaDAO extends Repository {
    public ArrayList<OficinaTO> findAll() {
        ArrayList<OficinaTO> oficinas = new ArrayList<OficinaTO>();
        String sql = "select * from aaa_oficinas order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    OficinaTO oficina = new OficinaTO();
                    oficina.setCodigo(rs.getLong("codigo"));
                    oficina.setNomeDaOficina(rs.getString("nome_da_oficina"));
                    oficina.setEnderecoDaOficina(rs.getString("endereco_da_oficina"));
                    oficinas.add(oficina);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return oficinas;
    }

    public OficinaTO findByCodigo(Long codigo) {
        OficinaTO oficina = new OficinaTO();
        String sql = "select * from aaa_oficinas where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                oficina.setCodigo(rs.getLong("codigo"));
                oficina.setNomeDaOficina(rs.getString("nome_da_oficina"));
                oficina.setEnderecoDaOficina(rs.getString("endereco_da_oficina"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return oficina;
    }

    public OficinaTO save(OficinaTO oficina) {
        String sql = "insert into aaa_oficinas (nome_da_oficina, endereco_da_oficina) values(?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, oficina.getNomeDaOficina());
            ps.setString(2, oficina.getEnderecoDaOficina());
            if (ps.executeUpdate() > 0) {
                return oficina;
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
        String sql = "delete from aaa_oficinas where codigo = ?";
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

    public OficinaTO update(OficinaTO oficina) {
        String sql = "update aaa_oficinas set nome_da_oficina=?, endereco_da_oficina where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, oficina.getNomeDaOficina());
            ps.setString(2, oficina.getEnderecoDaOficina());
            ps.setLong(3, oficina.getCodigo());
            if (ps.executeUpdate() > 0) {
                return oficina;
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
