package com.br.zoo.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMysqlZoo {

    private Connection connection = null;

    private static final String USERNAME = "root";

    private static final String PASSWORD = "root";

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/zoo?useTimezone=true&serverTimezone=UTC";

    public ConexaoMysqlZoo() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        this.connection.setAutoCommit(false);
    }

    public Connection getConnection(){
        return this.connection;
    }

    public void close(){
        if(this.connection != null){
            try{
                this.connection.close();
            }catch (SQLException e){
                Logger.getLogger(ConexaoMysqlZoo.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public void commit() throws SQLException {
        this.connection.commit();

    }

    public void rollback(){
        if(this.connection != null){

            try{
                this.connection.rollback();
            }catch (SQLException e){
                Logger.getLogger(ConexaoMysqlZoo.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }


}
