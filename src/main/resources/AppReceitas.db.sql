BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "users" (
	"id"	INTEGER,
	"nome"	TEXT NOT NULL,
	"email"	TEXT NOT NULL UNIQUE,
	"senhaHash"	TEXT NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "recipes" (
	"id"	INTEGER,
	"titulo"	TEXT NOT NULL,
	"descricao"	TEXT,
	"categoria"	TEXT,
	"tempo_preparo"	INTEGER,
	"imagem_url"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "ingredients" (
	"id"	INTEGER,
	"nome"	TEXT NOT NULL UNIQUE,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "recipe_ingredients" (
	"recipe_id"	INTEGER,
	"ingredient_id"	INTEGER,
	"quantidade"	TEXT,
	FOREIGN KEY("ingredient_id") REFERENCES "ingredients"("id"),
	PRIMARY KEY("recipe_id","ingredient_id"),
	FOREIGN KEY("recipe_id") REFERENCES "recipes"("id")
);
CREATE TABLE IF NOT EXISTS "favorites" (
	"id"	INTEGER,
	"user_id"	INTEGER,
	"recipe_id"	INTEGER,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("user_id") REFERENCES "users"("id"),
	FOREIGN KEY("recipe_id") REFERENCES "recipes"("id")
);
INSERT INTO "users" ("id","nome","email","senhaHash") VALUES (1,'Caua','caua@gmail.com','hash123'),
 (2,'Caua','caua@email.com','hash123');
INSERT INTO "recipes" ("id","titulo","descricao","categoria","tempo_preparo","imagem_url") VALUES (1,'Panqueca','Panqueca doce com mel','Café da manhã',20,NULL);
INSERT INTO "ingredients" ("id","nome") VALUES (1,'Farinha'),
 (2,'Leite'),
 (3,'Ovo');
INSERT INTO "recipe_ingredients" ("recipe_id","ingredient_id","quantidade") VALUES (1,1,'200g'),
 (1,2,'300ml'),
 (1,3,'2 unidades');
INSERT INTO "favorites" ("id","user_id","recipe_id") VALUES (1,1,1);
COMMIT;
