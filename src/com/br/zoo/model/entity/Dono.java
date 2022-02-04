package com.br.zoo.model.entity;

public class Dono {
    private int id_dono;
    private String nome_dono;
    private boolean dono_cachorro;
    private boolean dono_gato;
    private boolean dono_girafa;

    public Dono(String nome_dono, boolean dono_cachorro, boolean dono_gato, boolean dono_girafa){
        this.nome_dono = nome_dono;
        this.dono_cachorro = dono_cachorro;
        this.dono_gato = dono_gato;
        this.dono_girafa = dono_girafa;
    }

    public Dono(String nome_dono){
        this.nome_dono = nome_dono;

    }


    public void setId_dono(int id_dono) { this.id_dono = id_dono; }

    public void setNome_dono(String nome_dono) {
        this.nome_dono = nome_dono;
    }

    public void setDono_cachorro(boolean dono_cachorro) {
        this.dono_cachorro = dono_cachorro;
    }

    public void setDono_gato(boolean dono_gato) {
        this.dono_gato = dono_gato;
    }

    public void setDono_girafa(boolean dono_girafa) {
        this.dono_girafa = dono_girafa;
    }

    public int getId_dono() { return id_dono;}

    public String getNome_dono() {
        return nome_dono;
    }

    public boolean isDono_cachorro() {
        return dono_cachorro;
    }

    public boolean isDono_gato() {
        return dono_gato;
    }

    public boolean isDono_girafa() {
        return dono_girafa;
    }

    @Override
    public String toString() {
        return  "Informações do DONO cadastrado: \n" +
                "Id_dono: " + id_dono +
                "\nNome_dono: " + nome_dono +
                "\nDono_de_cachorro: " + dono_cachorro +
                "\nDono_de_gato: " + dono_gato +
                "\nDono_de_girafa: " + dono_girafa + "\n" ;
    }
}