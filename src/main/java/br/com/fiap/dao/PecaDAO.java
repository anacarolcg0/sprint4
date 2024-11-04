package br.com.fiap.dao;

import br.com.fiap.to.PecaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecaDAO extends Repository {
    public ArrayList<PecaTO> findAll() {
        ArrayList<PecaTO> pecas = new ArrayList<PecaTO>();
        String sql = "select * from aaa_pecas order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PecaTO peca = new PecaTO();
                    peca.setCodigo(rs.getLong("codigo"));
                    peca.setNomeDaPeca(rs.getString("nome_da_peca"));
                    peca.setValorUnitario(rs.getDouble("valor_unitario"));
                    pecas.add(peca);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pecas;
    }

    public PecaTO findByCodigo(Long codigo) {
        PecaTO peca = new PecaTO();
        String sql = "select * from aaa_pecas where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                peca.setCodigo(rs.getLong("codigo"));
                peca.setNomeDaPeca(rs.getString("nome_da_peca"));
                peca.setValorUnitario(rs.getDouble("valor_unitario"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return peca;
    }

    public PecaTO save(PecaTO peca) {
        String sql = "insert into aaa_pecas (nome_da_peca, valor_unitario) values(?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, peca.getNomeDaPeca());
            ps.setDouble(2, peca.getValorUnitario());
            if (ps.executeUpdate() > 0) {
                return peca;
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
        String sql = "delete from aaa_pecas where codigo = ?";
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

    public PecaTO update(PecaTO peca) {
        String sql = "update ddd_remedios set nome_da_peca=?, valor_unitario=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, peca.getNomeDaPeca());
            ps.setDouble(2, peca.getValorUnitario());
            ps.setLong(3, peca.getCodigo());
            if (ps.executeUpdate() > 0) {
                return peca;
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
