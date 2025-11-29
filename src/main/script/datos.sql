use aeropuerto;
-- Insertar en TipoDocumento
INSERT INTO TipoDocumento (descripcion) VALUES
('DNI'), ('Pasaporte'), ('Carnet Extranjería'), ('Licencia'), ('ID Militar'),
('Visa'), ('Permiso Temporal'), ('Cedula'), ('Documento Nacional'), ('Otro');

-- Insertar en Pasajero
INSERT INTO Pasajero (nombre, documento, telefono, idtipodocumento) VALUES
('Juan Pérez', '12345678', '987654321', 1),
('María López', '87654321', '912345678', 2),
('Carlos Ruiz', '11223344', '999888777', 3),
('Ana Torres', '55667788', '988776655', 4),
('Luis Gómez', '99887766', '977665544', 5),
('Sofía Castro', '44332211', '966554433', 6),
('Pedro Sánchez', '33445566', '955443322', 7),
('Laura Fernández', '22113344', '944332211', 8),
('Diego Morales', '66778899', '933221100', 9),
('Valeria Ríos', '77889900', '922110099', 10);

-- Insertar en Vuelo
INSERT INTO Vuelo (origen, destino, capacidad, ocupados, puerta) VALUES
('Lima', 'Cusco', 180, 90, 1),
('Lima', 'Arequipa', 150, 75, 2),
('Lima', 'Trujillo', 120, 60, 3),
('Lima', 'Piura', 100, 50, 4),
('Lima', 'Iquitos', 130, 65, 5),
('Lima', 'Tacna', 140, 70, 6),
('Lima', 'Chiclayo', 110, 55, 7),
('Lima', 'Pucallpa', 125, 62, 8),
('Lima', 'Juliaca', 135, 67, 9),
('Lima', 'Tumbes', 115, 57, 10);

-- Insertar en Puerta
INSERT INTO Puerta (estado) VALUES
(TRUE), (FALSE), (TRUE), (TRUE), (FALSE),
(TRUE), (TRUE), (FALSE), (TRUE), (TRUE);

-- Insertar en Equipaje
INSERT INTO Equipaje (idpasajero, peso) VALUES
(1, 15.5), (2, 20.0), (3, 18.3), (4, 22.1), (5, 19.8),
(6, 17.0), (7, 16.4), (8, 21.2), (9, 14.9), (10, 23.0);

-- Insertar en Usuario
INSERT INTO Usuario (username, password, rol, nombre) VALUES
('admin', 'admin123', 'Administrador', 'Admin'),
('juanp', 'passjuan', 'Cliente', 'Juan'),
('marial', 'passmaria', 'Cliente', 'Maria'),
('carlosr', 'passcarlos', 'Cliente', 'Carlos'),
('anatorres', 'passana', 'Cliente', 'Ana'),
('luisg', 'passluis', 'Cliente', 'Luis'),
('sofiac', 'passsofia', 'Cliente', 'Sofia'),
('pedros', 'passpedro', 'Cliente', 'Pedro'),
('lauraf', 'passlaura', 'Cliente', 'Laura'),
('diegom', 'passdiego', 'Cliente', 'Diego');
