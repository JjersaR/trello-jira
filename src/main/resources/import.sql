INSERT INTO users (created_at, email, name, username) VALUES
('2026-01-20 13:40:10.123456', 'juan.perez@gmail.com', 'Juan', 'jperez'),
('2026-01-20 13:41:05.654321', 'maria.lopez@gmail.com', 'Maria', 'mlopez'),
('2026-01-20 13:42:18.987654', 'carlos.ramirez@gmail.com', 'Carlos', 'cramirez'),
('2026-01-20 13:43:02.456789', 'ana.torres@gmail.com', 'Ana', 'atorres'),
('2026-01-20 13:44:30.112233', 'luis.martinez@gmail.com', 'Luis', 'lmartinez'),
('2026-01-20 13:45:47.223344', 'sofia.gomez@gmail.com', 'Sofia', 'sgomez'),
('2026-01-20 13:46:59.334455', 'diego.hernandez@gmail.com', 'Diego', 'dhernandez'),
('2026-01-20 13:50:39.667788', 'laura.mendoza@gmail.com', 'Laura', 'lmendoza'),
('2026-01-20 13:51:54.778899', 'fernando.ortiz@gmail.com', 'Fernando', 'fortiz'),
('2026-01-20 13:53:08.889900', 'daniela.castro@gmail.com', 'Daniela', 'dcastro'),
('2026-01-20 13:54:21.990011', 'miguel.navarro@gmail.com', 'Miguel', 'mnavarro'),
('2026-01-20 13:55:37.101112', 'andrea.flores@gmail.com', 'Andrea', 'aflores'),
('2026-01-20 13:56:49.212223', 'roberto.vargas@gmail.com', 'Roberto', 'rvargas');

INSERT INTO boards
(created_at, description, name, updated_at, owner_id)
VALUES
('2026-01-20 14:00:10.100001', 'Tablero para tareas personales', 'Tareas Personales', '2026-01-20 14:00:10.100001', 3),
('2026-01-20 14:05:22.200002', 'Seguimiento del proyecto backend', 'Proyecto Backend', '2026-01-20 14:05:22.200002', 7),
('2026-01-20 14:10:35.300003', 'Organización de actividades del equipo', 'Equipo Dev', '2026-01-20 14:10:35.300003', 10),
('2026-01-20 14:15:48.400004', 'Ideas y planeación general', 'Planeación', '2026-01-20 14:15:48.400004', 13);

INSERT INTO `columns`
(name, `position`, board_id) VALUES
-- Board 1
('To Do', 1, 1),
('In Progress', 2, 1),
('Review', 3, 1),
('Done', 4, 1),
-- Board 2
('Backlog', 1, 2),
('In Progress', 2, 2),
('Testing', 3, 2),
('Done', 4, 2),
-- Board 3
('Pendiente', 1, 3),
('En Desarrollo', 2, 3),
('En Revisión', 3, 3),
('Finalizado', 4, 3),
-- Board 4
('Ideas', 1, 4),
('Por Hacer', 2, 4),
('En Proceso', 3, 4),
('Completado', 4, 4);

INSERT INTO cards
(created_at, description, due_date, `position`, priority, title, updated_at, assigned_to, column_id, created_by)
VALUES
('2026-01-20 15:00:01', 'Configurar entorno inicial', '2026-02-05', 1, 'LOW', 'Setup inicial', '2026-01-20 15:00:01', 3, 1, 1),
('2026-01-20 15:01:10', 'Definir requisitos funcionales', '2026-02-06', 1, 'MEDIUM', 'Requisitos', '2026-01-20 15:01:10', 5, 2, 2),
('2026-01-20 15:02:20', 'Diseñar modelo de datos', '2026-02-07', 1, 'HIGH', 'Modelo ER', '2026-01-20 15:02:20', 7, 3, 3),
('2026-01-20 15:03:30', 'Validar entregables', '2026-02-08', 1, 'CRITICAL', 'Validación final', '2026-01-20 15:03:30', 9, 4, 4),

('2026-01-20 15:04:40', 'Crear backlog inicial', '2026-02-09', 1, 'LOW', 'Backlog', '2026-01-20 15:04:40', 2, 5, 5),
('2026-01-20 15:05:50', 'Implementar login', '2026-02-10', 2, 'HIGH', 'Login', '2026-01-20 15:05:50', 6, 6, 6),
('2026-01-20 15:06:55', 'Pruebas unitarias', '2026-02-11', 1, 'MEDIUM', 'Unit tests', '2026-01-20 15:06:55', 8, 7, 7),
('2026-01-20 15:08:00', 'Liberar versión', '2026-02-12', 1, 'CRITICAL', 'Release', '2026-01-20 15:08:00', 10, 8, 8),

