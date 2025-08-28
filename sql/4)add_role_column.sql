-- Add role column to vendeur table
ALTER TABLE vendeur ADD COLUMN role VARCHAR(50) DEFAULT 'USER';

-- Update existing vendeurs to have USER role by default
UPDATE vendeur SET role = 'USER' WHERE role IS NULL;

-- You can manually set a vendeur as admin by running:
-- UPDATE vendeur SET role = 'ADMIN' WHERE id_vendeur = 'VND001';