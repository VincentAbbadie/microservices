INSERT INTO consumers (id, name)
    VALUES('455a1686-e8f8-4dd2-bf00-2fddc57be5a4', 'Customer Service');

INSERT INTO consumers (id, name)
    VALUES('f704b33f-e2c1-4359-8d1b-98d553ac3db5', 'Order Service');

INSERT INTO consumers (id, name)
    VALUES('a60d00bb-d8b1-4097-aa16-73c39f2cedd5', 'Kitchen Service');


INSERT INTO channels (id, name, consumers_id_fk)
    VALUES('86f3c772-ac95-4128-9a9e-736593fb88e1', 'Customer Service request channel', '455a1686-e8f8-4dd2-bf00-2fddc57be5a4');

INSERT INTO channels (id, name, consumers_id_fk)
    VALUES('79ecba6a-f98e-4839-a7ce-9b6aafc7b343', 'Create order saga reply channel', 'f704b33f-e2c1-4359-8d1b-98d553ac3db5');

INSERT INTO channels (id, name, consumers_id_fk)
    VALUES('340c24e0-8ae7-4bd7-abe2-dc937a48439f', 'Kitchen Service request channel', 'a60d00bb-d8b1-4097-aa16-73c39f2cedd5');


INSERT INTO producers (id, name)
    VALUES('751b2f10-746e-4b33-bf89-a54d6d6d9e92', 'Order Service');


INSERT INTO product_to_channel(producers_id_fk, channels_id_fk)
    VALUES('751b2f10-746e-4b33-bf89-a54d6d6d9e92', '86f3c772-ac95-4128-9a9e-736593fb88e1');

