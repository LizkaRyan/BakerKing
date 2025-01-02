CREATE TABLE unite(
                      id_unite VARCHAR(100) default 'UNT00'||nextval('seq_unite'),
                      unite VARCHAR(50) NOT NULL,
                      PRIMARY KEY(id_unite),
                      UNIQUE(unite)
);

CREATE TABLE categorie(
                          id_categorie VARCHAR(100) default 'CAT00'||nextval('seq_categorie'),
                          categorie VARCHAR(50) NOT NULL,
                          PRIMARY KEY(id_categorie),
                          UNIQUE(categorie)
);

CREATE TABLE vente(
                      id_vente VARCHAR(100) default 'VNT00'||nextval('seq_vente'),
                      date_vente DATE NOT NULL,
                      montant DECIMAL(15,2) NOT NULL,
                      PRIMARY KEY(id_vente)
);

CREATE TABLE achat(
                      id_achat VARCHAR(100) default 'ACH00'||nextval('seq_achat'),
                      montant DECIMAL(15,2) NOT NULL,
                      date_achat DATE NOT NULL,
                      PRIMARY KEY(id_achat)
);

CREATE TABLE ingredient(
                           id_ingredient VARCHAR(100) default 'ING00'||nextval('seq_ingredient'),
                           ingredient VARCHAR(50) NOT NULL,
                           prix_unitaire DECIMAL(15,2) NOT NULL,
                           id_unite VARCHAR(100) NOT NULL,
                           PRIMARY KEY(id_ingredient),
                           UNIQUE(ingredient),
                           FOREIGN KEY(id_unite) REFERENCES unite(id_unite)
);

CREATE TABLE produit(
                        id_produit VARCHAR(100) default 'PRD00'||nextval('seq_produit'),
                        produit VARCHAR(50) NOT NULL,
                        prix_unitaire DECIMAL(15,2) NOT NULL,
                        id_categorie VARCHAR(100) NOT NULL,
                        PRIMARY KEY(id_produit),
                        UNIQUE(produit),
                        FOREIGN KEY(id_categorie) REFERENCES categorie(id_categorie)
);

CREATE TABLE mvt_stock_ingredient(
                                     id_mvt_stock VARCHAR(100) default 'MSI00'||nextval('seq_mvt_stock_ingredient'),
                                     entree DECIMAL(15,2) NOT NULL,
                                     sortie VARCHAR(50) NOT NULL,
                                     date_mvt DATE NOT NULL,
                                     description VARCHAR(255) NOT NULL,
                                     id_ingredient VARCHAR(100) NOT NULL,
                                     PRIMARY KEY(id_mvt_stock),
                                     FOREIGN KEY(id_ingredient) REFERENCES ingredient(id_ingredient)
);

CREATE TABLE mvt_stock_produit(
                                  id_mvt_stock VARCHAR(100) default 'MSP00'||nextval('seq_mvt_stock_produit'),
                                  entree DECIMAL(15,2) NOT NULL,
                                  sortie VARCHAR(50) NOT NULL,
                                  date_mvt DATE NOT NULL,
                                  description VARCHAR(255) NOT NULL,
                                  id_produit VARCHAR(100) NOT NULL,
                                  PRIMARY KEY(id_mvt_stock),
                                  FOREIGN KEY(id_produit) REFERENCES produit(id_produit)
);

CREATE TABLE vente_details(
                              id_details VARCHAR(50) default 'VTD00'||nextval('seq_vente_details'),
                              quantite INT NOT NULL,
                              montant DECIMAL(15,2) NOT NULL,
                              id_vente VARCHAR(100) NOT NULL,
                              id_produit VARCHAR(100) NOT NULL,
                              PRIMARY KEY(id_details),
                              FOREIGN KEY(id_vente) REFERENCES vente(id_vente),
                              FOREIGN KEY(id_produit) REFERENCES produit(id_produit)
);

CREATE TABLE achat_details(
                              id_details VARCHAR(100) default 'ACD00'||nextval('seq_achat_details'),
                              quantite DECIMAL(15,2) NOT NULL,
                              montant DECIMAL(15,2) NOT NULL,
                              id_achat VARCHAR(100) NOT NULL,
                              id_ingredient VARCHAR(100) NOT NULL,
                              PRIMARY KEY(id_details),
                              FOREIGN KEY(id_achat) REFERENCES achat(id_achat),
                              FOREIGN KEY(id_ingredient) REFERENCES ingredient(id_ingredient)
);

CREATE TABLE ingredient_produit(
                                   id_ingredient VARCHAR(100),
                                   id_produit VARCHAR(100),
                                   quantite DECIMAL(15,2) NOT NULL,
                                   PRIMARY KEY(id_ingredient, id_produit),
                                   FOREIGN KEY(id_ingredient) REFERENCES ingredient(id_ingredient),
                                   FOREIGN KEY(id_produit) REFERENCES produit(id_produit)
);