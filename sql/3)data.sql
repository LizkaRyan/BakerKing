INSERT INTO unite (unite) VALUES
                              ('Kilogramme'),
                              ('Grammes'),
                              ('Litre'),
                              ('Piece'),
                              ('Millilitre');

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

INSERT INTO produit (produit, prix_unitaire, id_categorie) VALUES
                                                               ('Baguette', 1.00, 'CAT001'),
                                                               ('Croissant', 1.50, 'CAT002'),
                                                               ('Pain au chocolat', 2.00, 'CAT002'),
                                                               ('Tarte aux pommes', 3.50, 'CAT003'),
                                                               ('Eclair au chocolat', 4.00, 'CAT003'),
                                                               ('Café', 1.80, 'CAT004'),
                                                               ('Thé', 1.50, 'CAT004');

INSERT INTO ingredient_produit (id_ingredient, id_produit, quantite) VALUES
                                                                         ('ING001', 'PRD001', 0.5),  -- Farine pour Baguette (500g)
                                                                         ('ING002', 'PRD001', 0.2),  -- Sucre pour Baguette (200g)
                                                                         ('ING003', 'PRD001', 0.15),  -- Beurre pour Baguette (150g)
                                                                         ('ING001', 'PRD002', 0.3),  -- Farine pour Croissant (300g)
                                                                         ('ING002', 'PRD002', 0.1),  -- Sucre pour Croissant (100g)
                                                                         ('ING003', 'PRD002', 0.25),  -- Beurre pour Croissant (250g)
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
