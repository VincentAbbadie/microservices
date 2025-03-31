CREATE TABLE channels (
    ID uuid not null,
    NAME varchar(100) not null,
    CONSUMERS_ID_FK uuid not null,
    PRIMARY KEY(ID)
);

CREATE TABLE producers (
    ID uuid not null,
    NAME varchar(100) not null,
    PRIMARY KEY(ID)
);

CREATE TABLE product_to_channel (
    PRODUCERS_ID_FK uuid not null,
    CHANNELS_ID_FK uuid not null,
    PRIMARY KEY(PRODUCERS_ID_FK, CHANNELS_ID_FK)
);

CREATE TABLE consumers (
    ID uuid not null,
    NAME varchar(100) not null,
    PRIMARY KEY(ID)
);

CREATE TABLE messages (
    ID uuid not null,
    CHANNELS_ID_FK uuid not null,
    CONTENT json(1000) not null,
    PRIMARY KEY(ID)
);

CREATE TABLE messages_sent (
    MESAGES_ID_FK uuid not null,
    CONSUMERS_ID_FK uuid not null,
    DELIVERY_TIMESTAMP timestamp not null,
    PRIMARY KEY(MESAGES_ID_FK, CONSUMERS_ID_FK)
);