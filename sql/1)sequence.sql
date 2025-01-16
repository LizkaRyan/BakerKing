\c postgres
drop database boulangerie;
create database boulangerie;
\c boulangerie

CREATE SEQUENCE seq_unite;
CREATE SEQUENCE seq_ingredient;
CREATE SEQUENCE seq_mvt_stock_ingredient;
CREATE SEQUENCE seq_achat;
CREATE SEQUENCE seq_achat_details;
CREATE SEQUENCE seq_mvt_stock_produit;
CREATE SEQUENCE seq_produit;
CREATE SEQUENCE seq_categorie;
CREATE SEQUENCE seq_vente_details;
CREATE SEQUENCE seq_vente;
CREATE SEQUENCE seq_production;
CREATE SEQUENCE seq_type_produit;
CREATE SEQUENCE seq_recommandation;
CREATE SEQUENCE seq_client;