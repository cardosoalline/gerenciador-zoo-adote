package com.br.zoo.model.entity;

public class Girafa extends Animal {
    public Girafa(int id_dono_animal, String nome_animal,
                  String dt_nascto_animal, String dt_cadastro_animal, char sexo) {
        super(id_dono_animal, nome_animal,sexo, dt_nascto_animal, dt_cadastro_animal);
    }

    public Girafa(String nome_animal,String dt_nascto_animal, String dt_cadastro_animal,  char sexo) {
        super (nome_animal,sexo, dt_nascto_animal, dt_cadastro_animal);

    }
    public Girafa (String nome_animal){
        super(nome_animal);
    }
    public Girafa (int id_dono_animal){ super(id_dono_animal);}

    @Override
    public String toString() {
        return "Informações da GIRAFA cadastrada: \n" +
                "Id_girafa: " + id_animal +
                "\nId_dono_girafa: " + id_dono_animal +
                "\nNome_girafa: " + nome_animal +
                "\nSexo: " + sexo +
                "\nData_nascimento_girafa: " + dt_nascto_animal +
                "\nIdade_girafa: " + idade_animal + " ano(s)" +
                "\nData_cadastro_girafa: " + dt_cadastro_animal + "\n";

    }
}


