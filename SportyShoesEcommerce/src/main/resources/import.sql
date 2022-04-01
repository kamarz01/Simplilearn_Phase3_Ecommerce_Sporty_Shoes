INSERT INTO USERS (id,name,username,password,userType) VALUES(1,'Kamar','admin','admin','admin');
INSERT INTO USERS (id,name,username,password,userType) VALUES(100,'Test User1','user1','123456','customer');
INSERT INTO USERS (id,name,username,password,userType) VALUES(200,'Test User2','user2','123456','customer');
INSERT INTO USERS (id,name,username,password,userType) VALUES(300,'Test User3','user3','123456','customer');
INSERT INTO USERS (id,name,username,password,userType) VALUES(400,'Test User4','user4','123456','customer');
INSERT INTO USERS (id,name,username,password,userType) VALUES(500,'Test User5','user5','123456','customer');

INSERT INTO CATEGORIES (id,name) VALUES(1000,'Running');
INSERT INTO CATEGORIES (id,name) VALUES(2000,'Trail');
INSERT INTO CATEGORIES (id,name) VALUES(3000,'Field');
INSERT INTO CATEGORIES (id,name) VALUES(4000,'Hiking');
INSERT INTO CATEGORIES (id,name) VALUES(5000,'Gym');
INSERT INTO CATEGORIES (id,name) VALUES(6000,'Court');
INSERT INTO CATEGORIES (id,name) VALUES(7000,'Sandals');

INSERT INTO PRODUCTS (id,name,desc,price,imagePath,CATEGORIES_ID) VALUES(5000,'Wildhorse 7 Trail Running Shoes','Desc1',150,'1.jpg',1000);
INSERT INTO PRODUCTS (id,name,desc,price,imagePath,CATEGORIES_ID) VALUES(6000,'Air Zoom Terra Kiger 8 Trail Running Shoes','Desc2',190,'2.jpg',1000);
INSERT INTO PRODUCTS (id,name,desc,price,imagePath,CATEGORIES_ID) VALUES(7000,'Lone Peak 6 Trail Running Shoes','Desc2',544,'3.jpg',2000);

INSERT INTO PRODUCTS (id,name,desc,price,imagePath,CATEGORIES_ID) VALUES(8000,'Wildhorse 7 Trail Running Shoes','Desc4',520,'1.jpg',4000);
INSERT INTO PRODUCTS (id,name,desc,price,imagePath,CATEGORIES_ID) VALUES(8001,'Air Zoom Terra Kiger 8 Trail Running Shoes','Desc5',2000,'2.jpg',4000);
INSERT INTO PRODUCTS (id,name,desc,price,imagePath,CATEGORIES_ID) VALUES(8002,'Lone Peak 6 Trail Running Shoes','Desc6',147,'3.jpg',7000);

INSERT INTO PRODUCTS (id,name,desc,price,imagePath,CATEGORIES_ID) VALUES(8005,'Wildhorse 7 Trail Running Shoes','Desc7',520,'1.jpg',3000);
INSERT INTO PRODUCTS (id,name,desc,price,imagePath,CATEGORIES_ID) VALUES(8006,'Air Zoom Terra Kiger 8 Trail Running Shoes','Desc8',2000,'2.jpg',5000);
INSERT INTO PRODUCTS (id,name,desc,price,imagePath,CATEGORIES_ID) VALUES(8007,'Lone Peak 6 Trail Running Shoes','Desc9',147,'3.jpg',2000);



