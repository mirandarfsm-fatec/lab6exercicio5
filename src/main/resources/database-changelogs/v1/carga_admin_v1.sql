-- Senha: teste
INSERT INTO tb_usuario (NOME,LOGIN,senha,email,ativo) VALUES ('Admin','admin','698dc19d489c4e4db73e28a713eab07b','admin@admin.com','true');
INSERT INTO tb_usuario_perfil (id_perfil,id_usuario) VALUES ('ROLE_ADMIN',0); 