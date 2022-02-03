package com.br.zoo.model.entity;

import java.util.Date;

public class Gato extends Animal{
    public Gato(int id_dono_animal, String nome_animal,
            String dt_nascto_animal, String dt_cadastro_animal, char sexo){
        super (id_dono_animal, nome_animal, sexo, dt_nascto_animal, dt_cadastro_animal);
    }

    public Gato(String nome_animal,String dt_nascto_animal, String dt_cadastro_animal,  char sexo) {
        super (nome_animal,sexo, dt_nascto_animal, dt_cadastro_animal);

    }

    public Gato (String nome_animal){
        super(nome_animal);
    }
    public Gato (int id_dono_animal){ super(id_dono_animal);}


    @Override
    public String toString() {
       return  "Informações do GATO cadastrado: \n" +
               "Id_gato: " + id_animal +
                "\nId_dono_gato: " + id_dono_animal +
                "\nNome_gato: " + nome_animal +
               "\nSexo: " + sexo +
               "\nData_nascimento_gato: " + dt_nascto_animal +
                "\nIdade_gato: " + idade_animal + " ano(s)" +
                "\nData_cadastro_gato: " + dt_cadastro_animal + "\n";

    }
}
