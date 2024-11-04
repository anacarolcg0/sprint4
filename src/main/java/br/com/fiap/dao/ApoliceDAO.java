package br.com.fiap.dao;

import br.com.fiap.to.ApoliceTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApoliceDAO extends Repository {
    public ArrayList<ApoliceTO> findAll() {
        ArrayList<ApoliceTO> apolices = new ArrayList<ApoliceTO>();
        String sql = "select * from aaa_apolices order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ApoliceTO apolice = new ApoliceTO();
                    apolice.setCodigo(rs.getLong("codigo"));
                    apolice.setTipoDeCobertura(rs.getString("tipo_de_cobertura"));
                    apolice.setValorSegurado(rs.getDouble("valor_segurado"));
                    apolice.setDataEmissao(rs.getDate("data_emissao").toLocalDate());
                    apolices.add(apolice);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return apolices;
    }

    public ApoliceTO findByCodigo(Long codigo) {
        ApoliceTO apolice = new ApoliceTO();
        String sql = "select * from aaa_apolices where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                apolice.setCodigo(rs.getLong("codigo"));
                apolice.setTipoDeCobertura(rs.getString("tipo_de_cobertura"));
                apolice.setValorSegurado(rs.getDouble("valor_segurado"));
                apolice.setDataEmissao(rs.getDate("data_emissao").toLocalDate());
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return apolice;
    }

    public ApoliceTO save(ApoliceTO apolice) {
        String sql = "insert into aaa_apolices (tipo_de_cobertura, valor_segurado, data_emissao) values(?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, apolice.getTipoDeCobertura());
            ps.setDouble(2, apolice.getValorSegurado());
            ps.setDate(3, Date.valueOf(apolice.getDataEmissao()));
            if (ps.executeUpdate() > 0) {
                return apolice;
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
        String sql = "delete from aaa_apolices where codigo = ?";
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

    public ApoliceTO update(ApoliceTO apolice) {
        String sql = "update aaa_apolices set tipo_de_cobertura=?, valor_segurado=?, data_emissao=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, apolice.getTipoDeCobertura());
            ps.setDouble(2, apolice.getValorSegurado());
            ps.setDate(3, Date.valueOf(apolice.getDataEmissao()));
            ps.setLong(4, apolice.getCodigo());
            if (ps.executeUpdate() > 0) {
                return apolice;
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
