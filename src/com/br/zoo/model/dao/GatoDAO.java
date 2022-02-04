package com.br.zoo.model.dao;

import com.br.zoo.infra.ConexaoMysqlZoo;

import com.br.zoo.model.entity.Gato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GatoDAO implements DaoGenerico<Gato> {

    private ConexaoMysqlZoo conexao;
    private String query = "";

    public GatoDAO() throws SQLException, ClassNotFoundException {
        conexao = new ConexaoMysqlZoo();
    }

    public void insert(Gato gato) throws SQLException {
        query = "insert into gato(id_dono_gato, nome_gato, dt_nascto_gato, dt_cadastro_gato, idade_gato, sexo_gato) values (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, gato.getId_dono_animal());
            stmt.setString(2, gato.getNome_animal());
            stmt.setString(3, gato.getDt_nascto_animal());
            stmt.setString(4, gato.getDt_cadastro_animal());
            stmt.setInt(5, gato.getIdade_animal());
            stmt.setString(6, String.valueOf(gato.getSexo()));

            stmt.execute();
            this.conexao.commit();

        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }


    @Override
    public List<Gato> findAll() throws SQLException {
        query = "select id_gato, id_dono_gato, nome_gato, dt_nascto_gato, dt_cadastro_gato, sexo_gato from gato";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            List<Gato> buscaGato = new ArrayList<>();


            while (resultSet.next()) {
                Gato g = new Gato (resultSet.getInt("id_dono_gato"),
                        resultSet.getString("nome_gato"),
                        resultSet.getString("dt_nascto_gato"),
                        resultSet.getString("dt_cadastro_gato"),
                        resultSet.getString("sexo_gato").charAt(0));
                g.setId_animal(resultSet.getInt("id_gato"));


                buscaGato.add(g);
            }
            return buscaGato;

        } catch (SQLException e) {
            throw e;
        }
    }

    public void delete(int id) throws SQLException{
        query = "DELETE from gato WHERE id_gato = ?";
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
    public void updateNomeAnimal(Gato cat) throws SQLException {
        query = "update gato set nome_gato = ? where id_gato = ?";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setString(1, cat.getNome_animal());
            stmt.setInt(2, cat.getId_animal());

            stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;

        }

    }

    @Override
    public void adicionaDono(Gato cat) throws SQLException {
        query = "update gato set id_dono_gato = ? where id_gato = ?";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, cat.getId_dono_animal());
            stmt.setInt(2, cat.getId_animal());

            stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;

        }

    }


    public Gato findById(int id) throws SQLException {
        query = "Select id_gato, id_dono_gato, nome_gato, dt_nascto_gato, dt_cadastro_gato, idade_gato, sexo_gato from gato where id_gato = ?";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1,id);

            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()){

                Gato cat = new Gato (resultSet.getInt("id_dono_gato"),
                        resultSet.getString("nome_gato"),
                        resultSet.getString("dt_nascto_gato"),
                        resultSet.getString("dt_cadastro_gato"),
                        resultSet.getString("sexo_gato").charAt(0));
                cat.setId_animal(resultSet.getInt("id_gato"));

                return cat;
            }
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;

        }
        return null;


    }

}
