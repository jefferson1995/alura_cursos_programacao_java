create table if not exists tb_users (
    user_id uuid not null,
    email varchar(50) not null unique,
    username varchar(50) not null unique,
    primary key (user_id)
    );


insert into tb_users (user_id, username, email) values (random_uuid(), 'jefferson.barbosa', 'jefferson.bds@teste.com');
insert into tb_users (user_id, username, email) values (random_uuid(), 'jefferson.santo', 'jefferson.santos@teste.com');
insert into tb_users (user_id, username, email) values (random_uuid(), 'jefferson.dos', 'jefferson.dos@teste.com');
