delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;

delete from Ingredient;
insert into Ingredient (id, name, type) values ('FLTO', 'Integralno brasno', 'WRAP');
insert into Ingredient (id, name, type) values ('COTO', 'Kukuruzno brasno', 'WRAP');
insert into Ingredient (id, name, type) values ('GRBF', 'Govodje', 'PROTEIN');
insert into Ingredient (id, name, type) values ('CARN', 'Teletina', 'PROTEIN');
insert into Ingredient (id, name, type) values ('TMTO', 'Paradajz kockice', 'VEGGIES');
insert into Ingredient (id, name, type) values ('LUKA', 'Luk beli', 'VEGGIES');
insert into Ingredient (id, name, type) values ('CHED', 'Cedar', 'CHEESE');
insert into Ingredient (id, name, type) values ('JACK', 'Iriski', 'CHEESE');
insert into Ingredient (id, name, type) values ('SLSA', 'Salsa ljuta', 'SAUCE');
insert into Ingredient (id, name, type) values ('SRCR', 'Salsa blaga', 'SAUCE');