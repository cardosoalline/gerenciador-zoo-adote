create schema zoo;

use zoo;

-- CRIAÇÃO TABELAS ESPÉCIES UM PARA UM --
create table cachorro(
    id_cachorro int not null auto_increment primary key,
    id_dono_cachorro int not null,
    nome_cachorro varchar(60) not null,
    dt_nascto_cachorro date not null,
    dt_cadastro_chachorro date not null);
desc cachorro;

-- inlcuindo coluna idade --
alter table cachorro add column idade_cachorro int;
alter table cachorro add column sexo_cachorro int;


-- modificando tipo date para varchar e int para char--
alter table cachorro modify dt_nascto_cachorro varchar(15);
alter table cachorro modify dt_cadastro_chachorro varchar(15);
alter table cachorro modify sexo_cachorro char(1);



-- corrigindo nome da coluna --
alter table cachorro change dt_cadastro_chachorro dt_cadastro_cachorro varchar(15);



create table gato(
    id_gato int not null auto_increment primary key,
    id_dono_gato int not null,
    nome_gato varchar(60) not null,
    dt_nascto_gato date not null,
    dt_cadastro_gato date not null);
  
-- inlcuindo coluna idade --
alter table gato add column idade_gato int;
alter table gato add column sexo_gato int;


-- modificando tipo date para varchar e int para char--
alter table gato modify dt_nascto_gato varchar(15);
alter table gato modify dt_cadastro_gato varchar(15);
alter table gato modify sexo_gato char(1);



   
   
create table girafa(
    id_girafa int not null auto_increment primary key,
    id_dono_girafa int not null,
    nome_girafa varchar(60) not null,
    dt_nascto_girafa date not null,
    dt_cadastro_girafa date not null);

  
-- inlcuindo coluna idade --
alter table girafa add column idade_girafa int;
alter table girafa add column sexo_girafa int;

-- modificando tipo date para varchar e int para char--
alter table girafa modify dt_nascto_girafa varchar(15);
alter table girafa modify dt_cadastro_girafa varchar(15);
alter table girafa modify sexo_girafa char(1);





 
-- CRIAÇÃO DE TABELA DONO - UM PARA MUITOS ---   
   
create table dono(
    id_dono int not null auto_increment primary key,
    nome_dono varchar(60) not null,
    dono_de_cachorro boolean,
    dono_de_gato boolean,
    dono_de_girafa boolean);
   
   desc dono;

   
-- CRIANDO FK --
   
alter table cachorro add constraint fk_cachorro_dono foreign key(id_dono_cachorro) references dono(id_dono);
alter table gato add constraint fk_gato_dono foreign key(id_dono_gato) references dono(id_dono);
alter table girafa add constraint fk_girafa_dono foreign key(id_dono_girafa) references dono(id_dono);

   -- drop  FK --

alter table cachorro drop foreign key fk_cachorro_dono;
alter table gato drop foreign key fk_gato_dono;
alter table girafa drop foreign key fk_girafa_dono;

desc cachorro;




-- DONO --

insert into dono (nome_dono, dono_de_cachorro , dono_de_gato , dono_de_girafa) 
                      values ('Gabriela', true, false, false);

insert into dono (nome_dono, dono_de_cachorro , dono_de_gato , dono_de_girafa) 
                      values ('João', false, true, false);
                   
insert into dono (nome_dono, dono_de_cachorro , dono_de_gato , dono_de_girafa) 
                      values ('Camila', false, false, true);

select * from dono;



-- CACHORRO -

insert into cachorro (id_dono_cachorro, nome_cachorro, dt_nascto_cachorro, dt_cadastro_cachorro, idade_cachorro, sexo_cachorro) 
                      values (1,'Xau', '12-09-2021', '19-10-2022', 2, 'M');

select * from cachorro;

select * from cachorro where id_cachorro = 7;


update cachorro set id_dono_cachorro = 2 where id_cachorro = 3;


 -- GATO --

insert into gato (id_dono_gato, nome_gato, dt_nascto_gato , dt_cadastro_gato, idade_gato , sexo_gato) 
                      values (2,'Miau', '05-09-2021', '05-09-2022', 1, 'F');

select * from gato;


-- GIRAFA --

insert into girafa (id_dono_girafa, nome_girafa, dt_nascto_girafa, dt_cadastro_girafa, idade_girafa, sexo_girafa) 
                      values (3,'Gigifa', '08-08-2021', '19-05-2022', 0, 'M');

select * from girafa;

select * from dono;

alter  view Animal as
select 
'Girafa' Tipo,
id_girafa idAnimal , id_dono_girafa idDono  , nome_girafa nomeAnimal,  dt_nascto_girafa dtNascto ,
dt_cadastro_girafa dtCadastro,
idade_girafa idadeAnimal, sexo_girafa sexo 
from girafa
union all
select 'Cachorro', id_cachorro idAnimal , id_dono_cachorro idDono  , nome_cachorro nomeAnimal,  dt_nascto_cachorro dtNascto ,
dt_cadastro_cachorro dtCadastro,
idade_cachorro idadeAnimal, sexo_cachorro sexo  
from cachorro
union all
select 'Gato', id_gato idAnimal , id_dono_gato idDono  , nome_gato nomeAnimal,  dt_nascto_gato dtNascto ,
dt_cadastro_gato dtCadastro,
idade_gato idadeAnimal, sexo_gato sexo  
from gato; 

select * from animal;







   
