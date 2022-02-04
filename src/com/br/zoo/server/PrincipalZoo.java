package com.br.zoo.server;

import com.br.zoo.model.dao.*;
import com.br.zoo.model.entity.Cachorro;
import com.br.zoo.model.entity.Dono;
import com.br.zoo.model.entity.Gato;
import com.br.zoo.model.entity.Girafa;


import java.sql.SQLException;
import java.util.Scanner;

public class PrincipalZoo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);

        //testes CACHORRO
        //Cachorro c = new Cachorro("mais um", "12-09-2015", "18-09-2021",'F');
     // System.out.println(c);
       // Cachorro c2 = new Cachorro( 1,"galego", "12-09-2010", "18-09-2021",'F');
       //c2.setId_dono_animal(scan.nextInt());
         // System.out.println(c2);

      /*  //findAll CACHORRO
      CachorroDAO consulta = new CachorroDAO();
        System.out.println(consulta.findAll());*/

        //insert CACHORRO sem limite de quantidade
       /* CachorroDAO DAO = new CachorroDAO();
        DAO.insert(c);
        DAO.insert(c2);
*/
        //delete CACHORRO
      /* System.out.println("Qual cadastro deseja deletar?");
        DAO.delete(scan.nextInt());*/


        //update CACHORRO
      /* Cachorro caltera = new Cachorro("So nome ALTERADO de novo");
       caltera.setId_animal(4);

        CachorroDAO alterado = new CachorroDAO();
        alterado.updateNomeAnimal(caltera);
        System.out.println(caltera);*/

       /* Cachorro cinclui = new Cachorro(3);
        cinclui.setId_animal(18);

        CachorroDAO alterado = new CachorroDAO();
        alterado.adicionaDono(cinclui);

        //consulta por id
       CachorroDAO consulta = new CachorroDAO();
        System.out.println("Qual cadastro deseja consultar?");

        System.out.print(consulta.findById(scan.nextInt()));*/



        //testes GATO
        Gato g = new Gato( "Bela", "02-10-2019", "18-11-2020",'M');
        Gato g1 = new Gato(2, "Fera", "23-01-2011", "18-11-2020",'F');
        Gato g2 = new Gato(1, "Lili", "06-06-2016", "18-11-2020",'F');
        //System.out.println(g);

       // findAll GATO
       /* GatoDAO consulta = new GatoDAO();
        System.out.println(consulta.findAll());

        //insert GATO sem limite de quantidade
        GatoDAO DAO = new GatoDAO();
        DAO.insert(g);
        DAO.insert(g1);
        DAO.insert(g2);

        //delete GATO
       System.out.println("Qual cadastro deseja deletar?");
       DAO.delete(scan.nextInt());



        //update GATO
        Gato galtera = new Gato("testando so nome");
        galtera.setId_animal(1);

        GatoDAO alterado = new GatoDAO();
        alterado.updateNomeAnimal(galtera);


        //adiciona dono
       Gato cinclui = new Gato(3);
        cinclui.setId_animal(15);

        GatoDAO alterado = new GatoDAO();
        alterado.adicionaDono(cinclui);*/

       // consulta por id
      /*  GatoDAO consulta = new GatoDAO();
        System.out.println("Qual cadastro deseja consultar?");
        System.out.print(consulta.findById(scan.nextInt()));
*/
      //testes GIRAFA
        Girafa gi = new Girafa("Gigica", "10-10-2010", "05-09-2021",'M');
        Girafa gi1 = new Girafa(2, "Pintada", "02-08-2018", "03-03-2020",'F');
        Girafa gi2 = new Girafa(3, "Altona", "03-10-2015", "09-12-2020",'M');
        //System.out.println(gi);


        // findAll GIRAFA
        /*GirafaDAO consulta = new GirafaDAO();
        System.out.println(consulta.findAll());

        //insert GIRAFA sem limite de quantidade
        GirafaDAO DAO = new GirafaDAO();
        DAO.insert(gi);
        DAO.insert(gi1);
        DAO.insert(gi2);

        //delete GIRAFA
       GirafaDAO DAO = new GirafaDAO();

        System.out.println("Qual cadastro deseja deletar?");
        DAO.delete(scan.nextInt());
*/

        //update GIRAFA nome
     /*   Girafa gialtera = new Girafa("mudei nome");
        gialtera.setId_animal(1);

        GirafaDAO alterado = new GirafaDAO();
        alterado.updateNomeAnimal(gialtera);

        //adiciona dono
         Girafa cinclui = new Girafa(3);
        cinclui.setId_animal(6);

        GirafaDAO alterado = new GirafaDAO();
        alterado.adicionaDono(cinclui);*/

        //consulta por id
      /* GirafaDAO consulta = new GirafaDAO();
        System.out.println("Qual cadastro deseja consultar?");
        System.out.print(consulta.findById(scan.nextInt()));

*/

       //testes DONO
        Dono d = new Dono("Alicio", true, true, true);
        Dono d1 = new Dono("Alice", false, false, true);
        Dono d2 = new Dono("Ana", true, false, true);
        //System.out.println(d);


        // findAll DONO
   /*     DonoDAO consulta = new DonoDAO();
        System.out.println(consulta.findAll());*/

        //insert DONO sem limite de quantidade
       /* DonoDAO DAO = new DonoDAO();
        DAO.insert(d);
        DAO.insert(d1);
        DAO.insert(d2);*/

         //delete DONO
      /*  DonoDAO DAO = new DonoDAO();
      System.out.println("Qual cadastro deseja deletar?");
        DAO.delete(scan.nextInt());
*/

        //update DONO
        Dono daltera = new Dono("Alterado Camila", true, true,true);
        daltera.setId_dono(3);

        DonoDAO alterado = new DonoDAO();
        alterado.updateById(daltera);

        DonoDAO consulta = new DonoDAO();
        System.out.println(consulta.findAll());

        //consulta por id
       DonoDAO DAO = new DonoDAO();
        System.out.println("Qual dono deseja consultar?");
        System.out.print(DAO.findById(scan.nextInt()));



        //Busca com toda a lista de animais cadastrados juntamento com seu dono resultado query view
        System.out.println("Animais Cadastrados no zoo\n");
        ViewAnimalDAO cadastro = new ViewAnimalDAO();
        System.out.println(cadastro.zooAll());

        scan.close();
    }

}
