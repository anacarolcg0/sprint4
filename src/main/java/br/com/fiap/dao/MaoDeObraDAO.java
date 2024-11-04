package br.com.fiap.dao;

import br.com.fiap.to.MaoDeObraTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaoDeObraDAO extends Repository {
    public ArrayList<MaoDeObraTO> findAll() {
        ArrayList<MaoDeObraTO> maosDeObra = new ArrayList<MaoDeObraTO>();
        String sql = "select * from aaa_maos_de_obra order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    MaoDeObraTO maoDeObra = new MaoDeObraTO();
                    maoDeObra.setCodigo(rs.getLong("codigo"));
                    maoDeObra.setDescricaoMaoDeObra(rs.getString("descricao_mao_de_obra"));
                    maoDeObra.setValorHora(rs.getDouble("valor_hora"));
                    maosDeObra.add(maoDeObra);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return maosDeObra;
    }

    public MaoDeObraTO findByCodigo(Long codigo) {
        MaoDeObraTO maoDeObra = new MaoDeObraTO();
        String sql = "select * from aaa_maos_de_obra where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maoDeObra.setCodigo(rs.getLong("codigo"));
                maoDeObra.setDescricaoMaoDeObra(rs.getString("descricao_mao_de_obra"));
                maoDeObra.setValorHora(rs.getDouble("valor_hora"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return maoDeObra;
    }

    public MaoDeObraTO save(MaoDeObraTO maoDeObra) {
        String sql = "insert into aaa_maos_de_obra (descricao_mao_de_obra, valor_hora) values(?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, maoDeObra.getDescricaoMaoDeObra());
            ps.setDouble(2, maoDeObra.getValorHora());
            if (ps.executeUpdate() > 0) {
                return maoDeObra;
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
        String sql = "delete from aaa_maos_de_obra where codigo = ?";
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

    public MaoDeObraTO update(MaoDeObraTO maoDeObra) {
        String sql = "update ddd_remedios set descricao_mao_de_obra=?, valor_hora=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, maoDeObra.getDescricaoMaoDeObra());
            ps.setDouble(2, maoDeObra.getValorHora());
            ps.setLong(3, maoDeObra.getCodigo());
            if (ps.executeUpdate() > 0) {
                return maoDeObra;
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
