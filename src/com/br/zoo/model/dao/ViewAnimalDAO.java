package com.br.zoo.model.dao;

import com.br.zoo.infra.ConexaoMysqlZoo;
import com.br.zoo.model.entity.ViewAnimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ViewAnimalDAO {


    private ConexaoMysqlZoo conexao;
    private String query = "";

    public ViewAnimalDAO() throws SQLException, ClassNotFoundException {
        conexao = new ConexaoMysqlZoo();
    }


   public List<ViewAnimal> zooAll() throws SQLException {
        query = "select Tipo, idAnimal, idDono, nomeAnimal, dtNascto, dtCadastro, idadeAnimal, sexo from animal";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);

            ResultSet resultSet = stmt.executeQuery();

            List<ViewAnimal> zoo = new ArrayList<>();


            while (resultSet.next()) {
                ViewAnimal vw = new ViewAnimal (
                        resultSet.getString("Tipo"),
                        resultSet.getInt("idDono"),
                        resultSet.getString("nomeAnimal"),
                        resultSet.getString("dtNascto"),
                        resultSet.getString("dtCadastro"),
                        resultSet.getString("sexo").charAt(0));
                vw.setId_animal(resultSet.getInt("idAnimal"));


                zoo.add(vw);
            }
            return zoo;

        } catch (SQLException e) {
            throw e;
        }
    }

}
