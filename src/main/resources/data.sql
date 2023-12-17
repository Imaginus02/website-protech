INSERT INTO SP_USER_PROFESSOR(id, email, password, username) VALUES (-1, 'tom.reynaud@etu.emse.fr', 'tomlebon', 'Imaginus');

INSERT INTO SP_CODE(id, name, creator_id) VALUES (-1, 'Code1', -1);

INSERT INTO SP_INSTRUCTION(id, name, instruction, code_id, order_in_code) VALUES (-1, 'Couleur Rouge', 'r', -1, 0);
INSERT INTO SP_INSTRUCTION(id, name, instruction, code_id, order_in_code) VALUES (-2, 'Attendre 1 seconde', '1', -1, 1);
INSERT INTO SP_INSTRUCTION(id, name, instruction, code_id, order_in_code) VALUES (-3, 'Eteindre', 'e', -1, 2);

