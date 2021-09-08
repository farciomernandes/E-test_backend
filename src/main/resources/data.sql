INSERT INTO USUARIO(nome, matricula, senha) VALUES('Marcio Fernandes', '40028922', '$2a$10$S3hjbOtuLppPQ5ParDsKpOpdZDufaWk4AcqGtVeFI0k/75Ayc576K');
INSERT INTO USUARIO(nome, email, senha) VALUES('Junior Francisco', '08007777000', '$2a$10$S3hjbOtuLppPQ5ParDsKpOpdZDufaWk4AcqGtVeFI0k/75Ayc576K');

INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_PROFESSOR');
INSERT INTO PERFIL(id, nome) VALUES(2, 'ROLE_ALUNO');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(1, 1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(2, 2);

INSERT INTO ALUNO(nome, email, senha, matricula) VALUES('Anderson Santos', 'anderson@gmail.com', '$2a$10$S3hjbOtuLppPQ5ParDsKpOpdZDufaWk4AcqGtVeFI0k/75Ayc576K', '10101010');
INSERT INTO ALUNO(nome, email, senha, matricula) VALUES('Rakeline Santos', 'rakeline@gmail.com', '$2a$10$S3hjbOtuLppPQ5ParDsKpOpdZDufaWk4AcqGtVeFI0k/75Ayc576K', '123456');

INSERT INTO TURMA(nome, avisos, professor_id) VALUES('Análise e Desenvolvimento de Sistemas', 'Nenhum aviso', 1);
INSERT INTO TURMA(nome, avisos, professor_id) VALUES('Controle e Automação ', 'Nenhum aviso', 1);

INSERT INTO TURMA(nome, avisos, professor_id) VALUES('Controle e Automação ', 'Nenhum aviso', 1);

