package com.br.zoo.model.dao;

import com.br.zoo.infra.ConexaoMysqlZoo;
import com.br.zoo.model.entity.Dono;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonoDAO {

        private ConexaoMysqlZoo conexao;
        private String query = "";

    public DonoDAO() throws SQLException, ClassNotFoundException {
            conexao = new ConexaoMysqlZoo();
        }

        public void insert(Dono dono) throws SQLException {
            query = "insert into dono(nome_dono, dono_de_cachorro, dono_de_gato, dono_de_girafa) values (?, ?, ?, ?);";

            try {
                PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
                stmt.setString(1, dono.getNome_dono());
                stmt.setBoolean(2, dono.isDono_cachorro());
                stmt.setBoolean(3, dono.isDono_gato());
                stmt.setBoolean(4, dono.isDono_girafa());

                stmt.execute();
                this.conexao.commit();

            } catch (SQLException e) {
                this.conexao.rollback();
                throw e;
            }
        }


        public List<Dono> findAll() throws SQLException {
            query = "select id_dono, nome_dono, dono_de_cachorro, dono_de_gato, dono_de_girafa from dono";

            try {
                PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
                ResultSet resultSet = stmt.executeQuery();

                List<Dono> buscaDono = new ArrayList<>();
                while (resultSet.next()) {
                    Dono d = new Dono (resultSet.getString("nome_dono"),
                            resultSet.getBoolean("dono_de_cachorro"),
                            resultSet.getBoolean("dono_de_gato"),
                            resultSet.getBoolean("dono_de_girafa"));
                    d.setId_dono(resultSet.getInt("id_dono"));

                    buscaDono.add(d);
                }
                return buscaDono;

            } catch (SQLException e) {
                throw e;
            }
        }


         public void delete(int id) throws SQLException{
            query = "DELETE from dono WHERE id_dono = ?";
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


        public void updateById(Dono dono) throws SQLException {
            query = "update dono set nome_dono = ?, dono_de_cachorro = ?, dono_de_gato = ?, dono_de_girafa = ? where id_dono = ?";

            try {
                PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
                stmt.setString(1, dono.getNome_dono());
                stmt.setBoolean(2, dono.isDono_cachorro());
                stmt.setBoolean(3, dono.isDono_gato());
                stmt.setBoolean(4, dono.isDono_girafa());
                stmt.setInt(5, dono.getId_dono());

                stmt.executeUpdate();
                this.conexao.commit();
            } catch (SQLException e) {
                this.conexao.rollback();
                throw e;

            }

        }

    public void updatenomedono(Dono dono) throws SQLException {
        query = "update dono set nome_dono = ? where id_dono = ?";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setString(1, dono.getNome_dono());


            stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;

        }

    }

    public Dono findById(int id) throws SQLException {
            query = "Select id_dono, nome_dono, dono_de_cachorro, dono_de_gato, dono_de_girafa from dono where id_dono = ?";

            try {
                PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
                stmt.setInt(1,id);

                ResultSet resultSet = stmt.executeQuery();

                if(resultSet.next()){

                    Dono dono = new Dono (resultSet.getString("nome_dono"),
                            resultSet.getBoolean("dono_de_cachorro"),
                            resultSet.getBoolean("dono_de_gato"),
                            resultSet.getBoolean("dono_de_girafa"));
                    dono.setId_dono(resultSet.getInt("id_dono"));

                    return dono;
                }
            } catch (SQLException e) {
                this.conexao.rollback();
                throw e;

            }
            return null;


        }
}
