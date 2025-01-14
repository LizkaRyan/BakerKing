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
                      id_transaction VARCHAR(100) default 'VNT00'||nextval('seq_vente'),
                      montant DECIMAL(15,2) NOT NULL,
                      date_transaction DATE NOT NULL,
                      PRIMARY KEY(id_transaction)
);

CREATE TABLE achat(
                      id_transaction VARCHAR(100) default 'ACH00'||nextval('seq_achat'),
                      montant DECIMAL(15,2) NOT NULL,
                      date_transaction DATE NOT NULL,
                      PRIMARY KEY(id_transaction)
);

CREATE TABLE type_produit(
                             id_type_produit VARCHAR(100) default 'PRC00'||nextval('seq_production'),
                             type_produit VARCHAR(50) NOT NULL,
                             PRIMARY KEY(id_type_produit),
                             UNIQUE(type_produit)
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
                        id_type_produit VARCHAR(100) NOT NULL,
                        id_categorie VARCHAR(100) NOT NULL,
                        PRIMARY KEY(id_produit),
                        UNIQUE(produit),
                        FOREIGN KEY(id_type_produit) REFERENCES type_produit(id_type_produit),
                        FOREIGN KEY(id_categorie) REFERENCES categorie(id_categorie)
);

CREATE TABLE mvt_stock_ingredient(
                                     id_mvt_stock VARCHAR(100) default 'MSI00'||nextval('seq_mvt_stock_ingredient'),
                                     entree DECIMAL(15,2) NOT NULL,
                                     sortie DECIMAL(15,2) NOT NULL,
                                     date_mvt DATE NOT NULL,
                                     description VARCHAR(255) NOT NULL,
                                     id_ingredient VARCHAR(100) NOT NULL,
                                     PRIMARY KEY(id_mvt_stock),
                                     FOREIGN KEY(id_ingredient) REFERENCES ingredient(id_ingredient)
);

CREATE TABLE mvt_stock_produit(
                                  id_mvt_stock VARCHAR(100) default 'MSP00'||nextval('seq_mvt_stock_produit'),
                                  entree DECIMAL(15,2) NOT NULL,
                                  sortie DECIMAL(15,2) NOT NULL,
                                  date_mvt DATE NOT NULL,
                                  description VARCHAR(255) NOT NULL,
                                  id_produit VARCHAR(100) NOT NULL,
                                  PRIMARY KEY(id_mvt_stock),
                                  FOREIGN KEY(id_produit) REFERENCES produit(id_produit)
);

CREATE TABLE vente_details(
                              id_details VARCHAR(50) default 'VTD00'||nextval('seq_vente_details'),
                              quantite INT NOT NULL,
                              prix_unitaire DECIMAL(15,2) NOT NULL,
                              id_transaction VARCHAR(100) NOT NULL,
                              id_produit VARCHAR(100) NOT NULL,
                              PRIMARY KEY(id_details),
                              FOREIGN KEY(id_transaction) REFERENCES vente(id_transaction),
                              FOREIGN KEY(id_produit) REFERENCES produit(id_produit)
);

CREATE TABLE achat_details(
                              id_details VARCHAR(100) default 'ACD00'||nextval('seq_achat_details'),
                              quantite DECIMAL(15,2) NOT NULL,
                              prix_unitaire DECIMAL(15,2) NOT NULL,
                              id_transaction VARCHAR(100) NOT NULL,
                              id_ingredient VARCHAR(100) NOT NULL,
                              PRIMARY KEY(id_details),
                              FOREIGN KEY(id_transaction) REFERENCES achat(id_transaction),
                              FOREIGN KEY(id_ingredient) REFERENCES ingredient(id_ingredient)
);

CREATE TABLE production(
                           id_production VARCHAR(100) default 'PRC00'||nextval('seq_production'),
                           date_production DATE NOT NULL,
                           quantite DECIMAL(15,2) NOT NULL,
                           id_produit VARCHAR(100) NOT NULL,
                           PRIMARY KEY(id_production),
                           FOREIGN KEY(id_produit) REFERENCES produit(id_produit)
);

CREATE TABLE recommandation(
                               id_recommandation VARCHAR(100) default 'RCM00'||nextval('seq_recommandation'),
                               mois INT NOT NULL,
                               annee INT NOT NULL,
                               id_produit VARCHAR(100) NOT NULL,
                               PRIMARY KEY(id_recommandation),
                               FOREIGN KEY(id_produit) REFERENCES produit(id_produit)
);

CREATE TABLE ingredient_produit(
                                   id_ingredient VARCHAR(100),
                                   id_produit VARCHAR(100),
                                   quantite DECIMAL(15,2) NOT NULL,
                                   PRIMARY KEY(id_ingredient, id_produit),
                                   FOREIGN KEY(id_ingredient) REFERENCES ingredient(id_ingredient),
                                   FOREIGN KEY(id_produit) REFERENCES produit(id_produit)
);
