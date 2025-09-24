drop database if exists DB_AhorcadoGAME;
create database DB_AhorcadoGAME;
use DB_AhorcadoGAME;
 
create table usuarios(
Id_Usuario int auto_increment not null,
nombre_Usuario varchar(100) not null,
contrasena varchar(100) not null,
primary key PK_IDusuarios (Id_Usuario)
);

create table Palabras(
Id_Palabra int auto_increment not null,
nombre_Palabra varchar(100)not null,
pista_Uno varchar(250)not null,
pista_Dos varchar(250)not null,
pista_Tres varchar(250)not null,
primary key PK_IDPalabra (Id_Palabra)
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
    insert into usuarios (nombre_Usuario, contrasena)
    values (Newnombreusuario, Newcontraseña);
end //
DELIMITER ;
call sp_insertar_usuario('juan', 'contraseña123');
call sp_insertar_usuario('mlara', 'contraseña456');
call sp_insertar_usuario('eduardoHor', 'contraseña789');
call sp_insertar_usuario('ocumatz', '2021660');
call sp_insertar_usuario('jregil', 'contraseña654');
call sp_insertar_usuario('hor','2025');
call sp_insertar_usuario('1','1');
call sp_insertar_usuario('hugo','1');
call sp_insertar_usuario('pineda','1');
call sp_insertar_usuario('regil','1');


-- mOstrar
DELIMITER //
create procedure sp_MostrarUsuarios()
begin
    select Id_Usuario, nombre_Usuario, contrasena from usuarios;
end //
DELIMITER ;
call sp_MostrarUsuarios();
-- buscar
DELIMITER //
create procedure sp_buscarUsuario(
    in IDusuario int
)
begin
    select Id_Usuario, nombre_Usuario, contrasena from usuarios where Id_Usuario = IDusuario;
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
    set nombre_Usuario = Actnombreusuario, contrasena = Actcontrasena
    where Id_Usuario = Actidusuario;
end //
DELIMITER ;
call sp_actualizarUsuario(1,'juan', 'contraseña123');
-- eliminar usuario
DELIMITER //
create procedure sp_eliminarUsuario(
    in EXidusuario int
)
begin
    delete from usuarios where Id_Usuario = EXidusuario;
end //
DELIMITER ;
-- call sp_eliminarUsuario(1);

DELIMITER //
create procedure sp_ValidarUsuario(
	in nameUser varchar(100),
    in pass varchar(100)
    )
		begin
		select Id_Usuario, nombre_Usuario, contrasena from Usuarios
        where nameUser = nombre_Usuario and contrasena = pass;
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
    insert into palabras (nombre_Palabra, pista_Uno, pista_Dos, pista_Tres)
    values (p_nombrepalabra, p_pistauno, p_pistados, p_pistatres);
end //
DELIMITER ;
call sp_insertar_palabra('motocicleta', 'Objeto pesado', 'Requiere equilibrio en su uso', 'Proporciona mobilidad eficiente');
call sp_insertar_palabra('carretera', 'Transitas demasiados autos', 'Posee asfalto', 'tiene normas en su uso');
call sp_insertar_palabra('laboratorio', 'Enfoque de investigacion', 'sigue normas de trabajo y seguridad', 'requiere uso profecional');
call sp_insertar_palabra('internet', 'Uso global', 'permite el acceso a multiple informacion', 'Es una inovacion humana');
call sp_insertar_palabra('terremoto', 'Es un desastre natural', 'Genera demasiado movimiento', 'Se genera en grandes magnitudes');
call sp_insertar_palabra('tortugas', 'animal marino', 'en peligro de extinción', 'color verdoso');
call sp_insertar_palabra('profesor', 'Area laboral', 'Dirige pequeños grupos', 'Desarrollan diferentes temas');
call sp_insertar_palabra('interruptor', 'utencilio electrico', 'permite el flujo de energia', 'requiere instalación');
call sp_insertar_palabra('licuadora', 'Aparato electronico', 'posee navajas en su interior', 'permite generar liquidos');
call sp_insertar_palabra('computadora', 'posee una pantalla integrada', 'requiere RAM', 'se le pueden conectar puertos');

DELIMITER //
create procedure sp_obtener_palabras()
begin
    select Id_Palabra, nombre_Palabra, pista_Uno, pista_Dos, pista_Tres from palabras;
end //
DELIMITER ;
call sp_
DELIMITER //
create procedure sp_obtener_palabra_por_id(
    in p_idpalabra int
)
begin
    select Id_Palabra, nombre_Palabra, pista_Uno, pista_Dos, pista_Tres from palabras where Id_Palabra = p_idpalabra;
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
        pista_Uno = p_pistauno,
        pista_Dos = p_pistados,
        pista_Tres = p_pistatres
    where Id_Palabra = p_idpalabra;
end //
DELIMITER ;
DELIMITER //
create procedure sp_eliminar_palabra(
    in p_idpalabra int
)
begin
    delete from palabras where Id_Palabra = p_idpalabra;
end //
DELIMITER ;

DELIMITER //
create procedure sp_PalabraRandom()
	begin
		select Id_Palabra, nombre_Palabra, pista_Uno, pista_Dos, pista_Tres from palabras order by rand() limit 1;
    end //
DELIMITER ;    
call sp_PalabraRandom();
