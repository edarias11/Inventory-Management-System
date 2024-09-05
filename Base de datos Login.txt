create database login;

create table Usuarios(
id int auto_increment primary key not null,
ingresoUsuario nvarchar(50),
ingresoPassword nvarchar(50)

);

create table usuariosxroles(
id_rol int auto_increment primary key,
id_usuario varchar(50),
rol varchar(50)
);
 
create table Choferes (
id int auto_increment primary key,
Nombre nvarchar(50),
Licencia int(50),
Contacto int(50)
 
 
);
 
create table Cliente (
id int auto_increment primary key,
Nombre nvarchar(50),
Empresa varchar(20),
Contacto int,
correo varchar(50)
);

CREATE TABLE inventario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR (500),
    precio DECIMAL(10, 2) NOT NULL,
    cantidad INT NOT NULL,
    fecha_ingreso DATE NOT NULL
);



CREATE TABLE maquinaria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50),
	tipo VARCHAR(50),
    descripcion varchar(500),
    anno varchar(20)
);

CREATE TABLE Pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto VARCHAR(100),
    cantidad INT,
    nombre_cliente VARCHAR(100),
    direccion_entrega VARCHAR(255),
    tiempo_entrega INT,
    fecha_pedido DATE,
    estado VARCHAR(50)
);
insert into Pedidos(producto, cantidad, nombre_cliente, direccion_entrega, tiempo_entrega , fecha_pedido , estado) values("papas","50","Luis","San Ramon","80",'2024-04-07',"En progreso");
INSERT INTO maquinaria (marca, tipo, descripcion, anno) VALUES
('John Deere', 'Tractor', 'Tractor modelo 5200, motor diesel, tracción 4x4.', '2015'),
('Case IH', 'Cosechadora', 'Cosechadora modelo Axial-Flow 6140, capacidad de 5.0-6.5 acres/hora.', '2018'),
('New Holland', 'Sembradora', 'Sembradora neumática modelo Great Plains 2SF30, capacidad de 30 pies.', '2019'),
('Kubota', 'Tractor', 'Tractor compacto modelo B2320, motor diesel de 23HP.', '2017'),
('Massey Ferguson', 'Arado', 'Arado de discos modelo MF 580, ancho de labor de 2.5 metros.', '2016'),
('Toyota', 'Carro', 'Toyota Hilux, pickup color blanco, capacidad de carga de 1 tonelada.', '2017'),
('Ford', 'Camión', 'Ford F-350, camión de carga color rojo, capacidad de carga de 3 toneladas.', '2018'),
('Chevrolet', 'Carro', 'Chevrolet Tracker, SUV color azul, 5 asientos, año 2019.', '2019'),
('Mercedes-Benz', 'Camión', 'Mercedes-Benz Actros 1845, camión de carga color blanco, capacidad de carga de 25 toneladas.', '2019');

INSERT INTO inventario (nombre, descripcion, precio, cantidad, fecha_ingreso)
VALUES 
    ('Manzana', 'Manzanas rojas frescas y jugosas', 1.50, 200, '2024-04-07'),
    ('Naranja', 'Naranjas dulces y maduras', 1.20, 250, '2024-04-07'),
    ('Plátano', 'Plátanos maduros y listos para comer', 0.80, 300, '2024-04-07'),
    ('Sandía', 'Sandías grandes y refrescantes', 3.00, 100, '2024-04-07'),
    ('Pera', 'Peras jugosas y dulces', 1.80, 150, '2024-04-07'),
    ('Uva', 'Uvas frescas y deliciosas', 2.20, 180, '2024-04-07'),
    ('Cebolla', 'Cebollas blancas y crujientes', 1.10, 220, '2024-04-07'),
    ('Ajo', 'Ajos frescos y aromáticos', 0.90, 400, '2024-04-07');

 
 
 
select * from Choferes;
 
insert into Choferes(Nombre,Licencia,Contacto) values ("Jose Solis", "2040587", "88951325");
insert into usuarios(ingresoUsuario,ingresoPassword) values("admin", "contra2022");
insert into usuarios(ingresoUsuario,ingresoPassword) values("vendedor", "contra2022vendedor");
insert into usuarios(ingresoUsuario,ingresoPassword) values("kendall", "123");
insert into usuariosxroles(id_usuario,rol) values("1", "admin");
insert into usuariosxroles(id_usuario,rol) values("1", "vendedor");
insert into usuariosxroles(id_usuario,rol) values("1", "cliente");
insert into usuariosxroles(id_usuario,rol) values("2", "vendedor");
insert into usuariosxroles(id_usuario,rol) values("2", "cliente");
insert into usuariosxroles(id_usuario,rol) values("3", "cliente");

select * from usuarios;

select * from Usuarios where Usuarios.ingresoUsuario = "admin" and Usuarios.ingresoPassword="contra2022";