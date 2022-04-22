
INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_PROFESSOR');
INSERT INTO PERFIL(id, nome) VALUES(2, 'ROLE_ALUNO');

INSERT INTO USUARIO(nome, matricula, senha, dtype) VALUES('Marcio Fernandes', '40028922', '$2a$10$S3hjbOtuLppPQ5ParDsKpOpdZDufaWk4AcqGtVeFI0k/75Ayc576K', 'Professor');
INSERT INTO USUARIO(nome, email, senha, dtype) VALUES('Junior Francisco', '08007777000', '$2a$10$S3hjbOtuLppPQ5ParDsKpOpdZDufaWk4AcqGtVeFI0k/75Ayc576K', 'Aluno');
INSERT INTO USUARIO(nome, email, senha, matricula, dtype) VALUES('Anderson Santos', 'anderson@gmail.com', '$2a$10$S3hjbOtuLppPQ5ParDsKpOpdZDufaWk4AcqGtVeFI0k/75Ayc576K', '10101010', 'Aluno');
INSERT INTO USUARIO(nome, email, senha, matricula, dtype) VALUES('Rakeline Santos', 'rakeline@gmail.com', '$2a$10$S3hjbOtuLppPQ5ParDsKpOpdZDufaWk4AcqGtVeFI0k/75Ayc576K', '123456', 'Aluno');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(1, 1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(2, 2);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(3, 2);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(4, 2);

INSERT INTO TURMA(nome, professor_id) VALUES('Análise e Desenvolvimento de Sistemas', 1);
INSERT INTO TURMA(nome, professor_id) VALUES('Controle e Automação ', 1);

INSERT INTO TURMA(nome, professor_id) VALUES('Controle e Automação ', 1);

