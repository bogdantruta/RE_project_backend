ALTER TABLE platform_user
    ADD COLUMN first_name VARCHAR(255),
    ADD COLUMN last_name VARCHAR(255) ,
    ADD COLUMN email VARCHAR(255) UNIQUE;
commit ;


INSERT INTO platform_user (id, username, password, user_type, created, first_name, last_name, email) VALUES ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'admin', '$2a$10$BN.URS6uErJ3jbMKKBXPX..T9Zmm13jZkELwHWP6Ap9Pu2nVVzWCG', 'ADMIN', '2019-01-01 00:00:00', 'admin', 'account', 'admin@test.com');
INSERT INTO platform_user (id, username, password, user_type, created, first_name, last_name, email) VALUES ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'organization', '$2a$10$BN.URS6uErJ3jbMKKBXPX..T9Zmm13jZkELwHWP6Ap9Pu2nVVzWCG', 'ORGANIZATION', '2019-01-01 00:00:00', 'organization', 'account', 'organization@test.com');
INSERT INTO platform_user (id, username, password, user_type, created, first_name, last_name, email) VALUES ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'user', '$2a$10$BN.URS6uErJ3jbMKKBXPX..T9Zmm13jZkELwHWP6Ap9Pu2nVVzWCG', 'USER', '2019-01-01 00:00:00', 'user', 'account', 'user@test,com');
