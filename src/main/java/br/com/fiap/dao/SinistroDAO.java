package br.com.fiap.dao;

import br.com.fiap.to.SinistroTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SinistroDAO extends Repository {
    public ArrayList<SinistroTO> findAll() {
        ArrayList<SinistroTO> sinistros = new ArrayList<SinistroTO>();
        String sql = "select * from aaa_sinistros order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    SinistroTO sinistro = new SinistroTO();
                    sinistro.setCodigo(rs.getLong("codigo"));
                    sinistro.setDescricaoDoSinistro(rs.getString("descricao_do_sinistro"));
                    sinistro.setValorDoSinistro(rs.getDouble("valor_do_sinistro"));
                    sinistro.setDataDoSinistro(rs.getDate("data_do_sinistro").toLocalDate());
                    sinistros.add(sinistro);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return sinistros;
    }

    public SinistroTO findByCodigo(Long codigo) {
        SinistroTO sinistro = new SinistroTO();
        String sql = "select * from aaa_sinistros where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sinistro.setCodigo(rs.getLong("codigo"));
                sinistro.setDescricaoDoSinistro(rs.getString("descricao_do_sinistro"));
                sinistro.setValorDoSinistro(rs.getDouble("valor_do_sinistro"));
                sinistro.setDataDoSinistro(rs.getDate("data_do_sinistro").toLocalDate());
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return sinistro;
    }

    public SinistroTO save(SinistroTO sinistro) {
        String sql = "insert into aaa_sinistros (descricao_do_sinistro, valor_do_sinistro, data_do_sinistro) values(?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, sinistro.getDescricaoDoSinistro());
            ps.setDouble(2, sinistro.getValorDoSinistro());
            ps.setDate(3, Date.valueOf(sinistro.getDataDoSinistro()));
            if (ps.executeUpdate() > 0) {
                return sinistro;
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
        String sql = "delete from aaa_sinistros where codigo = ?";
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

    public SinistroTO update(SinistroTO sinistro) {
        String sql = "update aaa_sinistros set descricao_do_sinistro=?, valor_do_sinistro=?, data_do_sinistro=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, sinistro.getDescricaoDoSinistro());
            ps.setDouble(2, sinistro.getValorDoSinistro());
            ps.setDate(3, Date.valueOf(sinistro.getDataDoSinistro()));
            ps.setLong(4, sinistro.getCodigo());
            if (ps.executeUpdate() > 0) {
                return sinistro;
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
