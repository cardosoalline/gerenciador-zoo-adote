package com.br.zoo.model.entity;

import com.br.zoo.model.entity.Animal;

public class ViewAnimal extends Animal {
    private final String tipo;

    public ViewAnimal(String tipo, int id_dono_animal, String nome_animal,
                      String dt_nascto_animal, String dt_cadastro_animal, char sexo) {
        super(id_dono_animal, nome_animal, sexo, dt_nascto_animal, dt_cadastro_animal);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\n" +
                "Tipo: " + tipo +
                "\nId animal: " + id_animal +
                "\nId dono: " + id_dono_animal +
                "\nNome animal: " + nome_animal +
                "\nData nascto: " + dt_nascto_animal +
                "\nData Cadastro: " + dt_cadastro_animal + " ano(s)" +
                "\nIdade: " + idade_animal +
                "\nSexo: " + sexo + "\n";


    }
}




