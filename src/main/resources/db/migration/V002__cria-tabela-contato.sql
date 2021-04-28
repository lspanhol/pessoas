create table contato (
	id int not null auto_increment,
    pessoa_id int not null,
    nome varchar(100) not null,
    telefone varchar(30) not null,
    email varchar(100) not null,
    
    primary key (id)
    );
    
    alter table contato add constraint fk_contato_cliente 
    foreign key (pessoa_id) references pessoa (id);