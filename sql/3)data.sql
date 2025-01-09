INSERT INTO unite (unite) VALUES
                              ('Kilogramme'),
                              ('Grammes'),
                              ('Litre'),
                              ('Piece'),
                              ('Millilitre');

INSERT INTO type_produit(type_produit) VALUES
                                                ('Nature'),
                                                ('Chocolat'),
                                                ('Vanille'),
                                                ('Pomme'),
                                                ('Café');

INSERT INTO categorie (categorie) VALUES
                                      ('Pains'),
                                      ('Viennoiseries'),
                                      ('Pâtisseries'),
                                      ('Boissons');

INSERT INTO ingredient (ingredient, prix_unitaire, id_unite) VALUES
                                                                 ('Farine', 1500, 'UNT001'),
                                                                 ('Sucre', 2000, 'UNT001'),
                                                                 ('Beurre', 3200, 'UNT002'),
                                                                 ('Levure', 1100, 'UNT002'),
                                                                 ('Lait', 2300, 'UNT003'),
                                                                 ('Oeufs', 700, 'UNT004'),
                                                                 ('Chocolat', 1000, 'UNT002'),
                                                                 ('Vanille', 3000, 'UNT002');

INSERT INTO produit (id_type_produit,produit, prix_unitaire, id_categorie) VALUES
                                                               ('TPR001','Baguette', 1000, 'CAT001'),
                                                               ('TPR001', 'Croissant', 1500, 'CAT002'),
                                                               ('TPR002', 'Pain au chocolat', 2000, 'CAT002'),
                                                               ('TPR004', 'Tarte aux pommes', 3050, 'CAT003'),
                                                               ('TPR002', 'Eclair au chocolat', 4000, 'CAT003'),
                                                               ('TPR005', 'Café', 1800, 'CAT004'),
                                                               ('TPR001', 'Thé', 1050, 'CAT004');

INSERT INTO ingredient_produit (id_ingredient, id_produit, quantite) VALUES
                                                                         ('ING001', 'PRD001', 0.5),  -- Farine pour Baguette (500g)
                                                                         ('ING002', 'PRD001', 0.2),  -- Sucre pour Baguette (200g)
                                                                         ('ING003', 'PRD001', 0.15),  -- Beurre pour Baguette (150g)
                                                                         ('ING001', 'PRD002', 0.3),  -- Farine pour Croissant (300g)
                                                                         ('ING002', 'PRD002', 0.1),  -- Sucre pour Croissant (100g)
                                                                         ('ING001', 'PRD003', 0.4),  -- Farine pour Pain au chocolat (400g)
                                                                         ('ING002', 'PRD003', 0.15),  -- Sucre pour Pain au chocolat (150g)
                                                                         ('ING003', 'PRD003', 0.2),  -- Beurre pour Pain au chocolat (200g)
                                                                         ('ING004', 'PRD003', 0.05),   -- Levure pour Pain au chocolat (50g)
                                                                         ('ING001', 'PRD004', 0.7),  -- Farine pour Tarte aux pommes (700g)
                                                                         ('ING002', 'PRD004', 0.2),  -- Sucre pour Tarte aux pommes (200g)
                                                                         ('ING003', 'PRD004', 0.3),  -- Beurre pour Tarte aux pommes (300g)
                                                                         ('ING001', 'PRD005', 0.6),  -- Farine pour Eclair au chocolat (600g)
                                                                         ('ING002', 'PRD005', 0.25),  -- Sucre pour Eclair au chocolat (250g)
                                                                         ('ING003', 'PRD005', 0.15),  -- Beurre pour Eclair au chocolat (150g)
                                                                         ('ING004', 'PRD005', 0.1),  -- Levure pour Eclair au chocolat (100g)
                                                                         ('ING005', 'PRD006', 0.5),  -- Lait pour Café (500ml)
                                                                         ('ING006', 'PRD006', 1),  -- Oeufs pour Café (200g)
                                                                         ('ING005', 'PRD007', 0.3),  -- Lait pour Thé (300ml)
                                                                         ('ING006', 'PRD007', 2);  -- Oeufs pour Thé (150g)

INSERT INTO ingredient_produit (id_ingredient, id_produit, quantite) VALUES ('ING007', 'PRD003', 0.25);  -- Chocolat pour Croissant (250g)

INSERT INTO produit (id_type_produit,produit, prix_unitaire, id_categorie) VALUES
                                                               ('TPR001','Mofo fo paina', 1000, 'CAT001');
INSERT INTO ingredient_produit (id_ingredient, id_produit, quantite) VALUES
                                                                         ('ING001', 'PRD008', 0.5),  -- Farine pour Baguette (500g)
                                                                         ('ING002', 'PRD008', 0.6),  -- Sucre pour Baguette (200g)
                                                                         ('ING003', 'PRD008', 0.25);  -- Beurre pour Baguette (150g)
INSERT INTO production(date_production, quantite, id_produit) VALUES ( '2025-01-07', 3,'PRD001');
INSERT INTO production(date_production, quantite, id_produit) VALUES ( '2025-01-08', 2,'PRD008');
INSERT INTO production(date_production, quantite, id_produit) VALUES ( '2025-01-08', 10,'PRD002');
INSERT INTO production(date_production, quantite, id_produit) VALUES ( '2025-01-08', 4,'PRD003');
INSERT INTO production(date_production, quantite, id_produit) VALUES ( '2025-01-08', 4,'PRD004');
INSERT INTO production(date_production, quantite, id_produit) VALUES ( '2025-01-08', 5,'PRD005');
INSERT INTO production(date_production, quantite, id_produit) VALUES ( '2025-01-08', 5,'PRD006');
INSERT INTO production(date_production, quantite, id_produit) VALUES ( '2025-01-10', 10,'PRD008');