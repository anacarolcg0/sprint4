package br.com.fiap.dao;

import br.com.fiap.to.OrcamentoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrcamentoDAO extends Repository {
    public ArrayList<OrcamentoTO> findAll() {
        ArrayList<OrcamentoTO> orcamentos = new ArrayList<OrcamentoTO>();
        String sql = "select * from aaa_orcamentos order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    OrcamentoTO orcamento = new OrcamentoTO();
                    orcamento.setCodigo(rs.getLong("codigo"));
                    orcamento.setQuantidadeDePeca(rs.getInt("quantidade_de_peca"));
                    orcamento.setValorDoOrcamento(rs.getDouble("valor_do_orcamento"));
                    orcamento.setHorasTrabalhadas(rs.getInt("horas_trabalhadas"));
                    orcamentos.add(orcamento);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return orcamentos;
    }

    public OrcamentoTO findByCodigo(Long codigo) {
        OrcamentoTO orcamento = new OrcamentoTO();
        String sql = "select * from aaa_orcamentos where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                orcamento.setCodigo(rs.getLong("codigo"));
                orcamento.setQuantidadeDePeca(rs.getInt("quantidade_de_peca"));
                orcamento.setValorDoOrcamento(rs.getDouble("valor_do_orcamento"));
                orcamento.setHorasTrabalhadas(rs.getInt("horas_trabalhadas"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return orcamento;
    }

    public OrcamentoTO save(OrcamentoTO orcamento) {
        String sql = "insert into aaa_orcamentos (quantidade_de_peca, valor_do_orcamento, horas_trabalhadas) values(?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, orcamento.getQuantidadeDePeca());
            ps.setDouble(2, orcamento.getValorDoOrcamento());
            ps.setInt(3, orcamento.getHorasTrabalhadas());
            if (ps.executeUpdate() > 0) {
                return orcamento;
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
        String sql = "delete from aaa_orcamentos where codigo = ?";
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

    public OrcamentoTO update(OrcamentoTO orcamento) {
        String sql = "update aaa_orcamentos set quantidade_de_peca=?, valor_do_orcamento=?, horas_trabalhadas=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, orcamento.getQuantidadeDePeca());
            ps.setDouble(2, orcamento.getValorDoOrcamento());
            ps.setInt(3, orcamento.getHorasTrabalhadas());
            ps.setLong(4, orcamento.getCodigo());
            if (ps.executeUpdate() > 0) {
                return orcamento;
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
