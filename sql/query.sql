CREATE TABLE Users (
    id SERIAL PRIMARY KEY,
    id_house INT4,
    fio VARCHAR(255),
    age int4,
    phone VARCHAR(11),
    email VARCHAR(255),
    FOREIGN KEY (id_house) REFERENCES House (id)
);


CREATE TABLE House (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  address VARCHAR(255)
);

INSERT INTO Users (fio, age, phone, email,id_house ) values ('Хромов Савелий Александрович',26,'87653452354','saveli@mail.ru',1);
INSERT INTO Users (fio, age, phone, email,id_house ) values ('Маркина Диана Эмировна',22,'87653452388','diana32@mail.ru',1);
INSERT INTO Users (fio, age, phone, email,id_house) values ('Панкратова Ксения Мироновна',25,'87653467854','kseniy24@mail.ru',2);

INSERT INTO House (name, address) VALUES ('Жил Строй','Пушкина 1');
INSERT INTO House (name, address) VALUES ('Гранд Алатау','Победа 54');