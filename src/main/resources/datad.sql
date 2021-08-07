DROP TABLE IF EXISTS personne;

create table personne (id bigint not null, 
						demission date, 
						matricule varchar(255), 
						nom varchar(255), 
						prenom varchar(255), 
						recrutement date, 
						salaire double, 
						titre varchar(255), 
						primary key (id))

insert into personne (nom,prenom,matricule,titre,salaire,recrutement,demission) values('adile','adile','MP7854','Responsible human resources',10000.00,null,null);


	
