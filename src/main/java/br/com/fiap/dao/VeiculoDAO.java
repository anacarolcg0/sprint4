package br.com.fiap.dao;

import br.com.fiap.to.VeiculoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO extends Repository {


    public ArrayList<VeiculoTO> findAll() {
        ArrayList<VeiculoTO> veiculos = new ArrayList<VeiculoTO>();
        String sql = "select * from aaa_veiculos order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    VeiculoTO veiculo = new VeiculoTO();
                    veiculo.setCodigo(rs.getLong("codigo"));
                    veiculo.setPlaca(rs.getString("placa"));
                    veiculo.setModelo(rs.getString("modelo"));
                    veiculo.setCor(rs.getString("cor"));
                    veiculo.setDataDeFabricacao(rs.getDate("data_de_fabricacao").toLocalDate());
                    veiculos.add(veiculo);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculos;
    }

    public VeiculoTO findByCodigo(Long codigo) {
        VeiculoTO veiculo = new VeiculoTO();
        String sql = "select * from aaa_veiculos where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                veiculo.setCodigo(rs.getLong("codigo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setDataDeFabricacao(rs.getDate("data_de_fabricacao").toLocalDate());
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculo;
    }

    public VeiculoTO save(VeiculoTO veiculo) {
        String sql = "insert into aaa_veiculos (placa, modelo, cor, data_de_fabricacao) values(?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getModelo());
            ps.setString(3, veiculo.getCor());
            ps.setDate(4, Date.valueOf(veiculo.getDataDeFabricacao()));
            if (ps.executeUpdate() > 0) {
                return veiculo;
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
        String sql = "delete from aaa_veiculos where codigo = ?";
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

    public VeiculoTO update(VeiculoTO veiculo) {
        String sql = "update aaa_veiculos set placa=?, modelo=?, cor=?, data_de_fabricacao=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getModelo());
            ps.setString(3, veiculo.getCor());
            ps.setDate(4, Date.valueOf(veiculo.getDataDeFabricacao()));
            ps.setLong(5, veiculo.getCodigo());
            if (ps.executeUpdate() > 0) {
                return veiculo;
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
