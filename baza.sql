BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "drzava" (
	"glavni_grad"	INTEGER,
	"id"	INTEGER,
	"naziv"	TEXT,
	PRIMARY KEY("id"),
	FOREIGN KEY("glavni_grad") REFERENCES "grad"("id")
);
CREATE TABLE IF NOT EXISTS "grad" (
	"id"	INTEGER,
	"naziv"	TEXT,
	"broj_stanovnika"	INTEGER,
	"drzava"	INTEGER,
	FOREIGN KEY("drzava") REFERENCES "drzava"("id")
);
INSERT INTO "drzava" VALUES (1,1,'Francuska');
INSERT INTO "drzava" VALUES (2,2,'Velika Britanija');
INSERT INTO "drzava" VALUES (3,3,'Austrija');
INSERT INTO "grad" VALUES (1,'Pariz',2200000,1);
INSERT INTO "grad" VALUES (2,'London',8136000,2);
INSERT INTO "grad" VALUES (3,'Beč',1897000,3);
INSERT INTO "grad" VALUES (4,'Manchester',510746,2);
INSERT INTO "grad" VALUES (5,'Graz',283869,3);
COMMIT;
