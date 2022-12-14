DROP TABLE hours;

CREATE TABLE hours (
	day VARCHAR(40) NOT NULL, 
   	opens INTEGER NOT NULL, 
   	closes INTEGER NOT NULL
);


insert into hours values ('sunday', 9, 6);
insert into hours values ('monday', 10, 4);
insert into hours values ('tuesday', 10, 4);
insert into hours values ('wednesday', 10, 5);
insert into hours values ('thursday', 10, 4);
insert into hours values ('friday', 10, 6);
insert into hours values ('saturday', 9, 6);


SELECT opens FROM hours
				WHERE day = 'monday'


SELECT opens FROM hours
				WHERE day = 'monday'
				OR day IS NOT NULL
				OR day = 'sunday'



SELECT * FROM hours;


DELETE FROM hours;

