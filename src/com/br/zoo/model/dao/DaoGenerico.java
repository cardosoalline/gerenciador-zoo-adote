package com.br.zoo.model.dao;

import com.br.zoo.infra.ConexaoMysqlZoo;

import java.sql.SQLException;
import java.util.List;

public interface DaoGenerico<T> {

        ConexaoMysqlZoo conexao = null;

        void insert(T t) throws SQLException;
        List<T> findAll() throws SQLException;
        void delete(int id) throws SQLException;
        void updateNomeAnimal(T t) throws SQLException;
        void adicionaDono(T t) throws SQLException;
        T findById(int id) throws SQLException;

        }




