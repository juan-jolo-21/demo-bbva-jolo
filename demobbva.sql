create schema demo_bbva;
use demo_bbva;
create table solicitud_tarjeta  (
	cod_solicitud char(9) not null primary key,
	tit_nombres varchar(30) not null,
    tit_app varchar(30) not null,
    tit_apm varchar(30) not null,
    tit_dni int(8) not null,
    producto varchar(15) not null,
    linea_aprobada int(6) not null,
    status_crediticio varchar(20) not null,
    status_solicitud varchar(20) not null
);


drop trigger gen_id;

-- creación de trigger

DELIMITER $$
CREATE TRIGGER gen_id 
BEFORE INSERT
ON application FOR EACH ROW
BEGIN
	DECLARE counter int;
    DECLARE lastid varchar(6);
    DECLARE numberslastid int;
    SELECT id INTO lastid FROM application ORDER BY id DESC LIMIT 1;
    IF lastid IS NULL THEN
		SET NEW.id = 'ACC001';
	ELSE
		SET numberslastid = CAST(SUBSTRING(lastid, 4) AS UNSIGNED);
        SET counter = numberslastid + 1;
        IF(counter<10)THEN
            SET new.id= CONCAT('ACC00',counter);
            ELSE IF(counter<100) THEN
                SET new.id= CONCAT('ACC0',counter);
                ELSE IF(counter<1000)THEN
                    SET new.id= CONCAT('ACC',counter);
                END IF;
            END IF;
        END IF;
    END IF;
END;$$

-- datos de prueba

insert into solicitud_tarjeta (
	tit_nombres,
    tit_app ,
    tit_apm ,
    tit_dni ,
    producto ,
    linea_aprobada ,
    status_crediticio ,
    status_solicitud )  
values (
	'juan lorenzo',
    'gutierrez',
    'jorgechagua',
    72030200,
    'platinum',
    4000,
    'normal' ,
    'aprobado'
);

insert into solicitud_tarjeta (
	tit_nombres,
    tit_app ,
    tit_apm ,
    tit_dni ,
    producto ,
    linea_aprobada ,
    status_crediticio ,
    status_solicitud )  
values (
	'slavko sergio',
    'dadic',
    'guanilo',
    66998811,
    'platinum',
    4000,
    'normal' ,
    'aprobado'
);

--  creacion de usuario para manejar base de datos
show grants for 'jolo'@'localhost';
create user 'jolo'@'localhost' identified by 'demo';
grant all privileges on * . * to 'jolo'@'localhost';
flush privileges;

rename table solicitud_tarjeta to application_card;

alter table application_card rename column cod_solicitud to id;
alter table application_card rename column tit_nombres to person_name;

rename table application_card to a_card;


create table person (
	dni int(8) not null primary key,
	name_person varchar(30) not null,
    last_name_person varchar(40) not null
);

insert into person value (
	44112200,
	"John",
	"Doe");

create table application (
	id char(9) not null primary key,
	person_dni int(8) not null,
    product_name varchar(15) not null,
    approved_credit_limit int(6) not null,
    credit_state varchar(20) not null,
    application_state varchar(20) not null,
    
    CONSTRAINT fk_person FOREIGN KEY (person_dni) REFERENCES person(dni)
);

insert into application (
	person_dni,
    product_name,
    approved_credit_limit,
    credit_state,
    application_state
)values(
	44112200,
    "platinum",
    5000,
    "regular",
    "approved"
);

alter table person drop column name;
alter table person drop column last_name;

alter table application drop constraint fk_person;

alter table application modify person_dni varchar(8) not null;
alter table person modify dni varchar(8) not null;
alter table application add constraint fk_person FOREIGN KEY (person_dni) REFERENCES person(dni) ON DELETE CASCADE;