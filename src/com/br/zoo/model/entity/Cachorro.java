package com.br.zoo.model.entity;

import java.util.Date;

public class Cachorro extends Animal {

    public Cachorro(int id_dono_animal, String nome_animal,
                String dt_nascto_animal, String dt_cadastro_animal, char sexo){
        super (id_dono_animal, nome_animal,sexo, dt_nascto_animal, dt_cadastro_animal);
    }

    public Cachorro (String nome_animal){
        super(nome_animal);
    }
    public Cachorro (int id_dono_animal){ super(id_dono_animal);}

    public Cachorro(String nome_animal,String dt_nascto_animal, String dt_cadastro_animal,  char sexo) {
        super (nome_animal,sexo, dt_nascto_animal, dt_cadastro_animal);

    }


    @Override
    public String toString() {
        return  "Informações do CACHORRO cadastrado: \n" +
                "Id_cachorro: " + id_animal +
                "\nId_dono_cachorro: " + id_dono_animal +
                "\nNome_cahorro: " + nome_animal +
                "\nSexo: " + sexo +
                "\nData_nascimento_cachorro: " + dt_nascto_animal +
                "\nIdade_cachorro: " + idade_animal + " ano(s)" +
                "\nData_cadastro_cahorro: " + dt_cadastro_animal + "\n";

    }
}


