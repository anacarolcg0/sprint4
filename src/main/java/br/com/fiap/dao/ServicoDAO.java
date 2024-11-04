package br.com.fiap.dao;

import br.com.fiap.to.ServicoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoDAO extends Repository {
    public ArrayList<ServicoTO> findAll() {
        ArrayList<ServicoTO> servicos = new ArrayList<ServicoTO>();
        String sql = "select * from aaa_servicos order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ServicoTO servico = new ServicoTO();
                    servico.setCodigo(rs.getLong("codigo"));
                    servico.setDescricaoDoServico(rs.getString("descricao_do_servico"));
                    servico.setValorDoServico(rs.getDouble("valor_do_servico"));
                    servicos.add(servico);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return servicos;
    }

    public ServicoTO findByCodigo(Long codigo) {
        ServicoTO servico = new ServicoTO();
        String sql = "select * from aaa_servicos where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                servico.setCodigo(rs.getLong("codigo"));
                servico.setDescricaoDoServico(rs.getString("descricao_do_servico"));
                servico.setValorDoServico(rs.getDouble("valor_do_servico"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return servico;
    }

    public ServicoTO save(ServicoTO servico) {
        String sql = "insert into aaa_servicos (descricao_do_servico, valor_do_servico) values(?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, servico.getDescricaoDoServico());
            ps.setDouble(2, servico.getValorDoServico());
            if (ps.executeUpdate() > 0) {
                return servico;
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
        String sql = "delete from aaa_servicos where codigo = ?";
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

    public ServicoTO update(ServicoTO servico) {
        String sql = "update aaa_servicos set descricao_do_servico=?, valor_do_servico=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, servico.getDescricaoDoServico());
            ps.setDouble(2, servico.getValorDoServico());
            ps.setLong(3, servico.getCodigo());
            if (ps.executeUpdate() > 0) {
                return servico;
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
