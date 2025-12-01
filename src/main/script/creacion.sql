
CREATE DATABASE IF NOT EXISTS Aeropuerto;
USE Aeropuerto;

-- Tabla TipoDocumento
CREATE TABLE TipoDocumento (
    idtipodocumento INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL
);

-- Tabla Pasajero
CREATE TABLE Pasajero (
    idpasajero INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    documento VARCHAR(50) NOT NULL,
    telefono VARCHAR(20),
    idtipodocumento INT NOT NULL,
    FOREIGN KEY (idtipodocumento) REFERENCES TipoDocumento(idtipodocumento)
);

-- Tabla Vuelo
CREATE TABLE Vuelo (
    idvuelo INT AUTO_INCREMENT PRIMARY KEY,
    origen VARCHAR(100) NOT NULL,
    destino VARCHAR(100) NOT NULL,
    capacidad INT NOT NULL,
    ocupados INT DEFAULT 0,
    puerta INT
);

-- Tabla Puerta
CREATE TABLE Puerta (
    idpuerta INT AUTO_INCREMENT PRIMARY KEY,
    estado BOOLEAN NOT NULL
);

-- Tabla Equipaje
CREATE TABLE Equipaje (
    idequipaje INT AUTO_INCREMENT PRIMARY KEY,
    idpasajero INT NOT NULL,
    peso DOUBLE NOT NULL,
    FOREIGN KEY (idpasajero) REFERENCES Pasajero(idpasajero)
);

-- Tabla TarjetaEmbarque
CREATE TABLE TarjetaEmbarque (
    idtarjetaEmbarque INT AUTO_INCREMENT PRIMARY KEY,
    idpasajero INT NOT NULL,
    asiento VARCHAR(10) NOT NULL,
    idpuerta INT NOT NULL,
    FOREIGN KEY (idpasajero) REFERENCES Pasajero(idpasajero),
    FOREIGN KEY (idpuerta) REFERENCES Puerta(idpuerta)
);

-- Tabla Usuario
CREATE TABLE Usuario (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL
);

DELIMITER //

CREATE PROCEDURE sp_listarpasajero()
BEGIN
    SELECT 
        p.idpasajero,
        p.nombre,
        p.documento,
        p.telefono,
        c.tipodocumento
    FROM pasajero p
    INNER JOIN tipodocumento c ON c.idtipodocumento = p.idtipodocumento;
END //

DELIMITER ;
