package com.br.zoo.model.dao;

import com.br.zoo.infra.ConexaoMysqlZoo;
import com.br.zoo.model.entity.Cachorro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CachorroDAO implements DaoGenerico<Cachorro> {

    private ConexaoMysqlZoo conexao;
    private String query = "";

    public CachorroDAO() throws SQLException, ClassNotFoundException {
        conexao = new ConexaoMysqlZoo();
    }

    public void insert(Cachorro cachorro) throws SQLException {
        query = "insert into cachorro(id_dono_cachorro, nome_cachorro, dt_nascto_cachorro, dt_cadastro_cachorro, idade_cachorro, sexo_cachorro) values (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, cachorro.getId_dono_animal());
            stmt.setString(2, cachorro.getNome_animal());
            stmt.setString(3, cachorro.getDt_nascto_animal());
            stmt.setString(4, cachorro.getDt_cadastro_animal());
            stmt.setInt(5, cachorro.getIdade_animal());
            stmt.setString(6, String.valueOf(cachorro.getSexo()));

            stmt.execute();
            this.conexao.commit();

        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }


    @Override
    public List<Cachorro> findAll() throws SQLException {
        query = "select id_cachorro, id_dono_cachorro, nome_cachorro, dt_nascto_cachorro, dt_cadastro_cachorro, sexo_cachorro from cachorro";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            List<Cachorro> buscaCao = new ArrayList<>();

            while (resultSet.next()) {
                Cachorro c = new Cachorro (resultSet.getInt("id_dono_cachorro"),
                                           resultSet.getString("nome_cachorro"),
                                           resultSet.getString("dt_nascto_cachorro"),
                                           resultSet.getString("dt_cadastro_cachorro"),
                                           resultSet.getString("sexo_cachorro").charAt(0));
                c.setId_animal(resultSet.getInt("id_cachorro"));

                buscaCao.add(c);
            }
            return buscaCao;

        } catch (SQLException e) {
            throw e;
        }
    }

    public void delete(int id) throws SQLException{
        query = "DELETE from cachorro WHERE id_cachorro = ?";
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
    public void updateNomeAnimal(Cachorro cachorro) throws SQLException {
        query = "update cachorro set nome_cachorro = ? where id_cachorro = ?";


            try {
                PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);

                stmt.setString(1, cachorro.getNome_animal());
                stmt.setInt(2, cachorro.getId_animal());

                stmt.executeUpdate();
                this.conexao.commit();
            } catch (SQLException e) {
                this.conexao.rollback();
                throw e;

            }

        }

    @Override
    public void adicionaDono(Cachorro cachorro) throws SQLException {
        query = "update cachorro set id_dono_cachorro = ? where id_cachorro = ?";


        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);

            stmt.setInt(1, cachorro.getId_dono_animal());
            stmt.setInt(2, cachorro.getId_animal());

            stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;

        }

    }



    public Cachorro findById(int id) throws SQLException {
        query = "Select id_cachorro, id_dono_cachorro, nome_cachorro, dt_nascto_cachorro, dt_cadastro_cachorro, idade_cachorro, sexo_cachorro from cachorro where id_cachorro = ?";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1,id);

            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()){

                Cachorro c = new Cachorro (resultSet.getInt("id_dono_cachorro"),
                        resultSet.getString("nome_cachorro"),
                        resultSet.getString("dt_nascto_cachorro"),
                        resultSet.getString("dt_cadastro_cachorro"),
                        resultSet.getString("sexo_cachorro").charAt(0));
                c.setId_animal(resultSet.getInt("id_cachorro"));

                return c;
            }
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;

        }
        return null;


    }

}
