CREATE TABLE channels (
    ID uuid not null,
    NAME varchar(100) not null,
    PRIMARY KEY(ID)
);

CREATE TABLE producers (
    ID uuid not null,
    NAME varchar(100) not null,
    CHANNELS_ID_FK uuid not null,
    PRIMARY KEY(ID)
);

CREATE TABLE consumers (
    ID uuid not null,
    NAME varchar(100) not null,
    CHANNELS_ID_FK uuid not null,
    PRIMARY KEY(ID)
);

CREATE TABLE messages (
    ID uuid not null,
    CHANNELS_ID_FK uuid not null,
    CONTENT json(1000) not null,
    PRIMARY KEY(ID)
);

CREATE TABLE messages_sent (
    ID uuid not null,
    CONSUMMERS_ID_FK uuid not null,
    MESAGES_ID_FK uuid not null,
    DELIVERY_TIMESTAMP timestamp not null,
    PRIMARY KEY(ID)
);