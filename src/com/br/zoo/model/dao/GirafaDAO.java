package com.br.zoo.model.dao;

import com.br.zoo.infra.ConexaoMysqlZoo;
import com.br.zoo.model.entity.Girafa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GirafaDAO implements DaoGenerico<Girafa> {


    private ConexaoMysqlZoo conexao;
    private String query = "";

    public GirafaDAO() throws SQLException, ClassNotFoundException {
        conexao = new ConexaoMysqlZoo();
    }

    public void insert(Girafa gi) throws SQLException {
        query = "insert into girafa(id_dono_girafa, nome_girafa, dt_nascto_girafa, dt_cadastro_girafa, idade_girafa, sexo_girafa) values (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, gi.getId_dono_animal());
            stmt.setString(2, gi.getNome_animal());
            stmt.setString(3, gi.getDt_nascto_animal());
            stmt.setString(4, gi.getDt_cadastro_animal());
            stmt.setInt(5, gi.getIdade_animal());
            stmt.setString(6, String.valueOf(gi.getSexo()));

            stmt.execute();
            this.conexao.commit();

        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }


    @Override
    public List<Girafa> findAll() throws SQLException {
        query = "select id_girafa, id_dono_girafa, nome_girafa, dt_nascto_girafa, dt_cadastro_girafa, sexo_girafa from girafa";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            List<Girafa> buscaGirafa = new ArrayList<>();

            while (resultSet.next()) {
                Girafa gi = new Girafa (resultSet.getInt("id_dono_girafa"),
                        resultSet.getString("nome_girafa"),
                        resultSet.getString("dt_nascto_girafa"),
                        resultSet.getString("dt_cadastro_girafa"),
                        resultSet.getString("sexo_girafa").charAt(0));
                gi.setId_animal(resultSet.getInt("id_girafa"));


                buscaGirafa.add(gi);
            }
            return buscaGirafa;

        } catch (SQLException e) {
            throw e;
        }
    }

    public void delete(int id) throws SQLException{
        query = "DELETE from girafa WHERE id_girafa = ?";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

    @Override
    public void updateNomeAnimal(Girafa girafa) throws SQLException {
        query = "update girafa set nome_girafa = ? where id_girafa = ?";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setString(1, girafa.getNome_animal());
            stmt.setInt(2, girafa.getId_animal());


            stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;

        }

    }


    @Override
    public void adicionaDono(Girafa girafa) throws SQLException {
        query = "update girafa set id_dono_girafa = ? where id_girafa = ?";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, girafa.getId_dono_animal());
            stmt.setInt(2, girafa.getId_animal());


            stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;

        }

    }


    public Girafa findById(int id) throws SQLException {
        query = "Select id_girafa, id_dono_girafa, nome_girafa, dt_nascto_girafa, dt_cadastro_girafa, idade_girafa, sexo_girafa from girafa where id_girafa = ?";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1,id);

            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()){

                Girafa gi = new Girafa (resultSet.getInt("id_dono_girafa"),
                        resultSet.getString("nome_girafa"),
                        resultSet.getString("dt_nascto_girafa"),
                        resultSet.getString("dt_cadastro_girafa"),
                        resultSet.getString("sexo_girafa").charAt(0));
                gi.setId_animal(resultSet.getInt("id_girafa"));

                return gi;
            }
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;

        }
        return null;


    }

}
