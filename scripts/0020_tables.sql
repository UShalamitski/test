CREATE TABLE make
(
    id bigserial NOT NULL,
    name text NOT NULL,
    CONSTRAINT pk_make PRIMARY KEY (id)
);

CREATE TABLE model
(
    id bigserial NOT NULL,
    name text NOT NULL,
    date_start DATE NOT NULL,
    date_end DATE,
    CONSTRAINT pk_model PRIMARY KEY (id)
);

CREATE TABLE make_model
(
    id_make bigint NOT NULL,
    id_model bigint NOT NULL,
    CONSTRAINT pk_make_model PRIMARY KEY (id_make, id_model),
    CONSTRAINT fk_make FOREIGN KEY (id_make) REFERENCES make(id) ON DELETE CASCADE,
    CONSTRAINT fk_model FOREIGN KEY (id_model) REFERENCES model(id) ON DELETE CASCADE
);

INSERT INTO make ("name") VALUES('name1');
INSERT INTO make ("name") VALUES('name2');

INSERT INTO model ("name", "date_start", "date_end") VALUES ('model1', '1999-12-12', '1999-12-12;');
INSERT INTO model ("name", "date_start", "date_end") VALUES ('model2', '1999-12-12', '1999-12-12;');
INSERT INTO model ("name", "date_start", "date_end") VALUES ('model3', '1999-12-12', '1999-12-12;');
INSERT INTO model ("name", "date_start", "date_end") VALUES ('model4', '1999-12-12', '1999-12-12;');

INSERT INTO make_model ("id_make", "id_model") VALUES (1, 1);
INSERT INTO make_model ("id_make", "id_model") VALUES (1, 2);
INSERT INTO make_model ("id_make", "id_model") VALUES (2, 1);
INSERT INTO make_model ("id_make", "id_model") VALUES (2, 2);
