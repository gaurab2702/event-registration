INSERT INTO authorities (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO users (id, email, enabled, first_name, last_name, last_password_reset_date, password, username) VALUES (1, 'gaurab@example.com', true, 'Gaurab', 'Kumar', NULL, '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'gaurab');
INSERT INTO users (id, email, enabled, first_name, last_name, last_password_reset_date, password, username) VALUES (2, 'admin@example.com', true, 'Admin', 'User', NULL, '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'admin');

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 2);