('2026-01-20 15:09:15', 'Pendiente de análisis', '2026-02-13', 1, 'LOW', 'Análisis', '2026-01-20 15:09:15', 1, 9, 9),
('2026-01-20 15:10:25', 'Desarrollar API', '2026-02-14', 2, 'HIGH', 'API REST', '2026-01-20 15:10:25', 4, 10, 10),
('2026-01-20 15:11:35', 'Revisión de código', '2026-02-15', 1, 'MEDIUM', 'Code Review', '2026-01-20 15:11:35', 11, 11, 11),
('2026-01-20 15:12:45', 'Cerrar tarea', '2026-02-16', 1, 'LOW', 'Cierre', '2026-01-20 15:12:45', 12, 12, 12),

('2026-01-20 15:13:55', 'Nueva idea funcional', '2026-02-17', 1, 'LOW', 'Idea', '2026-01-20 15:13:55', 13, 13, 13),
('2026-01-20 15:15:05', 'Preparar tareas', '2026-02-18', 1, 'MEDIUM', 'Planificación', '2026-01-20 15:15:05', 6, 14, 2),
('2026-01-20 15:16:15', 'Ejecución principal', '2026-02-19', 2, 'HIGH', 'Ejecución', '2026-01-20 15:16:15', 8, 15, 4),
('2026-01-20 15:17:25', 'Trabajo finalizado', '2026-02-20', 1, 'CRITICAL', 'Final', '2026-01-20 15:17:25', 10, 16, 6);

INSERT INTO comments
(content, created_at, updated_at, author_id, card_id)
VALUES
('Se inició la configuración del entorno sin inconvenientes.',
 '2026-01-20 15:20:00', '2026-01-20 15:20:00', 1, 1),
('Revisar si faltan requisitos no funcionales.',
 '2026-01-20 15:21:10', '2026-01-20 15:22:30', 2, 2),
('El modelo ER contempla todas las entidades principales.',
 '2026-01-20 15:23:15', '2026-01-20 15:23:15', 3, 3),
('Validación pendiente de aprobación final.',
 '2026-01-20 15:24:40', '2026-01-20 15:25:00', 4, 4),
('Backlog inicial cargado correctamente.',
 '2026-01-20 15:26:10', '2026-01-20 15:26:10', 5, 5),
('Login funcional, falta manejo de errores.',
 '2026-01-20 15:27:30', '2026-01-20 15:28:10', 6, 6),
('Las pruebas unitarias cubren el 80% del código.',
 '2026-01-20 15:29:20', '2026-01-20 15:29:20', 7, 7),
('Release generado y enviado a producción.',
 '2026-01-20 15:30:45', '2026-01-20 15:31:00', 8, 8),
('Pendiente definición del alcance.',
 '2026-01-20 15:32:10', '2026-01-20 15:32:10', 9, 9),
('API responde correctamente en pruebas locales.',
 '2026-01-20 15:33:25', '2026-01-20 15:34:00', 10, 10),
('Se sugieren mejoras en nomenclatura de métodos.',
 '2026-01-20 15:35:15', '2026-01-20 15:35:15', 11, 11),
('Tarea cerrada y documentada.',
 '2026-01-20 15:36:40', '2026-01-20 15:36:40', 12, 12),
('Idea interesante, se evaluará en la próxima reunión.',
 '2026-01-20 15:37:55', '2026-01-20 15:38:10', 13, 13),
('Se creó el plan inicial de trabajo.',
 '2026-01-20 15:39:20', '2026-01-20 15:39:20', 3, 14),
('Ejecución en progreso, sin bloqueos.',
 '2026-01-20 15:40:35', '2026-01-20 15:41:00', 5, 15),
('Trabajo finalizado y aprobado.', '2026-01-20 15:42:50', '2026-01-20 15:42:50', 7, 16);

INSERT INTO board_members (board_id, user_id) VALUES
-- Board 1
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
-- Board 2
(2, 3),
(2, 4),
(2, 6),
(2, 7),
(2, 8),
-- Board 3
(3, 1),
(3, 5),
(3, 9),
(3, 10),
(3, 11),
-- Board 4
(4, 2),
(4, 6),
(4, 7),
(4, 12),
(4, 13);
