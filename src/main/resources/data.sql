DROP TABLE IF EXISTS moneda;
DROP TABLE IF EXISTS tipo_cambio;

CREATE TABLE moneda (
     idmoneda INT AUTO_INCREMENT  PRIMARY KEY,
     code VARCHAR(250) NOT NULL,
     name VARCHAR(250) NOT NULL
);
CREATE TABLE tipo_cambio (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    idmoneda INT NOT NULL,
    value VARCHAR(250) NOT NULL,
    foreign key (idmoneda) references moneda(idmoneda)
);

INSERT INTO moneda (code, name) VALUES ( 'PE','SOL');
INSERT INTO moneda (code, name) VALUES ( 'EU','DOLAR');

INSERT INTO tipo_cambio (idmoneda, value) VALUES ( 1,3.8);
INSERT INTO tipo_cambio (idmoneda, value) VALUES ( 2,1);