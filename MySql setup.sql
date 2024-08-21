use Laraib_data;

select * from customer;
select * from shop;
select * from item;
select * from invoice;
select * from transaction;

insert into customer(customerId, cname, caddress) values("c201", "Alice", "Newyork,US");
insert into customer(customerId, cname, caddress) values("c202", "Bella", "Chennai,IN");

insert into shop(shopId, shopName) values("s1", "toy store");
insert into shop(shopId, shopName) values("s2", "jewelary");
insert into shop(shopId, shopName) values("s3", "shoe shop");

insert into item(itemId, itemDescription, unit, price, shopId) values("t1", "ironman toy", "pcs", 100, "s1");
insert into item(itemId, itemDescription, unit, price, shopId) values("t2", "batman toy", "pcs", 100, "s1");
insert into item(itemId, itemDescription, unit, price, shopId) values("t3", "hulk toy", "pcs", 120, "s1");
insert into item(itemId, itemDescription, unit, price, shopId) values("j1", "gold", "grams", 4500, "s2");
insert into item(itemId, itemDescription, unit, price, shopId) values("j2", "silver", "grams", 70, "s2");
insert into item(itemId, itemDescription, unit, price, shopId) values("it1", "puma shoe", "pcs", 1000, "s3");
insert into item(itemId, itemDescription, unit, price, shopId) values("it2", "addidas shoe", "pcs", 3000, "s3");
insert into item(itemId, itemDescription, unit, price, shopId) values("it3", "rebook shoe", "pcs", 1400, "s3");
