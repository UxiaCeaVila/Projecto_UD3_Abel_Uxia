DROP DATABASE IF exists COSMERE;
CREATE DATABASE COSMERE;

USE COSMERE;

CREATE table PLANETAS(
	id int not null primary key auto_increment,
	nombre varchar(50) not null,
    sistema varchar(40) not null,
    esquirla varchar(30) null
)engine = InnoDB;
CREATE table Sagas(
	id int not null primary key auto_increment,
	nombre varchar(50) not null,
    longitud varchar(2) not null,
    planeta int not null,
    foreign key (planeta) references Planetas(id)
					on delete restrict
                    on update cascade
)engine = InnoDB;
CREATE table Especies(
	id int not null primary key auto_increment,
	nombre varchar(50) not null,
    planeta_origen int not null,
    fisiologia int not null,
    foreign key (planeta_origen) references Planetas(id)
					on delete restrict
                    on update cascade
)engine = InnoDB;
CREATE table Personajes(
	id int not null primary key auto_increment,
	nombre varchar(50) not null,
    edad varchar(5) null,
    especie int not null,
    planeta_origen int not null,
    foreign key (planeta_origen) references Planetas(id)
					on delete restrict
                    on update cascade,
    foreign key (especie) references Especies(id)
					on delete restrict
                    on update cascade
	
)engine = InnoDB;

CREATE table Libros(
	id int not null primary key auto_increment,
	nombre varchar(50) not null,
    planeta int not null,
    saga int not null,
    foreign key (planeta) references Planetas(id)
					on delete restrict
                    on update cascade,
    foreign key (saga) references Sagas(id)
				on delete restrict
                on update cascade
)engine = InnoDB;


create table Magias(
	id int not null primary key auto_increment,
	nombre varchar(30) not null,
    descripcion text not null,
    esquirla varchar(30)
)engine = InnoDB;

create table personajes_sagas(
	id int not null primary key auto_increment,
    personaje int not null,
	saga int not null,
    tipo_personaje varchar(50) not null,
    foreign key (personaje) references Personajes(id)
					on delete restrict
                    on update cascade,
                    
    foreign key (saga) references Sagas(id)
					on delete restrict
                    on update cascade
    
)engine = InnoDB;
create table personajes_magias(
	id int not null primary key auto_increment,
    personaje int not null,
    magia int not null,
    poder_magico enum('Maestro','Bueno','Aprendiz'),
    
    foreign key (personaje) references Personajes(id)
					on delete restrict
                    on update cascade,
                    
    foreign key (magia) references Magias(id)
					on delete restrict
                    on update cascade
)engine = InnoDB;

INSERT INTO PLANETAS VALUES(1,'Roshar','Sistema de Roshar','Esquirla Honor');
INSERT INTO PLANETAS VALUES(2,'Nalthis','Sistema de Nalthis','Esquirla Nalthis');
INSERT INTO PLANETAS VALUES(3,'Scadrial','Sistema de Scadrial','Esquirla Conservación');
INSERT INTO PLANETAS VALUES(4,'Sel','Sistema de Sel','Esquirla Devoción');
INSERT INTO PLANETAS VALUES(5,'Yomen','Sistema de Yomen','Adonalsium');
INSERT INTO PLANETAS VALUES(6,'Taldain','Sistema de Taldain','Esquirla Autonomía');
INSERT INTO PLANETAS VALUES(7,'Donne','Sistema de Sel','Esquirla Devoción');
INSERT INTO PLANETAS VALUES(8,'Aaqual Nod','Sistema de Scadrial','Esquirla Conservación');
INSERT INTO PLANETAS VALUES(9,'Braize','Sistema de Roshar','Esquirla Odium');

INSERT INTO Sagas VALUES(1,'El Archivo de las Tormentas',4,1);
INSERT INTO Sagas VALUES(2,'El Aliento de los Dioses',1,2);
INSERT INTO Sagas VALUES(3,'Nacidos de la bruma',7,3);
INSERT INTO Sagas VALUES(4,'Elantris',3,4);

INSERT INTO Especies VALUES(1,'Humanos',5,1);
INSERT INTO Especies VALUES(2,'Humanos-Scadrial',3,2);
INSERT INTO Especies VALUES(3,'Chull',1,3);
INSERT INTO Especies VALUES(4,'Rocabrote',1,4);

INSERT INTO Personajes VALUES(1,'Dalinar Kholin',54,1,1);
INSERT INTO Personajes VALUES(2,'Kaladin',20,1,1);
INSERT INTO Personajes VALUES(3,'Shallan Davar',18,1,1);
INSERT INTO Personajes VALUES(4,'Vivenna',28,1,2);
INSERT INTO Personajes VALUES(5,'Vasher',558,1,2);
INSERT INTO Personajes VALUES(6,'Vin',20,2,3);
INSERT INTO Personajes VALUES(7,'Kelsier',36,2,3);
INSERT INTO Personajes VALUES(8,'Sazed',34,2,3);
INSERT INTO Personajes VALUES(9,'Raoden',26,1,4);
INSERT INTO Personajes VALUES(10,'Hoid',9999,1,5);

INSERT INTO Libros VALUES(1,'El Camino de los Reyes',1,1);
INSERT INTO Libros VALUES(2,'Palabras Radiantes',1,1);
INSERT INTO Libros VALUES(3,'Juramentada',1,1);
INSERT INTO Libros VALUES(4,'El Aliento de los Dioses',2,2);
INSERT INTO Libros VALUES(5,'El Imperio Final',3,3);
INSERT INTO Libros VALUES(6,'El Pozo de la Ascensión',3,3);
INSERT INTO Libros VALUES(7,'El Héroe de las Eras',3,3);
INSERT INTO Libros VALUES(8,'Elantris',4,4);
INSERT INTO Libros VALUES(9,'El alma del emperador',4,4);

INSERT INTO Magias VALUES(1,'Vinculo de Nahel','Permite vincularse a un Spren','Esquirla Honor');
INSERT INTO Magias VALUES(2,'Alomancia','Permite quemar metales','Esquirla Conservación');
INSERT INTO Magias VALUES(3,'Feruquimia','Permite almacenar en metales','Esquirla Ruina');
INSERT INTO Magias VALUES(4,'Despertar','Permite despertar objetos inanimados','Esquirla Dotación');

INSERT INTO personajes_sagas VALUES(1,5,1,'Retornado');
INSERT INTO personajes_sagas VALUES(2,10,2,'Saltamundos');
INSERT INTO personajes_sagas VALUES(3,7,3,'Sombra');

INSERT INTO personajes_magias VALUES(1,5,4,'Maestro');
INSERT INTO personajes_magias VALUES(2,10,1,'Aprendiz');
INSERT INTO personajes_magias VALUES(3,7,2,'Bueno');