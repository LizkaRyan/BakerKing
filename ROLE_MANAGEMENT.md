# Gestion des rôles des collaborateurs

## Présentation

Ce système permet de gérer les rôles des collaborateurs (vendeurs) dans l'application BakerKing. Les collaborateurs peuvent avoir deux rôles:

- **USER** : Utilisateur standard (rôle par défaut)
- **ADMIN** : Administrateur avec privilèges étendus

![Interface de gestion des rôles](https://github.com/user-attachments/assets/b08e40b9-3e3a-4abb-92c1-cb12969feb84)

## Comment utiliser le système

### 1. Accès à la gestion des rôles

1. Connectez-vous à l'application BakerKing
2. Dans le menu de navigation, cliquez sur "Administration"
3. Sélectionnez "Gestion des rôles"

### 2. Modifier le rôle d'un collaborateur

1. Dans la liste des vendeurs/collaborateurs, trouvez la personne dont vous voulez modifier le rôle
2. Dans la colonne "Actions", utilisez le menu déroulant pour sélectionner le nouveau rôle
3. Cliquez sur "Modifier" pour confirmer le changement

### 3. Installation/Mise à jour de la base de données

Pour activer le système de rôles, exécutez le script SQL suivant:

```sql
-- Add role column to vendeur table
ALTER TABLE vendeur ADD COLUMN role VARCHAR(50) DEFAULT 'USER';

-- Update existing vendeurs to have USER role by default
UPDATE vendeur SET role = 'USER' WHERE role IS NULL;
```

### 4. Créer un premier administrateur

Pour créer un premier administrateur, exécutez cette requête SQL en remplaçant 'VND001' par l'ID du vendeur:

```sql
UPDATE vendeur SET role = 'ADMIN' WHERE id_vendeur = 'VND001';
```

## Fonctionnalités techniques

### Entités modifiées

- **Vendeur** : Ajout du champ `role` de type `Role`
- **Role** : Nouveau enum avec ADMIN et USER

### Nouveaux services

- **VendeurService** : Service pour la gestion des vendeurs et de leurs rôles

### Nouveaux contrôleurs

- **VendeurController** : Contrôleur pour la gestion des rôles via interface web

### Nouvelles vues

- **gestion-roles.jsp** : Interface de gestion des rôles des collaborateurs