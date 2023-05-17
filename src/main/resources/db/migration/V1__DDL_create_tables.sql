CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table doctors
(
    id           UUID                                     DEFAULT uuid_generate_v4() NOT NULL,
    first_name   CHARACTER VARYING(255)                                              NOT NULL,
    patronymic   CHARACTER VARYING(255)                                              NOT NULL,
    last_name    CHARACTER VARYING(255)                                              NOT NULL,
    gender       INT CHECK ( gender >= 0 AND gender <= 1) DEFAULT 0                  NOT NULL,
    position     CHARACTER VARYING(255)                                              NOT NULL,
    phone_number CHARACTER VARYING(255)                                              NOT NULL,
    created_at   TIMESTAMP                                                           NOT NULL,
    updated_at   TIMESTAMP                                                           NOT NULL,
    CONSTRAINT doctor_pk PRIMARY KEY (id)
);

create table patients
(
    id           UUID                                     DEFAULT uuid_generate_v4() NOT NULL,
    first_name   CHARACTER VARYING(255)                                              NOT NULL,
    patronymic   CHARACTER VARYING(255)                                              NOT NULL,
    last_name    CHARACTER VARYING(255)                                              NOT NULL,
    age          INT                                                                 NOT NULL,
    gender       INT CHECK ( gender >= 0 AND gender <= 1) DEFAULT 0                  NOT NULL,
    address      CHARACTER VARYING(255)                                              NOT NULL,
    phone_number CHARACTER VARYING(255)                                              NOT NULL,
    created_at   TIMESTAMP                                                           NOT NULL,
    updated_at   TIMESTAMP                                                           NOT NULL,
    CONSTRAINT patient_pk PRIMARY KEY (id)
);

create table tickets
(
    id            UUID DEFAULT uuid_generate_v4() NOT NULL,
    doctor_id     UUID                            NOT NULL,
    patient_id    UUID                            NOT NULL,
    date_Of_Receipt DATE                            NOT NULL,
    ticket_number CHARACTER VARYING(255)          NOT NULL,
    created_at    TIMESTAMP                       NOT NULL,
    updated_at    TIMESTAMP                       NOT NULL,
    CONSTRAINT ticket_pk PRIMARY KEY (id),
    CONSTRAINT doctor_fk FOREIGN KEY (doctor_id) REFERENCES doctors (id),
    CONSTRAINT patient_fk FOREIGN KEY (patient_id) REFERENCES patients (id)
);


