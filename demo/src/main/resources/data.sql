DROP TABLE IF EXISTS tb_heroes;  
CREATE TABLE tb_heroes (  
Id LONG AUTO_INCREMENT  PRIMARY KEY,      
nombre  VARCHAR(40) NOT NULL,
poderes VARCHAR(200) NOT NULL 
);

INSERT INTO tb_heroes(nombre,poderes) values 
('SUPERMAN','Rayos X, Volar, Hombre de Acero,fuerza'),
('WONDERWOMAN','lazo de la verdad, fuerza'),
('SPIDERMAN','Trepar los muros, super telaraña, fuerza'),
('AQUAMAN','Puede respirar bajo el agua, fuerza')
