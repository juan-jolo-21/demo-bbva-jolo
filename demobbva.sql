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


-- creación de trigger

DELIMITER $$
CREATE TRIGGER gen_id 
BEFORE INSERT
ON solicitud_tarjeta FOR EACH ROW
BEGIN
	DECLARE contador int;
    DECLARE lastid varchar(6);
    DECLARE numberslastid int;
    SELECT cod_solicitud INTO lastid FROM solicitud_tarjeta ORDER BY cod_solicitud DESC LIMIT 1;
    IF lastid IS NULL THEN
		SET NEW.cod_solicitud = 'STC001';
	ELSE
		SET numberslastid = CAST(SUBSTRING(lastid, 4) AS UNSIGNED);
        SET contador = numberslastid + 1;
        IF(contador<10)THEN
            SET new.cod_solicitud= CONCAT('STC00',contador);
            ELSE IF(contador<100) THEN
                SET new.cod_solicitud= CONCAT('STC0',contador);
                ELSE IF(contador<1000)THEN
                    SET new.cod_solicitud= CONCAT('STC',contador);
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

