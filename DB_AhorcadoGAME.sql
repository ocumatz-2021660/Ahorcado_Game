drop database if exists DB_AhorcadoGAME;
create database DB_AhorcadoGAME;
use DB_AhorcadoGAME;

create table usuarios(
IDusuario int auto_increment not null,
nombreUsuario varchar(100) not null,
contrasena varchar(100) not null,
primary key PK_IDusuarios (IDusuario)
);

create table Palabras(
IDPalabra int auto_increment not null,
nombrePalabra varchar(100)not null,
pistaUno varchar(250)not null,
pistaDos varchar(250)not null,
pistaTres varchar(250)not null,
primary key PK_IDPalabra (IDPalabra)
);

-- PROCEDIMIENTOS ALMACENADOS ---
-- USUARIOS ---

-- CREATE
DELIMITER //
create procedure sp_insertar_usuario(
    in Newnombreusuario varchar(100),
    in Newcontrasena varchar(100)
)
begin
    insert into usuarios (nombreusuario, contrasena)
    values (Newnombreusuario, Newcontraseña);
end //
DELIMITER ;
call sp_insertar_usuario('juan', 'contraseña123');
call sp_insertar_usuario('mlara', 'contraseña456');
call sp_insertar_usuario('eduardoHor', 'contraseña789');
call sp_insertar_usuario('ocumatz', '2021660');
call sp_insertar_usuario('jregil', 'contraseña654');
call sp_insertar_usuario('hor','2025');

-- mOstrar
DELIMITER //
create procedure sp_MostrarUsuarios()
begin
    select * from usuarios;
end //
DELIMITER ;
call sp_MostrarUsuarios();
-- buscar
DELIMITER //
create procedure sp_buscarUsuario(
    in IDusuario int
)
begin
    select * from usuarios where idusuario = IDusuario;
end //
DELIMITER ;
call sp_buscarUsuario(1);
-- Actualizar
DELIMITER //
create procedure sp_actualizarUsuario(
    in Actidusuario int,
    in Actnombreusuario varchar(100),
    in Actcontrasena varchar(100)
)
begin
    update usuarios
    set nombreusuario = Actnombreusuario, contrasena = Actcontrasena
    where idusuario = Actidusuario;
end //
DELIMITER ;
call sp_actualizarUsuario(1,'juan', 'contraseña123');
-- eliminar usuario
DELIMITER //
create procedure sp_eliminarUsuario(
    in EXidusuario int
)
begin
    delete from usuarios where idusuario = EXidusuario;
end //
DELIMITER ;
-- call sp_eliminarUsuario(1);

DELIMITER //
create procedure sp_ValidarUsuario(
	in nameUser varchar(100),
    in pass varchar(100)
    )
		begin
		select * from Usuarios
        where nameUser = nombreUsuario and contrasena = pass;
		end //
DELIMITER ;
call sp_ValidarUsuario('juan', 'contraseña123');
-- Procedimientos almacenados de palabra
-- Crear palabra
DELIMITER //
create procedure sp_insertar_palabra(
    in p_nombrepalabra varchar(100),
    in p_pistauno varchar(250),
    in p_pistados varchar(250),
    in p_pistatres varchar(250)
)
begin
    insert into palabras (nombrepalabra, pistauno, pistados, pistatres)
    values (p_nombrepalabra, p_pistauno, p_pistados, p_pistatres);
end //
DELIMITER ;
call sp_insertar_palabra('motocicleta', 'Objeto pesado', 'Requiere equilibrio en su uso', 'Proporciona mobilidad eficiente');
call sp_insertar_palabra('cuaderno', 'Utensilio escolar', '"material de plastico o carton', 'Variedad de estilos');
call sp_insertar_palabra('carretera', 'Transitas demasiados autos', 'Posee asfalto', 'tiene normas en su uso');
call sp_insertar_palabra('laboratorio', 'Enfoque de investigacion', 'sigue normas de trabajo y seguridad', 'requiere uso profecional');
call sp_insertar_palabra('internet', 'Uso global', 'permite el acceso a multiple informacion', 'Es una inovacion humana');
call sp_insertar_palabra('terremoto', 'Es un desastre natural', 'Genera demasiado movimiento', 'Se genera en grandes magnitudes');

DELIMITER //
create procedure sp_obtener_palabras()
begin
    select * from palabras;
end //
DELIMITER ;
call sp_
DELIMITER //
create procedure sp_obtener_palabra_por_id(
    in p_idpalabra int
)
begin
    select * from palabras where idpalabra = p_idpalabra;
end //
DELIMITER ;
DELIMITER //
create procedure sp_actualizar_palabra(
    in p_idpalabra int,
    in p_nombrepalabra varchar(100),
    in p_pistauno varchar(250),
    in p_pistados varchar(250),
    in p_pistatres varchar(250)
)
begin
    update palabras
    set nombrepalabra = p_nombrepalabra,
        pistauno = p_pistauno,
        pistados = p_pistados,
        pistatres = p_pistatres
    where idpalabra = p_idpalabra;
end //
DELIMITER ;
DELIMITER //
create procedure sp_eliminar_palabra(
    in p_idpalabra int
)
begin
    delete from palabras where idpalabra = p_idpalabra;
end //
DELIMITER ;