INSERT INTO channels (id, name)
    VALUES('86f3c772-ac95-4128-9a9e-736593fb88e1', 'Consummer Service request channel');

INSERT INTO producers (id, name, channels_id_fk)
    VALUES('751b2f10-746e-4b33-bf89-a54d6d6d9e92', 'Order Service', '86f3c772-ac95-4128-9a9e-736593fb88e1');

INSERT INTO consumers (id, name, channels_id_fk)
    VALUES('455a1686-e8f8-4dd2-bf00-2fddc57be5a4', 'Consumer Service', '86f3c772-ac95-4128-9a9e-736593fb88e1');