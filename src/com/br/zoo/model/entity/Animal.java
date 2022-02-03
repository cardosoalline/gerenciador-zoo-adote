package com.br.zoo.model.entity;


public class Animal {
    protected int id_animal;
    protected int id_dono_animal;
    protected String nome_animal;
    protected char sexo;
    protected String dt_nascto_animal;
    protected int idade_animal;
    protected String dt_cadastro_animal;

    public Animal(int id_dono_animal, String nome_animal, char sexo,
                  String dt_nascto_animal, String dt_cadastro_animal) {
        this.id_dono_animal = id_dono_animal;
        this.nome_animal = nome_animal;
        this.sexo = sexo;
        this.dt_nascto_animal = dt_nascto_animal;
        this.dt_cadastro_animal = dt_cadastro_animal;
        this.idade_animal = calculaIdade();
    }

    public Animal(String nome_animal, char sexo,
                  String dt_nascto_animal, String dt_cadastro_animal) {
        this.nome_animal = nome_animal;
        this.sexo = sexo;
        this.dt_nascto_animal = dt_nascto_animal;
        this.dt_cadastro_animal = dt_cadastro_animal;
        this.idade_animal = calculaIdade();
    }

    public Animal(String nome_animal) {
         this.nome_animal = nome_animal;
       }

    public Animal(int id_dono_animal) {
        this.id_dono_animal = id_dono_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public void setId_dono_animal(int id_dono_animal) {
        this.id_dono_animal = id_dono_animal;
    }

    public void setNome_animal(String nome_animal) {
        this.nome_animal = nome_animal;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setDt_nascto_animal(String dt_nascto_animal) {
        this.dt_nascto_animal = dt_nascto_animal;
    }


    public void setDt_cadastro_animal(String dt_cadastro_animal) {
        this.dt_cadastro_animal = dt_cadastro_animal;
    }

    public int getId_animal() {
        return id_animal;
    }

    public int getId_dono_animal() {
        return id_dono_animal;
    }

    public String getNome_animal() {
        return nome_animal;
    }

    public char getSexo() {
        return sexo;
    }

    public String getDt_nascto_animal() {
        return dt_nascto_animal;
    }

    public int getIdade_animal() {
        return idade_animal;
    }

    public String getDt_cadastro_animal() {
        return dt_cadastro_animal;
    }

    public int calculaIdade() {

        int anoCadastro = Integer.parseInt(this.dt_cadastro_animal.substring(6, 10));
        int diaNascimento = Integer.parseInt(this.dt_nascto_animal.substring(0, 2));
        int mesNascimento = Integer.parseInt(this.dt_nascto_animal.substring(3, 5));
        int anoNascimento = Integer.parseInt(this.dt_nascto_animal.substring(6, 10));

        int idade = anoCadastro - anoNascimento;

        if (Integer.parseInt(this.dt_cadastro_animal.substring(3, 5)) < mesNascimento ||
                Integer.parseInt(this.dt_cadastro_animal.substring(0, 2)) < diaNascimento) {
            idade--;
            return idade;
        }
        return idade;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "id_animal=" + id_animal +
                ", id_dono_animal=" + id_dono_animal +
                ", nome_animal='" + nome_animal + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dt_nascto_animal=" + dt_nascto_animal +
                ", idade_animal=" + idade_animal +
                ", dt_cadastro_animal=" + dt_cadastro_animal +
                '}';
    }
}
