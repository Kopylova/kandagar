ALTER DATABASE resumeloadsystem CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE role CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE user CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
# Roles
INSERT INTO role (id, name) VALUES(1, "Administrator");
INSERT INTO role (id, name) VALUES(2, "Editor");
# Users
INSERT INTO user (id, login, email, name, password, active, role_id) VALUES(1, "admin1", "admin1@mail.ru", "Admin 1", "e00cf25ad42683b3df678c61f42c6bda", 1, 1);
INSERT INTO user (id, login, email, name, password, active, role_id) VALUES(2, "admin2", "admin2@mail.ru", "Admin 2", "c84258e9c39059a89ab77d846ddab909", 1, 1);
INSERT INTO user (id, login, email, name, password, active, role_id) VALUES(3, "editor1", "editor1@mail.ru", "Editor 1", "c9330587565205a5b8345f60c620ecc6", 1, 2);
INSERT INTO user (id, login, email, name, password, active, role_id) VALUES(4, "editor2", "editor2@mail.ru", "Editor 2", "0a96c5e164b4f259b4b8f6f565b55fe2", 1, 2);